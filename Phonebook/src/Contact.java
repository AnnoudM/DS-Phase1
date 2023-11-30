public class Contact implements Comparable<Contact> {

	String name;
	String phonenumber;
	String emailaddress;
	String address;
	String birthday; 
	String notes;
	LinkedList<Event> events ; 


	public Contact() {
		this.name = "";
		this.phonenumber = "";
		this.emailaddress = "";
		this.address = "";
		this.birthday = "";
		this.notes = "";
		events = new LinkedList<Event>();
	}

	public Contact(String name, String phonenumber, String emailaddress, String address, String birthday, String notes) {
		this.name = name;
		this.phonenumber = phonenumber;
		this.emailaddress = emailaddress;
		this.address = address;
		this.birthday = birthday;
		this.notes = notes;
		events = new LinkedList<Event>();
	}

	@Override
	public String toString() {
		return "\nName: " + name +
				"\nPhone Number: " + phonenumber +
				"\nEmail Address: " + emailaddress +
				"\nAddress: " +  address +
				"\nBirthday: " + birthday +
				"\nNotes: " + notes + "\n";
	}
	 public boolean addEvent( Event e)
	    {
	        {
	                if (! events.empty())
	                {
	                    events.findFirst();
	                    for ( int i = 0 ; i < events.size ; i++)
	                    {
	                        if ((events.retrieve().date.compareTo(e.date) == 0) 
	                                && (events.retrieve().time.compareTo(e.time) == 0))
	                            return false;
	                    }
	              }
	            events.insert(e);
	            return true;
	        }
	    }


	@Override
	public int compareTo(Contact c) {
		return (this.name.compareTo(c.name));
	}
    
    public int compareToPhone(String Phone) {
            return (this.phonenumber.compareToIgnoreCase(Phone));
    }

    public int compareToEmail(String emailaddress) {
      
            return (this.emailaddress.compareToIgnoreCase(emailaddress));
    }

    public int compareToAddress(String address) {
    
            return (this.address.compareToIgnoreCase(address));
    }

    public int compareToBirthday(String birthday) {
            return (this.birthday.compareTo(birthday) ) ;
    }
    
    public int comparefName(String fName) { 
    
            String [] firstName = this.name.split(" ");
            return (firstName[0].compareToIgnoreCase(fName) ) ;
      
    }
}

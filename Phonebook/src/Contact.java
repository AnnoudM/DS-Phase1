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
     this.birthday = null;
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

   public boolean addEvent(Event event)
    {
      if (! events.empty())
       {
         events.findFirst();
         for ( int i = 0 ; i < events.size ; i++)
          {
            if ((events.retrieve().date.compareTo(event.date) == 0) && (events.retrieve().time.compareTo(event.time) == 0))
                  return false;
          }
       }
     events.insert(event);
     return true;
    }

    public boolean removeEvent(String eventTitle)
    {
        if (! events.empty()) {
       Event val = new Event();
       val.title = eventTitle;
        if (events.search(val))
         {
            events.remove(val);
            return true;
         }
        }
        return false;
    }
		
    	
    
    @Override
    public int compareTo(Contact c) {
      return (this.name.compareTo(c.name));
    }


}



public class Event implements Comparable<Event> {
	String title;
	String date;
	String time;
	String location;
	Boolean EventType;  //isEvent
	LinkedList <String> ContactsNames;

	public Event() {
		this.title = "";
		this.date = "";
		this.time = "";
		this.location = "";
		this.ContactsNames = new LinkedList<String> ();
	}

	public Event(String title, String date, String time, String location, String contact) {
		this.title = title;
		this.date = date;
		this.time = time;
		this.location = location;
		this.ContactsNames = new LinkedList<String> ();
		ContactsNames.insert(contact);
	}



	@Override
	public String toString() {
		String str = "\nEvent title: " + title +
				"\nEvent date and time (MM/DD/YYYY HH:MM): " + date + " " + time +
				"\nEvent location: " + location + "\n" +
				"\nContacts names:   " ;

		ContactsNames.findFirst();
		for ( int i = 0 ; i < ContactsNames.size ; i++ )
		{
			str += ContactsNames.retrieve() + "\t";
			ContactsNames.findNext();

		}
		return str;
	}
	
	public boolean removeContact(String contact)
    {
            String name = ContactsNames.remove(contact);
            if ( name != null)
                return true; 
            return false;
    }

	@Override
	public int compareTo(Event obj) {
		return(this.title.compareToIgnoreCase(obj.title));

	}

	    public boolean compareToSameEvent(Event obj) {
	       
	            return ((this.title.compareToIgnoreCase(obj.title) == 0) && 
	                    (this.date.compareTo(obj.date) == 0) &&
	                    (this.time.compareToIgnoreCase(obj.time) == 0) && (this.EventType == obj.EventType));
	        }

}

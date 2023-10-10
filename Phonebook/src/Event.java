public class Event implements Comparable<Event> {
    String title;
    String date;
    String time;
    String location;
    LinkedList <String> contacts_names;

    public Event() {
        this.title = "";
        this.date = null;
        this.time = "";
        this.location = "";
        this.contacts_names = new LinkedList<String> ();
    }
    
    public Event(String title, String date, String time, String location, String contact) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.location = location;
        this.contacts_names = new LinkedList<String> ();
        contacts_names.insert(contact);
    }

    public boolean addContact (String contact) {
        contacts_names.insert(contact);
        return true;//edit
    }
    
    public boolean removeContact(String contact) {
    	if (contacts_names.search(contact)) {
    		contacts_names.remove(contact);
    		return true;
    	}
    	return false;
          // String name = contacts_names.remove(contact);
          //if (name != null)
             //   return true; 
          // return false;
    }

    @Override
    public String toString() {
        String str = "\nEvent title: " + title +
                    "\nEvent date and time (MM/DD/YYYY HH:MM): " + date + time +
                   "\nEvent location: " + location + "\n" +
                    "\nContacts names:   " ;
                
        contacts_names.findFirst();
         for ( int i = 0 ; i < contacts_names.size ; i++ )
         {
             str += contacts_names.retrieve() + "\t";
             contacts_names.findNext();
         }
          return str;
    }

    @Override
    public int compareTo(Event obj) {
         return( this.title.compareToIgnoreCase(obj.title));
       
    }

}


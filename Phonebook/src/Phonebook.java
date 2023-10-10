

import java.util.Scanner;


public class Phonebook {

    
    public static Scanner input = new Scanner (System.in);
    public static LinkedList <Contact> contacts = new LinkedList <Contact>();
    public static LinkedList <Event> events = new LinkedList <Event>();
    
    public static int menu(){
    	int choice;
        System.out.println("Please choose an option:");
        System.out.println("1. Add a contact");
        System.out.println("2. Search for a contact");
        System.out.println("3. Delete a contact");
        System.out.println("4. Schedule an event");
        System.out.println("5. Print event details");
        System.out.println("6. Print contacts by first name");
        System.out.println("7. Print all events alphabetically");
        System.out.println("8. Exit");
        System.out.println("\nEnter your choice: ");
         choice = input.nextInt();
         return choice;    
    }
    
    public static int menu_2(){
    	int choice;
        System.out.println("Enter search criteria:");
        System.out.println("1. Name");
        System.out.println("2. Phone Number");
        System.out.println("3. Email Address");
        System.out.println("4. Address");
        System.out.println("5. Birthday");
        System.out.println("\nEnter your choice: ");
         choice = input.nextInt();
        return choice;
    }

    public static int menu_5() {
    	int choice;
        System.out.println("Enter search criteria:");
        System.out.println("1. contact name");
        System.out.println("2. Event tittle");
        System.out.println("\nEnter your choice: ");
        choice = input.nextInt();
        return choice;
    }
    
    //1. Add a contact
    public static void addContact(){ //edit name from AddContact
        Contact contact = new Contact();
        System.out.println("Enter the contact\'s name: ");
        contact.name = input.nextLine();
        contact.name = input.nextLine();
        
        if (!contacts.empty() && contacts.search(contact)){
                System.out.println("Contact found!");
                return;   
                
        }
        System.out.print("Enter the contact's phone number:");
        contact.phonenumber = input.nextLine();
        
        if (!contacts.empty()){
            contacts.findFirst();
            for (int i = 0; i < contacts.size ; i++){
                    if (contacts.retrieve().phonenumber.equals(contact.phonenumber)){
                            System.out.println("Contact found!");
                            return;
                    }
                    contacts.findNext();
            }
        }    
        System.out.print("Enter the contact's email address: ");
        contact.emailaddress = input.nextLine();
        
        System.out.print("Enter the contact's address: ");
        contact.address = input.nextLine();
        
        System.out.print("Enter the contact's birthday: ");
        contact.birthday = input.nextLine();
        
        System.out.print("Enter any notes for the contact: ");
        contact.notes = input.nextLine();
        
        if (contacts.insert(contact))
            System.out.println("Contact added successfully!");
        
    }

    //2. Search for a contact
    public static void SearchContact(){
        int choice = menu_2();
        if (!contacts.empty()) {
            contacts.findFirst();
            switch (choice)
           {
               case 1:
               {
                    System.out.print("Enter the contact\'s name: ");
                    String name = input.nextLine();
                    name = input.nextLine();
                    
                    for (int i = 0; i < contacts.size ; i++)
                    {
                        if (contacts.retrieve().name.compareTo(name) == 0)
                        {
                            System.out.println("Contact found!");
                            System.out.println(contacts.retrieve());
                            break;
                        }
                        contacts.findNext();
                    }
               }
               break;

               case 2:
               {
                   System.out.print("Enter the contact's phone number:");
                   String phonenumber = input.nextLine();
                    phonenumber = input.nextLine();
                   
                    for (int i = 0; i < contacts.size ; i++)
                    {
                        if (contacts.retrieve().phonenumber.equals(phonenumber))
                        {
                            System.out.println("Contact found!");
                            System.out.println(contacts.retrieve());
                            break;
                        }
                        contacts.findNext();
                    }
               }
               break;

               case 3:
               {
                   System.out.print("Enter the contact's email address: ");
                   String emailaddress = input.nextLine();
                   
                    for (int i = 0; i < contacts.size ; i++)
                    {
                        if (contacts.retrieve().emailaddress.equals(emailaddress))
                        {
                            System.out.println("Contact found!");
                            System.out.println(contacts.retrieve());
                        }
                        contacts.findNext();
                    }
               }                
               break;

               case 4:
               {
                   System.out.print("Enter the contact's address: ");
                   String address = input.nextLine();
                   
                    for (int i = 0; i < contacts.size ; i++)
                    {
                        if (contacts.retrieve().address.equals(address))
                        {
                            System.out.println("Contact found!");
                            System.out.println(contacts.retrieve());
                        }
                        contacts.findNext();
                    }
               }
               break;

               case 5:
               {
                   System.out.print("Enter the contact's Birthday: ");
                   String birthday = input.next();
                   
                    for (int i = 0; i < contacts.size ; i++)
                    {
                        if (contacts.retrieve().birthday.equals(birthday))
                        {
                            System.out.println("Contact found!");
                            System.out.println(contacts.retrieve());
                        }
                        contacts.findNext();
                    }
               }
           }
        } else
        System.out.println("Contact not found!");
    }

    
    //3. Delete a contact
    public static void DeleteContact()
    {
Contact c = new Contact();
        
        System.out.print("Enter the contact\'s name: ");
        c.name = input.nextLine();
        c.name = input.nextLine();
        
       if(!contacts.empty()){
    	   c = contacts.remove(c);
    	   
      	 if (c != null) {
    	 if (!c.events.empty())
         {
             c.events.findFirst();
             for( int i = 0 ; i < c.events.size ; i++) {
            	Event e = c.events.retrieve();
            	if(events.search(e)) 
            	events.remove(e);
            	
            	c.events.findNext();
             }
             System.out.println("events deleted!");
         }
      	 }
    		 System.out.println("contact deleted!");
    	
    	 
         }
    	 else 
    		 System.out.println("Contact not found");

    		
    		
    
    }
    
    //4. Schedule an event
    public static void ScheduleEvent()
    {
    	Contact c = new Contact();
        Event e = new Event();
        
        System.out.print("Enter event title: ");
        e.title = input.nextLine();
        e.title = input.nextLine();
        
        System.out.print("Enter contact name: ");
        c.name = input.nextLine();
        
            System.out.print("Enter event date (MM/DD/YYYY): ");
            e.date = input.next();
            
            System.out.print("Enter event time (HH:MM): ");
            e.time = input.next();
            
            System.out.print("Enter event location: ");
            e.location = input.nextLine();
            e.location = input.nextLine();
            
            if ( !contacts.empty() && contacts.search(c) == true)
            {
            	c = contacts.retrieve();
            	
            if (c.addEvent(e)) {
                contacts.update(c);
             if (! events.empty() && events.search(e)) {
            	Event a = events.retrieve();
            	if (a.date.equals(e.date) && a.time.equals(e.time) && a.location.equals(e.location)) 
            		 e.contacts_names.insert(c.name);
             }
            	else {
            		events.insert(e);
            		 e.contacts_names.insert(c.name);
            	}
             System.out.println("Event scheduled successfully!   ");     
            }
            else
                System.out.println("Contact has conflict Event !  ");
                }
        else
            System.out.println("Cantcat not found !");
        
    }
    
    //5. Print event details
    public static void PrintEvent(){
        int choice = menu_5();
        switch ( choice )
        {
            case 1:
            {
                Contact c = new Contact();
                System.out.print("Enter the contact name :  ");
                c.name = input.nextLine();
                c.name = input.nextLine();
                
                if (! contacts.empty() )
                {
                  if (contacts.search(c))
                  {
                    System.out.println("Contact found!");
                    c = contacts.retrieve();

                    c.events.findFirst();

                    for (int i = 0 ; i < c.events.size ; i++)
                    {
                        Event e = c.events.retrieve();
                        if (!events.empty() && events.search(e))
                            System.out.println(events.retrieve());
                        c.events.findNext();
                    }
                    if (c.events.empty())
                        System.out.println("There are no events for this contact!");
                     }
                else
                    System.out.println("Contact not found!");
                }
                else
                    System.out.println("There are no contacts");
            }
            break;

            case 2:
            {
                Event e = new Event();
                System.out.print("Enter the event title:  ");
                e.title = input.nextLine();
                e.title = input.nextLine();
                
                if (!events.empty() && events.search(e))
                {
                    System.out.println("Event found!");
                    System.out.println(events.retrieve());
                }
                else
                    System.out.println("Event not found!");
            }
            break;
            default :
                System.out.println("Wrong Choice!");
        }
    }
    
    //6. Print contacts by first name
    public static void PrintContactsFname(){
       
    	    System.out.println("Enter the first name: ");
    	    String firstName = input.nextLine();
    	    firstName = input.nextLine();

    	    if (!contacts.empty()) {
    	        contacts.findFirst();
    	        for ( int i =0 ; i < contacts.size ; i++) {
    	            Contact c = contacts.retrieve();
    	            String contactFirstName = c.name.split(" ")[0];

    	            if (contactFirstName.equalsIgnoreCase(firstName))
    	                System.out.println(c + "\n");

    	            contacts.findNext();
    	        }
    	    } else {
    	        System.out.println("No Contacts found!");
    	    }
    	}
  
    
    //7. Print all events alphabetically // O(n)
    public static void PrintAllEvents(){
        if (!events.empty())
        {
            events.findFirst();
            for (int i = 0 ; i < events.size ; i++)
            {
                System.out.println((i+1) + ". Event : " + events.retrieve().title);
                events.findNext();
            }
        }
        else
            System.out.println("No events found !");
    }
        
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("Welcome to the Linked List Phonebook!");
        int choice;
        do {
            choice = menu();
            switch (choice)
            {
                case 1:
                    addContact();
                    break;
                
                case 2:
                    SearchContact();
                    break;
                
                case 3:
                    DeleteContact();
                    break;
                
                case 4:
                    ScheduleEvent();
                    break;
                
                case 5:
                    PrintEvent();
                    break;
                    
                case 6:
                	PrintContactsFname();
                    break;
                    
                case 7:
                    PrintAllEvents();
                    break;
                    
                case 8:
                    System.out.println("Goodbye!");
                    break;
                default :
                    System.out.println("Wrong Choice!");
            }
            System.out.println("\n\n");
        }while (choice != 8);
    }
        
}

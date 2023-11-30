

import java.util.Scanner;


public class PhoneBook {
	public static Scanner input = new Scanner (System.in);
	public static contactBST <String, Contact> contacts = new contactBST <String, Contact>();
	public static LinkedList <Event> events = new LinkedList <Event>();

	public static int menu(){
		int option;

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

		option = input.nextInt();
		return option;    
	}

	
	
	public static void addContact(){ 
		Contact contact = new Contact();
		System.out.println("Enter the contact\'s name: ");
		contact.name = input.nextLine();
		contact.name = input.nextLine();

		if (!contacts.empty() && contacts.findkey(contact.name)){
			System.out.println("Contact found!");
			return;       
		}

		System.out.print("Enter the contact's phone number:");
		contact.phonenumber = input.nextLine();

		 if (!contacts.empty() && (contacts.SearchPhone(contact.phonenumber)))
	        {
	            System.out.println("phone number found!");
	            return;
	        }  
		 
		System.out.print("Enter the contact's email address: ");
		contact.emailaddress = input.nextLine();

		System.out.print("Enter the contact's address: ");
		contact.address = input.nextLine();

		System.out.print("Enter the contact's birthday: ");
		contact.birthday = input.nextLine();

		System.out.print("Enter any notes for the contact: ");
		contact.notes = input.nextLine();

		if (contacts.insert(contact.name, contact))
			System.out.println("Contact added successfully!");

	}

	
	
	public static int menu_2(){
		int option;

		System.out.println("Enter search criteria:");
		System.out.println("1. Name");
		System.out.println("2. Phone Number");
		System.out.println("3. Email Address");
		System.out.println("4. Address");
		System.out.println("5. Birthday");
		System.out.println("\nEnter your choice: ");

		option = input.nextInt();
		return option;
	}

	
	public static void SearchContact(){
		int option = menu_2();
		
		
		if (!contacts.empty()) {
			switch (option)
			{
			case 1:
			{
				System.out.print("Enter the contact\'s name: ");
				String name = input.nextLine();
				name = input.nextLine();


                if (!contacts.empty() && contacts.findkey(name))
                {
                    System.out.println("Contact found!");
                    
                    System.out.println(contacts.retrieve().toString());
                    
                        break;
                }
                
                System.out.println("no contact found!");
			}
			break;
			
			
			case 2:
			{
				System.out.print("Enter the contact's phone number:");
				String phonenumber = input.nextLine();
				phonenumber = input.nextLine();

				  if (!contacts.empty() && contacts.SearchPhone(phonenumber))
	                {
	                    System.out.println("Contact found!");
	                    
	                    System.out.println(contacts.retrieve());
	                        break;
	                }
	                
	                System.out.println("no contact found!");
				}
				break;
				

			
			case 3:
			{
				System.out.print("Enter the contact's email address: ");
				String emailaddress = input.nextLine();
				emailaddress = input.nextLine();
                if (!contacts.empty())
                {
                    contacts.SearchEmail(emailaddress);
                    System.out.println("Contact found!");
                    break;
                }
                System.out.println("no contact found!");
           }                
           break;

				
			
			case 4:
			{
				System.out.print("Enter the contact's address: ");
				String address = input.nextLine();
				address = input.nextLine();

				if (!contacts.empty() )
                {
                    contacts.SearchAddress(address);
                    System.out.println("Contact found!");
                    break;
                }
                System.out.println("no contact found!");
           }                
           break;
			
			case 5:
			{
				System.out.print("Enter the contact's Birthday: ");
				String birthday = input.next();

                if (!contacts.empty() )
                {
                    contacts.SearchBirthday(birthday);
                    System.out.println("Contact found!");
                    break;
                }
                System.out.println("no contact found");


	   }
      }
	} 
	}




	
	public static void DeleteContact()
	{
		
Contact c = new Contact();
        
        System.out.print("Enter the contact\'s name: ");
        input.nextLine();
        c.name = input.nextLine();
       
        if (contacts.empty())
            System.out.println("Contact not found!");
        else
        {
            
            if ( ! contacts.findkey(c.name))
                System.out.println("Contact not found!");
            else
            {
                c = contacts.retrieve();
                contacts.removeKey(c.name);
                if (! c.events.empty())
                {
                    c.events.findFirst();
                    for ( int i = 0 ; i < c.events.size ; i++)
                    {
                        Event e = c.events.retrieve();
                        if ( (!events.empty()) && events.search(e) 
                                && (events.retrieve().date.compareTo(e.date)==0) 
                                && (events.retrieve().time.compareTo(e.time)==0)
                                && (events.retrieve().location.compareTo(e.location)==0)
                                && (events.retrieve().EventType== e.EventType))
                        {
                            Event Event2 = events.retrieve();
                            
                            Event2.removeContact(c.name);
                            if ((Event2.EventType==false))//Event2.ContactsNames.empty()
                            {
                                events.remove(e);
                                System.out.println("Delete appointment and contact");
                            }
                            else
                                events.update(Event2);
                            
                        }
                        c.events.findNext();
                    }
                }
                System.out.println("Contact Deleted Successfully !");
                System.out.println(c);
            }    
        }        
	}

	
	 public static int menu_6()
	    {
	        System.out.println("Enter type:");
	        System.out.println("1. event");
	        System.out.println("2. appointment");
	        System.out.println("\nEnter your choice: ");
	        int choice = input.nextInt();
	        return choice;
	    }
	
	public static void ScheduleEvent()
	{
        Contact c = new Contact();
        Event e = new Event();
        
        boolean eventUpdated = false;
        boolean Added_Event_To_Contact = false;
        
        int option = menu_6();
       
        switch(option) {
        case 1 :
        {
           
            e.EventType = true;
            System.out.print("Enter event title: ");
            input.nextLine();
            e.title = input.nextLine();
            
            System.out.print("Enter contacts name separated by a comma: ");
            String line = input.nextLine();
            String [] names = line.split(",");
            
            System.out.print("Enter event date (MM/DD/YYYY): ");
    		e.date = input.next();

    		System.out.print("Enter event time (HH:MM): ");
    		e.time = input.next();

            System.out.print("Enter event location: ");
            input.nextLine();
            e.location = input.nextLine();
            
            for ( int i = 0 ; i < names.length ; i++){    
                c.name = names[i].trim();
        
                if ( ! contacts.empty() && contacts.findkey(c.name) == true)
                {
                    c = contacts.retrieve();
                    Added_Event_To_Contact = c.addEvent(e);
                    if (Added_Event_To_Contact)
                    {
                        // event added to contact
                        contacts.update(c.name,c);
                        if ( (!events.empty()) && events.search(e) 
                                && (events.retrieve().date.compareTo(e.date)==0) 
                                && (events.retrieve().time.compareTo(e.time)==0)
                                && (events.retrieve().location.compareTo(e.location)==0)
                                && (events.retrieve().EventType== e.EventType))
                        {
                            Event eventFound = events.retrieve();
                            eventFound.ContactsNames.insert(c.name);
                            events.update(eventFound);
                            eventUpdated = true;
                        }
                        
                        if (! eventUpdated)  
                        {
                                e.ContactsNames.insert(c.name);
                                events.insert(e);
                        }
                        System.out.println("Event scheduled successfully for " + c.name + "  !");
                    }
                    else
                        System.out.println("Contact has conflict Event for " + c.name + "  !");
                }
                else
                    System.out.println("Cantcat " + c.name + " not found !");                                   
             } // end for 
        }  // end schedule event
        break;
        case 2:
        { // schedule appoinment
            
            e.EventType = false;
            System.out.print("Enter appoinment title: ");
            input.nextLine();
            e.title = input.nextLine();
        
            System.out.print("Enter contact name: ");
            c.name = input.nextLine();
        
            if ( ! contacts.empty() && contacts.findkey(c.name) == true)
            {
                c = contacts.retrieve();
                
                System.out.print("Enter event date (MM/DD/YYYY): ");
        		e.date = input.next();

        		System.out.print("Enter event time (HH:MM): ");
        		e.time = input.next();

                System.out.print("Enter appoinment location: ");
                input.nextLine();
                e.location = input.nextLine();

                if ( (!events.empty()) && events.search(e) 
                        && (events.retrieve().date.compareTo(e.date)==0) 
                        && (events.retrieve().time.compareTo(e.time)==0)
                        && (events.retrieve().location.compareTo(e.location)==0)
                        && (events.retrieve().EventType== e.EventType))
                {
                    System.out.println("Appointment had been scheduled previously, could not add more contacts, try again ");
                }
                else
                {
                    Added_Event_To_Contact = c.addEvent(e);
                    if (Added_Event_To_Contact)
                    {
                        // event added to contact
                        contacts.update(c.name,c);
                        e.ContactsNames.insert(c.name);
                        events.insert(e);
                        System.out.println("Appoinment scheduled successfully!   ");
                    }
                    else
                        System.out.println("Contact has conflict Event/Appoinment !  ");
                    }
            }    
            else
                System.out.println("Cantcat not found !");
        }
        } // end schedule appoinment        
    }
			
	
	public static int menu_5() {
		int option;
		System.out.println("Enter search criteria:");
		System.out.println("1. contact name");
		System.out.println("2. Event tittle");
		System.out.println("\nEnter your choice: ");
		option = input.nextInt();
		return option;
	}

	
	
	
	public static void PrintEvent(){
		int option = menu_5();
		switch ( option )
		{
		
		case 1:
		{
			Contact c = new Contact();
			System.out.print("Enter the contact name :  ");
			c.name = input.nextLine();
			c.name = input.nextLine();

			if (! contacts.empty() )
			{
				if (contacts.findkey(c.name))
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

	
	
	
	public static void PrintContactsFname(){
		   System.out.print("Enter the first name:");
	       String fName = input.next().trim();
	        
	        if (!contacts.empty())
	            contacts.SearchSamefName(fName);
	        else
	          System.out.println("No Contacts found !");
	    }
	
	public static void PrintAllEvents(){
		if (!events.empty())
		{
			int i = 0 ;
			events.findFirst();
			while(i < events.size )
			{
				System.out.println("event "+ ++i + "-" + events.retrieve().title);
				events.findNext();

			}
		}
		else
			System.out.println("No events found !");
	}

	
	
	
	
	
  public static void main(String[] args) {
		
		System.out.println("Welcome to the Linked List Phonebook!");
		int option;
		do {
			option = menu();
			switch (option)
			
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
			
			System.out.println("\n");
		}while (option != 8);
	} 
}

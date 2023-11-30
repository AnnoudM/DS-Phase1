
	public class LinkedList <T extends Comparable<T>>{
	    private Node<T> head;
	    private Node<T> current;
	    int size;
	    
	    public LinkedList () {
	        head = current = null;
	        size = 0;
	    }
	    
	    public boolean empty () {
	        return head == null;
	    }
	    
	    public boolean last () {
	        return current.next == null;
	    }
	    
	    public boolean full () {
	            return false;
	    }
	    
	    public void findFirst () {
	            current = head;
	    }
	    public void findNext () {
	            current = current.next;
	    }
	    public T retrieve () {
	            return current.data;
	    }
	    public void update (T val) {
	            current.data = val;
	    }
	    
	  
	    public boolean insert(T val) {
	           
	            Node<T> tmp;
	            if (empty()) {
	                 current=head=new Node<T> (val);
	            }
	            else {
	                if ( head.getData().compareTo(val) >0)
	                {
	                    tmp = new Node<T>(val);
	                    tmp.setNext(head);
	                    head = tmp;
	                }
	                else
	                {
	                    Node<T> prev = null;
	                    current = head;
	                    
	                    while (( current != null ) && (current.getData().compareTo(val) <= 0))
	                    {
	                        prev = current;
	                        current = current.getNext();
	                    }
	                    tmp = new Node<T> (val);
	                    if ( current != null)
	                    {
	                        tmp.next = current;
	                        prev.next = tmp;
	                        current = tmp;
	                    }
	                    else
	                        current = prev.next =tmp;
	                }
	            }
	            size++;
	            return true;
	    }

	    public boolean search (T val)
	    {
	        if (head == null)
	            return false;
	        
	        Node<T> node  = head;
	        while (node != null) { 
	        	if  (node.getData().compareTo(val) == 0) {
	            current = node;
	            return true;}
	        	else
	            node = node.getNext();}
	        return false;
	        }
	       
	   
	            
	    public T remove (T val) {
	            
	        if (!search (val))
	         return null;

	        T data = current.getData();
	        
	        if (current == head) { //for the first Node
	                head = head.next;
	        }
	        else {
	                Node <T> tmp = head;

	                while (tmp.next != current)
	                        tmp = tmp.next;
	               tmp.next = current.next;
	        }
	        if (current.next == null)
	                current = head;
	        else
	                current = current.next;
	        size -- ;
	        return data;    
	    }

	}

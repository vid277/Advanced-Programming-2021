/* @autrho N Pandya
   March 2016
   LinkedList class
*/
public class LinkedList

{
	// instance fields 

    protected Node start;

    protected Node end ;

    public int size ;

 

    /*  Constructor  */

    public LinkedList()

    {

        //your code goes here

    }

    /*  Function to check if list is empty  */

    public boolean isEmpty()

    {

        //your code goes here

    }

    /*  Function to get size of list  */

    public int getSize()

    {

        //your code goes here

    }    

    /*  Function to insert an element at begining  */

    public void insertAtStart(int val)

    {

        //your code goes here
    }

	
    /*  Function to insert an element at end  */

    public void insertAtEnd(int val)

    {

        //your code goes here
    }

	
    /*  Function to insert an element at position  */

    public void insertAtPos(int val , int pos)

    {

        //your code goes here
    }

    /*  Function to delete an element at position  */

    public void deleteAtPos(int pos)

    {        

        //your code goes here
    }    

    /*  Function to display elements  */

    public void display()
    {

        System.out.println("Please choose one of the Singly Linked List Operations:\n" +
                "\n" +
                "1. insert at begining\n" +
                "2. insert at end\n" +
                "3. insert at position\n" +
                "4. delete at position\n" +
                "5. check empty\n" +
                "6. get size\n")

        Scanner scanner = new Scanner(System.in);
        String line = System.nextLine();


	}

    public static void main(String[] args){
        LinkedList list = new LinkedList();
        list.display();
    }
}
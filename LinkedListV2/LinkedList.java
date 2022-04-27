import java.io.PrintWriter;
import java.util.Scanner;

/* @author N Pandya
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
    public LinkedList(){
         printLinkedList();
    }

    /**
     * This method is used as the menu.
     * This method repeatedly prints the menu and calls the corresponding method
     */
    public void printLinkedList()
    {
        boolean canRun = true;

        //While the program can be run, it should run
        while (canRun) {
            System.out.println("--------------------------------------------------------------------");
            System.out.println("""
                    Please choose one of the Singly Linked List Operations:
                    1. insert at beginning
                    2. insert at end
                    3. insert at position
                    4. delete at position
                    5. check empty
                    6. get size""");

            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();

            if (line.equals("1")) {
                System.out.println("Enter integer element to insert: ");
                insertAtStart(scanner.nextInt());

            } else if (line.equals("2")) {

                System.out.println("Enter integer element to insert: ");
                insertAtEnd(scanner.nextInt());

            } else if (line.equals("3")) {
                System.out.println("Enter integer element to insert: ");
                int element = scanner.nextInt();

                System.out.println("Enter position");
                int position = scanner.nextInt();

                insertAtPos(element, position);

            } else if (line.equals("4")) {
                System.out.println("Enter a position");
                deleteAtPos(scanner.nextInt());
            } else if (line.equals("5")) {
                if(isEmpty()){
                    System.out.println("The list is empty");
                }
                else {
                    System.out.println("The list is NOT empty");
                }
            } else if (line.equals("6")) {
                System.out.println("Size: " + getSize());
            } else {
                System.out.println("Error, Invalid Input!");
                System.out.println("Do you want to continue (Type y or n): ");
                line = scanner.nextLine();
                if (!line.equalsIgnoreCase("y")){
                    //Stops the program
                    canRun = false;
                }
                else {
                    printLinkedList();
                }
            }

            //Asks to continue or stop the program
            System.out.println("Do you want to continue? (Type y or n):");
            line = scanner.nextLine();
            line = scanner.nextLine();

            if (line.equalsIgnoreCase("y")){
                printLinkedList();
            }
            else {
                System.out.println("Bye!");
                //Stops the program
                canRun = false;
            }
        }
    }

    /*  Function to check if list is empty  */
    public boolean isEmpty()
    {
        Node currentNode = start;
        display();

        //returns whether the linked list is empty or not
        return currentNode == null;
    }

    /*  Function to get size of list  */
    public int getSize()

    {
        Node currentNode = start;
        int index = 0;

        //Finds the size of the linked list
        while (currentNode != null){
            index++;
            currentNode = currentNode.link;
        }

        display();

        //the size of the linked list
        return index;
    }

    /*  Function to insert an element at beginning  */
    public void insertAtStart(int val)
    {
        // if the first element is null, the start and end node will be the new node
        if(start == null){
            start = new Node();
            start.setData(val);
            end = start;
        }
        else {
            //Adds the node to the front of the LinkedList
            //The new node is the first node in the linked list
            Node temp = new Node();
            temp.setData(val);
            temp.setLink(start);
            start = temp;
        }
        display();
    }


    /*  Function to insert an element at end  */
    public void insertAtEnd(int val)
    {
        //If the end is null, then the start and the end become the same node
        if(end == null) {
            end = new Node();
            end.setData(val);
            start = end;
        }
        else {
            //Adds the new node to the end of the LinkedList
            //Sets the end of the linked list to the new node
            Node temp = new Node();
            temp.setData(val);

            end.setLink(temp);
            end = temp;
        }

        display();
    }

    /*  Function to insert an element at position  */
    public void insertAtPos(int val , int pos)
    {
        //Creates a new node and initializes the data
        Node node = new Node();
        node.setData(val);

        //Makes sure that the position input by the user is greater than 0
        if(pos > 0){
            //If position is 1, the number is added at the start of the list
            if (pos == 1){
                node.link = start;
                start = node;
            }
            else {
                //Inserting an element by iterating through
                Node currentNode = new Node();
                currentNode = start;

                for(int i = 1; i < pos - 1; i++) {
                    if(currentNode != null) {
                        currentNode = currentNode.link;
                    }
                }

                if(currentNode != null) {
                    node.link = currentNode.link;
                    currentNode.link = node;
                } else {
                    System.out.println("Please choose a valid next index");
                }
            }
        }
        else {
            //If the position input is invalid
            System.out.println("Please input a valid index");
        }

        display();
    }

    /*  Function to delete an element at position  */
    public void deleteAtPos(int pos)
    {
        Node currentNode = start;

        //Makes sure that the list is not empty
        if (start == null)
            System.out.println("List is empty, cannot delete elements.");

        //Deletes the first element of the list
        if (pos == 0)
        {
            start = currentNode.link;
            return;
        }

        //Finding the element to delete
        for (int i = 0; i < pos - 1; i++){
            if (currentNode != null) {
                currentNode = currentNode.link;
        }
    }

        if (currentNode == null || currentNode.link == null)
            return;


        Node next = currentNode.link.link;

        //Getting rid of the extra node
        currentNode.link = next;
        display();
    }

    /*  Function to display elements  */
    public void display()
    {
        Node currentNode = start;
        System.out.print("Singly Linked List: ");

        //Using a while loop to print all the data
        while (currentNode != null){
            //Formatting the output
            System.out.printf("%d -> ", currentNode.getData());
            currentNode = currentNode.link;
        }

        //new line
        System.out.println(" ");
    }

    /**
     * Makes a new object of the LinkedList class.
     * @param args
     */
    public static void main(String[] args){
        new LinkedList();
    }
}
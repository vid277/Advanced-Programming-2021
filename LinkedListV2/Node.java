/**
 * @author npandya March 2016 The Class Node.
 */
class Node

{

    /** The data. */
    protected int data;

    /** The link. */
    protected Node link;

    /* Constructor */

    /**
     * Instantiates a new node.
     */
    public Node()

    {

        link = null;

        data = 0;

    }

    /* Constructor */

    /**
     * Instantiates a new node.
     * 
     * @param d - the data
     * 
     * @param n - the link to the next
     */
    public Node(int d, Node n)

    {

        data = d;
        link = n;

    }

    /* Function to set link to next Node */

    /**
     * Sets the link.
     * 
     * @param n - the new link
     */
    public void setLink(Node n)

    {

        link = n;

    }

    /* Function to set data to current Node */

    /**
     * Sets the data.
     * 
     * @param d
     *            the new data
     */
    public void setData(int d)

    {

        data = d;

    }

    /* Function to get link to next node */

    /**
     * Gets the link.
     * 
     * @return the link
     */
    public Node getLink()

    {

        return link;

    }

    /* Function to get data from current Node */

    /**
     * Gets the data.
     * 
     * @return the data
     */
    public int getData()

    {

        return data;

    }

}

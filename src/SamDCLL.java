/**
 * Doubly Circularly Linked List utilizing generics
 * @param <T> Generic for the data to be stored
 */
public class SamDCLL<T>
{
    /**
     * head node
     */
    Node<T> head;
    /**
     * tail node
     */
    Node<T> tail;
    /**
     * the total number of elements/nodes
     */
    int size;

    /**
     * Constructor intializes size as 0;
     */
    public SamDCLL()
    {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Adds a new node to the DCLL, between the existing tail and head node
     * @param inputData The data to be stored in the new node
     */
    public void add(T inputData)
    {
        if (head == null)
        {
            head = new Node<T>(inputData);
            head.setNextNode(head);
            head.setPrevNode(head);
            tail = head;
        }
        else if (head == tail)
        {
            tail = new Node<T>(inputData);
            head.setNextNode(tail);
            head.setPrevNode(tail);
            tail.setNextNode(head);
            tail.setPrevNode(head);
        }
        else
        {
            tail.setNextNode(new Node<T>(inputData));
            tail.getNextNode().setPrevNode(tail);
            tail = tail.getNextNode();
            tail.setNextNode(head);
            head.setPrevNode(tail);
        }
        size++;
    }

    /**
     * Prints the contents of the DCLL from the head node to the tail node
     */
    public void print()
    {

        if (head != null)
        {
            Node<T> tempNode = head;
            while (tempNode != tail)
            {
                System.out.print(tempNode.getData().toString() + " ");
                tempNode = tempNode.getNextNode();
            }
            System.out.println(tempNode.getData().toString() + " ");
        }

    }

    /**
     * Removes the specified node by location in storage
     * @param inputNode The node to be removed
     */
    public void removeNode(Node<T> inputNode)
    {
        Node<T> leftNode = inputNode.getPrevNode();
        Node<T> rightNode = inputNode.getNextNode();
        leftNode.setNextNode(rightNode);
        rightNode.setPrevNode(leftNode);
        size--;
    }

    /**
     * Returns the head node
     * @return head
     */
    public Node<T> getHead()
    {
        return head;
    }

    /**
     * Returns the size
     * @return size
     */
    public int size()
    {
        return size;
    }
}

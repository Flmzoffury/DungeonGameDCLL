/**
 * A node that stores data of type T, and the next and previous nodes
 * @param <T> The datatype to be stored by the node
 */
public class Node<T>
{
    private T data;
    private Node<T> nextNode;
    private Node<T> prevNode;

    /**
     * Constructor assigns data to the Node
     * @param inputData The data to be stored by the node
     */
    public Node(T inputData)
    {
        data = inputData;
    }

    /**
     * Sets the next node
     * @param inputNode The node to be assigned to nextNode
     */
    public void setNextNode(Node<T> inputNode)
    {
        nextNode = inputNode;
    }

    /**
     * Sets the previous node
     * @param inputNode The node to be assigned to prevNode
     */
    public void setPrevNode(Node<T> inputNode)
    {
        prevNode = inputNode;
    }

    /**
     * Sets the data within the node
     * @param inputData The data to be assigned to data
     */
    public void setData(T inputData)
    {
        data = inputData;
    }

    /**
     * Gets the next node
     * @return nextNode
     */
    public Node<T> getNextNode()
    {
        return nextNode;
    }

    /**
     * Gets the previous node
     * @return prevNode
     */
    public Node<T> getPrevNode()
    {
        return prevNode;
    }

    /**
     * Gets the data in the node
     * @return data
     */
    public T getData()
    {
        return data;
    }


}

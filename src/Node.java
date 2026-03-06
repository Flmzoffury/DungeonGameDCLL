public class Node<T>
{
    private T data;
    private Node<T> nextNode;
    private Node<T> prevNode;

    public Node(T inputData)
    {
        data = inputData;
    }

    public void setNextNode(Node<T> inputNode)
    {
        nextNode = inputNode;
    }

    public void setPrevNode(Node<T> inputNode)
    {
        prevNode = inputNode;
    }

    public void setData(T inputData)
    {
        data = inputData;
    }

    public Node<T> getNextNode()
    {
        return nextNode;
    }

    public Node<T> getPrevNode()
    {
        return prevNode;
    }

    public T getData()
    {
        return data;
    }


}

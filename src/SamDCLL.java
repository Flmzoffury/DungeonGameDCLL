public class SamDCLL<T>
{
    Node<T> head;
    Node<T> tail;
    int size;

    public SamDCLL()
    {
        size = 0;
    }

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

            /*
            Node<T> tempPrev = tail.getPrevNode();
            tail.setPrevNode(new Node<T>(inputData));
            tail.getPrevNode().setNextNode(tail);
            tail.getPrevNode().setPrevNode(tempPrev);
            tempPrev.setNextNode(tail.getPrevNode());*/
        }
        size++;
    }

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

    public Node<T> getHead()
    {
        return head;
    }

    public int size()
    {
        return size;
    }


}

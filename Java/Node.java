package Java;

public class Node {
    public Object data;
    public Node next;

    Node(){
        this(null, null);
    }

    Node(Object data){
        this(data, null);
    }

    Node(Object data, Node next){
        this.data = data;
        this.next = next;
    }
}

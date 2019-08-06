class Node{
    public int value;
    public Node next = null;

    public Node(int value){
        this.value = value;
    }
}
public class Practice {
    public static void display(Node head){
        for(Node cur = head;cur != null;cur = cur.next){
            System.out.printf("%d --> ",cur.value);
        }
        System.out.print("null");
    }

    //头插
    public static Node pushFront(Node head,int value){
        Node node = new Node(value);
        node.next = head;
        return node;
    }

    //尾插
    public static Node pushBack(Node head,int value){
        Node node = new Node(value);
        if(head == null){
            node.next = head;
            return node;
        }else {
            Node last = getLast(head);
            last.next = node;
            return head;
        }
    }

    //获取最后一个结点
    private static Node getLast(Node head){
        Node last = head;
        while(last.next != null){
            last = last.next;
        }
        return last;
    }

    public static void main(String[] args) {
        Node head = null;
        head = pushFront(head,1);
        head = pushFront(head,2);
        head = pushFront(head,3);
       // display(head);

        head = pushBack(head,10);
        head = pushBack(head,20);
        head = pushBack(head,30);
        display(head);
    }
}

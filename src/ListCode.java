class CNode{
    public CNode next;
    public int value;

    public CNode(int value){
        this.next = null;
        this.value = value;
    }


}
public class ListCode {
    //遍历链表
    public static void displayListcode(CNode head){
        for(CNode cur = head ;cur != null;cur = cur.next){
            System.out.printf("%d --> ",cur.value);
        }
        System.out.print("null");
    }

    //头插
    public static CNode pushFront(CNode head,int value){
        CNode node = new CNode(value);
        node.next = head;
        return node;
    }

    //尾插
    public static CNode pushBack(CNode head,int value){
        if(head == null){
           return pushFront(head,value);
        }else {
            CNode newNode = new CNode(value);
            CNode last = getLast(head);
            last.next = newNode;
            return head;
        }
    }

    //获取最后一个结点
    private static CNode getLast(CNode head){
        CNode last = head;
        while(last.next != null){
            last = last.next;
        }
        return last;
    }

    public static CNode creatLinkedList(){
        CNode n1 = new CNode(1);
        CNode n2 = new CNode(2);
        CNode n3 = new CNode(3);
        CNode n4 = new CNode(4);
        CNode n5 = new CNode(5);
        CNode n6 = new CNode(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = null;

        return n1;
    }

    //头删
    public static CNode popFront(CNode head) {
        if (head == null) {
            System.out.println("参数不合法，无法删除空链表的结点");
            return null;
        }
        return head.next;
    }

    //尾删
    public static CNode popBack(CNode head){
            if (head == null) {
                System.out.println("参数不合法，无法删除空链表的结点");
                return null;
            }
            if(head.next == null){
                return null;
            }else{
                //找到倒数第二个结点
                CNode lastLast = getLastLast(head);
                lastLast.next = null;
                return head;
            }
    }

    //找倒数第二个结点
    private static CNode getLastLast(CNode head){
        CNode lastLast = head;
        while (lastLast.next.next != null){
            lastLast = lastLast.next;
        }
        return lastLast;
    }

    public static void main(String[] args) {
        CNode head = creatLinkedList();
        displayListcode(head);

        head = pushFront(head,100);
        displayListcode(head);
        System.out.println();
        head = pushBack(head,666);
        displayListcode(head);

        System.out.println();
        head = null;
        displayListcode(head);
        System.out.println();

        head = pushBack(head,1);
        head = pushBack(head,2);
        head = pushBack(head,3);
        head = pushBack(head,4);
        displayListcode(head);

        head = popFront(head);
        head = popFront(head);
        System.out.println();
        displayListcode(head);

        head = popBack(head);

        System.out.println();
        displayListcode(head);

    }
}

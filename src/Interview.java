import org.omg.CORBA.PUBLIC_MEMBER;

class LNode{
    int val;
    LNode next;
    LNode(int val){
        this.val = val;
    }
}

class Solution{
    public LNode reverseList(LNode head){
        LNode newList = null;
        LNode cur = head;
        while(cur != null){
            LNode next = cur.next;
            cur.next = newList;
            newList = cur;
            cur = next;
        }
        return newList;
    }

    public LNode reverseList0(LNode head){
        LNode n1 = null;
        LNode n2 = head;

        while (n2 != null){
            LNode n3 = n2.next;
            n2.next = n1;

            n1 = n2;
            n2 = n3;
        }
        return n1;
    }

    public LNode reverseList2(LNode head){
        if(head == null){
            return null;
        }
        LNode n1 = null;
        LNode n2 = head;
        LNode n3 = head.next;

        while (n2 != null){
            n2.next = n1;

            n1 = n2;
            n2 = n3;
            if(n3 != null){
                n3 = n3.next;
            }
        }
        return n1;
    }

    public LNode removeElements(LNode head,int val){

        if(head == null){
            return null;
        }
        LNode cur = head.next;
        LNode prev = head;
        while(cur != null){
            if(cur.val == val){
                prev.next = cur.next;
            }else{
                prev = cur;
            }
            cur = cur.next;
        }
        if(head.val == val){
            head = head.next;
        }
        return head;
    }

    public LNode removeElement1(LNode head,int val){
        LNode fakeHead = new LNode(0);
        fakeHead.next = head;

        LNode prev = fakeHead;
        LNode cur = head;
        while (cur != null){
            if(cur.val == val){
                prev.next = cur.next;
            }else {
                prev = cur;
            }
            cur = cur.next;
        }
        return fakeHead.next;
    }

    public LNode removeElement2(LNode head,int val){
        LNode newList = null;
        LNode last = null;
        LNode cur = head;

        while (cur != null){
            LNode next = cur.next;
            if(cur.val != val){

                if(newList == null){
                    cur.next = newList;
                    newList = cur;
                }else {
                    last.next = cur;
                }
                last = cur;
            }
            cur = next;
        }
        if(last != null){
            last.next = null;

        }
        return newList;
    }
    //打印
    public static void print(LNode head){
        for(LNode cur = head;cur != null;cur = cur.next){
            System.out.printf("%d -- >",cur.val);
        }
        System.out.println("null");
    }
}
public class Interview {
    public static void main(String[] args) {
//        System.out.println("测试反转");
//        LNode n1 = new LNode(1);
//        LNode n2 = new LNode(2);
//        LNode n3 = new LNode(3);
//        LNode n4 = new LNode(4);
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = null;
//        Solution s = new Solution();
////        LNode result = s.reverseList(n1);
////        s.print(result);
//        LNode result = s.reverseList0(n1);
//        s.print(result);


        System.out.println("测试删除元素");
        LNode n1 = new LNode(1);
        LNode n2 = new LNode(6);
        LNode n3 = new LNode(2);
        LNode n4 = new LNode(4);
        LNode n5 = new LNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;
        Solution s = new Solution();
        s.removeElement2(n1,6);
        s.print(n1);

    }
}

import java.util.Arrays;

public class SeqList {
    private int[] array;
    private int size;

    //构造方法
    public SeqList(){
        array = new int[11];
        size = 0;
    }

    //头插
    public void pushFront(int element){
        ensureCapacity();
        for(int i = size - 1;i >= 0;i --){
            array[i+1] = array[i];
        }
        array[0] = element;
        size++;
    }

    //尾插
    public void pushBack(int element){
        ensureCapacity();
        array[size++] = element;
    }

    //中间插
    public void insert(int index,int element){
        ensureCapacity();
        //判断index的合法性
        if(index < 0 || index > size){
            System.out.println("下标不合法");
            return;
        }
        for(int i = size - 1;i >= index;i --){
            array[i +1] = array[i];
        }
        array[index] = element;
        size++;
    }

    //头删
    public void popFront(){
        if(size == 0){
            System.out.println("空链表，无法删除");
        }
        for(int i = 1;i < size;i ++){
            array[i - 1] = array[i];
        }
        array[size - 1] = 0;
        size--;
    }

    //尾删
    public void popBack(){

        if(size == 0){
            System.out.println("空链表，无法删除");
        }

        array[size - 1] = 0;
        size--;
    }

    //中间删
    public void erase(int index){
        for(int i = index;i < size - 1;i ++){
            array[i] = array[i + 1];
        }
        array[size - 1] = 0;
        size--;

    }

    //根据下标获取元素
    public int get(int index){
        if(index < 0 || index >= size){
            System.out.println("下标错误");
        }
        return array[index];
    }


    //打印
    public String toString(){
        return Arrays.toString(
                Arrays.copyOf(array,size)
        );
    }
    // 给定下标，修改下标所在元素的值
    public void set(int index,int element){
        array[index]  = element;
    }

    //查找
    public int indexOf(int element){
        for(int i = 0; i < size;i ++){
            if(array[i] == element){
                return i;
            }
        }
        return -1;
    }

    public int size(){
        return size;
    }

    public int capacity(){
        return  array.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void remove (int element){
        int index = indexOf(element);
        if(index != -1){
            erase(index);
        }

    }

    public void removeAll(int element){
        int j = 0;
        for(int i = 0;i < size;i ++){
            if(array[i] != element){
                array[j++] = array[i];
            }
        }
        size = j;
    }

    //扩容
    private void ensureCapacity(){
        if(size < array.length){
            return;

        }
        int newCapacity = array.length + array.length / 2;
        int[] newArray = new int[newCapacity];
        for(int i = 0 ;i < array.length;i ++){
            newArray[i] = array[i];
        }
        this.array = newArray;
    }

    //测试
    public static void test1(){
        SeqList seqList = new SeqList();
        seqList.pushFront(1);
        seqList.pushFront(2);
        seqList.pushFront(3);
        System.out.println(seqList.toString());//[3,2,1]

        seqList.pushBack(4);
        seqList.pushBack(5);
        seqList.pushBack(6);
        System.out.println(seqList.toString());//[3,2,1,4,5,6]

        seqList.insert(1,7);
        seqList.insert(2,8);
        System.out.println(seqList.toString());//[3,7,8,2,1,4,5,6]

        seqList.popFront();
        seqList.popFront();
        seqList.popFront();
        System.out.println(seqList.toString());//[2,1,4,5,6]

        seqList.popBack();
        System.out.println(seqList.toString());//[2,1,4,5]


        System.out.println(seqList.get(1));

        seqList.set(1,3);
        System.out.println(seqList.toString());//[2,3,4,5]


        seqList.erase(2);
        System.out.println(seqList.toString());//[2,3,5]
//
        seqList.remove(2);
        System.out.println(seqList.toString());//[3,5]


        seqList.pushBack(5);
        seqList.pushBack(5);
        seqList.pushBack(5);
        System.out.println(seqList.toString());//[3,5,5,5,5]
        seqList.removeAll(5);
        System.out.println(seqList.toString());//[3]








    }

    public static void main(String[] args) {
        test1();

    }
}

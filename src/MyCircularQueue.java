import java.util.ArrayList;
import java.util.List;

public class MyCircularQueue {

    private List<Integer> data;
    private int p_head;
    private int p_tail;
    private int size=0;

    /**
     * init
     * @param k
     */
    public MyCircularQueue(int k){
        p_head=-1;
        p_tail=-1;
        this.size=k;
        data = new ArrayList<Integer>();
        for (int i = 0; i < k; i++) {
            data.add(0);
        }
    }

    /**
     *add element
     * @param value
     * @return
     */
    public boolean enQueue(int value){
        if (isFull()){
            return false;
        }
        if(isEmpty()){
            p_head=0;
        }
        p_tail =(p_tail +1)%size;
        data.set(p_tail,value);
        return true;
    }

    public boolean deQueue(){
        if(isEmpty()){
            return false;
        }
        if(p_head==p_tail){
            p_head=-1;
            p_tail=-1;
        }else{
            p_head =(p_head +1)%size;
        }
        return true;
    }

    /**
     * get Front
     * @return
     */
    public Integer Front(){
        if(!isEmpty()){
            return data.get(p_head);
        }
        return null;
    }

    /**
     * get last
     * @return
     */
    public Integer Rear(){
        if(!isEmpty()){
            return data.get(p_tail);
        }
        return null;
    }

    /**
     * check empty
     * @return
     */
    public boolean isEmpty(){
        return p_tail == -1;
    }

    /**
     * check full
     * @return
     */
    public boolean isFull(){
        return p_head == (p_tail +1)%size;
    }
};

class MainMyCircularQueue{
    public static void main(String[] args){
        MyCircularQueue q = new MyCircularQueue(6);
        q.enQueue(6);
        System.out.println(q.Rear());
        System.out.println(q.Rear());
        q.deQueue();
        q.enQueue(5);
        System.out.println(q.Rear());
        q.deQueue();
        System.out.println(q.Front());
        q.deQueue();
        q.deQueue();
        q.deQueue();
//        System.out.println("head="+q.Front()+"; tail="+q.Rear());
//        q.enQueue(2);
//        System.out.println("head="+q.Front()+"; tail="+q.Rear());
//        q.enQueue(3);
//        System.out.println("head="+q.Front()+"; tail="+q.Rear());
//        q.enQueue(5);
//        System.out.println("head="+q.Front()+"; tail="+q.Rear());
//        q.deQueue();
//        System.out.println("head="+q.Front()+"; tail="+q.Rear());
//        q.deQueue();
//        System.out.println("head="+q.Front()+"; tail="+q.Rear());
//        q.enQueue(7);
//        System.out.println("head="+q.Front()+"; tail="+q.Rear());

    }
}

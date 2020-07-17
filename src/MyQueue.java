import java.util.ArrayList;
import java.util.List;

public class MyQueue {
    private List<Integer> data;
    private int p_start;

    public MyQueue() {
        data = new ArrayList<Integer>();
        p_start = 0;
    }

    /**
     * insert
     * @return
     */
    public boolean enQueue(int x) {
        data.add(x);
        return true;
    }

    /**
     * delete
     * @return
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        p_start++;
        return true;
    }

    /**
     * get front
     */
    public int Front() {
        return data.get(p_start);
    }

    /**
     * check null
     */
    public boolean isEmpty() {
        return p_start >= data.size();
    }
};

class MainMyQueue {
    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.enQueue(5);
        q.enQueue(3);
        if (!q.isEmpty()) {
            System.out.println(q.Front());
        }
        q.deQueue();
        if (!q.isEmpty()) {
            System.out.println(q.Front());
        }
        q.deQueue();
        if (!q.isEmpty()) {
//            System.out.println("NULL");
            System.out.println(q.Front());
        }
    }
}
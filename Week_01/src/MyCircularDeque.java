


/**
 * @description: 循环双端队列 641
 * @author: 孙彬
   使用链表方式
 */
class MyCircularDeque {

    int count;
    int capacity;
    Node head;
    Node tail;
  

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.capacity = k;
        this.count = 0;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
       if(count == capacity) return false;
        Node newNode = new Node(value);
        if (count == 0) {
            head = tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = head.prev;
        }
        count++;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
       if(count == capacity) return false;
        Node newNode = new Node(value);
        if (count == 0) {
            head = tail = newNode;
        } else {
           tail.next = newNode;
           newNode.prev = tail;
           tail = tail.next;
        }
        count++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
       if (count == 0) return false;
       if (count == 1) 
          head = tail = null;
        else {
            Node nextNode = head.next;
            head.next = null;
            head = nextNode;
            head.prev = null;
        }  
        count--;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (count == 0) return false;
       if (count == 1) 
          head = tail = null;
        else {
            Node prevNode = tail.prev;
           tail.prev = null;
           tail = prevNode;
           tail.next = null;
        }  
        count--;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
       return count == 0 ? -1 : head.val;
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
       return count == 0 ? -1 : tail.val;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return count == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
       return count == capacity;
    }

    static class Node {
        int val;
        Node prev, next;

        Node(int val) {
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }
}
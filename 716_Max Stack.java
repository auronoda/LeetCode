class MaxStack {
    
    private class Node {
        int val;
        Node prev;
        Node next;
        Node another;
        Node(int i) {
            this.val = i;
        }
    }
    
    Node dummyI;
    Node dummyM;
    Node tailI;
    Node tailM;

    /** initialize your data structure here. */
    public MaxStack() {
        dummyI = new Node(0);
        dummyM = new Node(0);
        tailI = dummyI;
        tailM = dummyM;
    }
    
    public void push(int x) {
        Node curI = new Node(x);
        Node curM = new Node(x);
        curI.another = curM;
        curM.another = curI;
        curI.prev = tailI;
        tailI.next = curI;
        tailI = curI;
        
        Node smaller = tailM;
        while (smaller != dummyM && smaller.val > curM.val) {
            smaller = smaller.prev;
        }
        curM.next = smaller.next;
        curM.prev = smaller;
        smaller.next = curM;
        if (curM.next == null) {
            tailM = curM;
        }
        else {
            curM.next.prev = curM;
        }
        
    }
    
    public int pop() {
        Node curI = tailI;
        Node curM = tailI.another;
        tailI = tailI.prev;
        if (curM == tailM) {
            tailM = tailM.prev;
        }
        else {
            curM.next.prev = curM.prev;
        }
        curI.prev.next = curI.next;
        curM.prev.next = curM.next;
        
        curM = null;
        return curI.val;
        
    }
    
    public int top() {
        return tailI.val;
    }
    
    public int peekMax() {
        return tailM.val;
    }
    
    public int popMax() {
        Node curM = tailM;
        Node curI = tailM.another;
        tailM = tailM.prev;
        if (curI == tailI) {
            tailI = tailI.prev;
        }
        else {
            curI.next.prev = curI.prev;
        }
        curI.prev.next = curI.next;
        curM.prev.next = curM.next;
        
        curI = null;
        return curM.val;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */

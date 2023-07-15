
// jahan pr slow and fast pointer milenge
// vahan se slow ko aage bdhana hai
// starting jo head me ek pointer hai usko aage bdhana hai
// start wala and slow jahan milenege that will be the starting point of cycle
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode start = head;

        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                while(slow != start){
                    slow = slow.next;
                    start = start.next;
                }
                return slow;
            }
        }
        return null;
    }

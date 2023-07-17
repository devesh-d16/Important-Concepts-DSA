
// TC - O(N)
// SC - O(1)

    public ListNode deleteMiddle(ListNode head) {
      // if there is one or no element
        if(head == null || head.next == null){
            return null;
        }
        ListNode prev = head;
        ListNode slow = head;
        ListNode fast = head;
// this will take slow to the middle node and fast at last
        while(fast != null && fast.next != null){
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
// we will point the prev pointer to the next element of slow
        prev.next = prev.next.next;
        return head;
    }

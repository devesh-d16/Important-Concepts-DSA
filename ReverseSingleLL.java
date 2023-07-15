
// iterative
// TC - O(N)
// SC - O(1)
public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode curr = head;
        ListNode prev = null;
        ListNode next_node;

        while(curr != null){
            next_node = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next_node;
        }
        head = prev;
        return head;
    }

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        System.out.println(head.val);
        ListNode curr = reverseList(head.next);
        System.out.println(curr.val + " " + head.val);
        head.next.next = head;
        head.next = null;
        return curr;
    }

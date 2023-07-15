
// TC - O(N)
// SC - O(1)

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode middleNode(ListNode head) {
        int l = 0;
        ListNode temp = head;
        while(temp != null){
            l++;
            temp = temp.next;
        }
        temp = head;
        for(int i = 0; i < l/2; i++){
            temp = temp.next;
        }

        return temp;
    }



// TC - O(N)
// SC - O(1)

    public ListNode removeNthFromEnd(ListNode head, int n) {
      // this start dummy node will be before head so that this can handle the case when head hat to be removed
        ListNode start = new ListNode();
        start.next = head;

      // so basically isme krna kya hai ki
      // fast pointer ko 1 to n tk iterate krna hai
      // isse slow and fast pointer ke bich me n ka distance hojayega
      // the fast ko last tk leke jayenge and slow ko bi increase krenge
      // isse slow pointer jisko remove krna hai uske phle wale ko point krega
      // and the we will remove it
        ListNode fast = start;
        ListNode slow = start;

        for(int i = 1; i <= n; i++){
            fast = fast.next;
        }

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return start.next;
    }

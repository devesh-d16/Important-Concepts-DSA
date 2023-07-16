
// TC - O(N)
// SC - O(1)

public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev,temp;

// this loop will make the slow pointer point to the middle element
// and fast pointer to the last element of loop
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

// now we will take a pointer prev and initialise it with slow pointer
        prev = slow;
        slow = slow.next;
        prev.next = null;
// here we will reverse the second half of the linked list
        while(slow != null){
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

// now we will put fast pointer at head
// and slow pointer at the end
        fast = head;
        slow = prev;

        while(slow != null){
          // if the value of slow and fast node is diffrent 
          // then it's not a palindrome
            if(fast.val != slow.val){
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

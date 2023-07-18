// Given the head of a singly linked list, 
// group all the nodes with odd indices together followed by the nodes with even indices, 
// and return the reordered list.
// The first node is considered odd, and the second node is even, and so on.
// Note that the relative order inside both the even and odd groups should remain as it was in the input.
// You must solve the problem in O(1) extra space complexity and O(n) time complexity.

// TC - O(N)
// SC - O(1)

    public ListNode oddEvenList(ListNode head) {

        if(head == null){
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenS = even;

        while(even != null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }

        odd.next = evenS;
        return head; 
    }


    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode oddHead = null;
        ListNode oddTail = null;
        ListNode evenHead = null;
        ListNode evenTail = null;
        ListNode curr = head;

        int i = 1;
        while(curr != null){
            if(i%2 == 1){ // if the index is odd
                if(oddHead == null){ // for first odd node
                    oddHead = curr;
                    oddTail = curr;
                }
                else{ // for odd nodes
                    oddTail.next = curr;
                    oddTail = oddTail.next;
                }
            }
            else{ // for even nodes
                if(evenHead == null){
                    evenHead = curr;
                    evenTail = curr;
                }
                else{
                    evenTail.next = curr;
                    evenTail = evenTail.next;
                }
            }
            curr = curr.next;
            i++;
        }

        evenTail.next = null; // three is no evenNode after this
        oddTail.next = evenHead; // join odd ka tail with even
        return oddHead;
    }

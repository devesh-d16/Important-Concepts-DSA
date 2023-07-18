    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        ListNode temp2 = headB;

        int ac = 0; // to store length of 1st ll
        int bc = 0; // to store length of 2nd ll

        while(temp1 != null){
            ac++;
            temp1 = temp1.next;
        }
        while(temp2 != null){
            bc++;
            temp2 = temp2.next;
        }

      // ab we will do ki loop chlayenge so that ki dono ka same length ke node pe pahuch jaye
        while(ac > bc){
            ac--;
            headA = headA.next;
        }
        while(bc > ac){
            bc--;
            headB = headB.next;
        }

      // then we will return the first node jiski value same hogi
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

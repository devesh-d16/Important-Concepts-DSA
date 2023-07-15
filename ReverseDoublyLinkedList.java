    public static Node reverseDLL(Node head)
    {
        if(head == null || head.next == null){
            return head;
        }

        Node curr = head;
        Node temp = null;

        while(curr != null){
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }

        head = temp.prev;
        return head;
    }

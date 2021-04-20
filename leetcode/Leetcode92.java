public class Leetcode92 {

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Leetcode 92题
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left==right)
            return head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head.next;
        ListNode last = head;
        for (int i=0;i<right-left;i++)
            last = last.next;

        for (int i=1;i<left;i++)
        {
            if (pre==null)
                pre = head;
            else
            {
                pre = pre.next;
            }
            cur = cur.next;
            next = next.next;
            last = last.next;
        }
        if (pre!=null)
            pre.next = last;
        cur.next = last.next;
        while (next!=last)
        {
            ListNode temp = next.next;
            next.next = cur;
            cur = next;
            next = temp;
        }
        next.next = cur;
        if (pre==null)
            head = last;
        return head;
    }

}

public class Leetcode206 {

      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        if (head==null)
            return head;
        ListNode next = head.next;

        while (next!=null)
        {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
        }
        cur.next = pre;  //这一步不要忘记了
        return cur;
    }
}

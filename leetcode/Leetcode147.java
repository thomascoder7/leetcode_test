public class Leetcode147 {

      public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode insertionSortList(ListNode head) {

          if (head==null||head.next==null)
              return head;

          ListNode temp_head = new ListNode(0);
          temp_head.next = head;

          ListNode cur = head.next;
          ListNode temp = temp_head;
          while (cur!=null)
          {
              if (cur.val<head.val)
              {
                  while (temp.next.val<cur.val)
                  {
                      temp = temp.next;
                  }
                  head.next = cur.next;
                  cur.next = temp.next;
                  temp.next = cur;

                  cur = head.next;
                  temp = temp_head;
              }
              else
              {
                  head = head.next;
                  cur = cur.next;
              }
          }
          return temp_head.next;

    }

    // Leetcode148
    public ListNode sortList(ListNode head) {
          if (head==null||head.next==null)
              return head;

          int length = 0;
          ListNode dummyHead = new ListNode(0);
          dummyHead.next = head;
          ListNode pre = dummyHead;

          while (head!=null)
          {
              length+=1;
              head = head.next;
          }

          for (int curLength=1;curLength<length;curLength<<=1)
          {
              pre = dummyHead;
              ListNode cur = dummyHead.next;
              while (cur!=null)
              {
                  ListNode head1 = cur;
                  for (int temp=1;temp<curLength&&cur!=null&&cur.next!=null;temp++)
                  {
                      cur = cur.next;
                  }

                  ListNode head2 = cur.next;
                  cur.next = null;
                  cur = head2;
                  for (int temp=1;temp<curLength&&cur!=null&&cur.next!=null;temp++)
                  {
                      cur = cur.next;
                  }
                  if (head2==null)
                  {
                      pre.next = head1;
                      break;
                  }
                  //断掉这部分与后面部分的连接
                  ListNode tempNext = cur.next;
                  cur.next = null;
                  cur = tempNext;

                  ListNode merged = merge(head1,head2);
                  pre.next = merged;
                  while (pre.next!=null)
                      pre = pre.next;
              }
          }
        return dummyHead.next;
    }

    public ListNode merge(ListNode head1,ListNode head2) {
          ListNode res = null;
          ListNode head = null;
          if (head1.val<head2.val)
          {
              res = head1;
              head = res;
              head1 = head1.next;
          }
          else
          {
              res = head2;
              head = res;
              head2 = head2.next;
          }
          while (head1!=null&&head2!=null)
          {
              if (head1.val<head2.val)
              {
                  res.next = head1;
                  res = res.next;
                  head1 = head1.next;
              }
              else
              {
                  res.next = head2;
                  res = res.next;
                  head2 = head2.next;
              }
          }
          if (head1!=null)
              res.next = head1;
          if (head2!=null)
              res.next = head2;
          return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        Leetcode147 leetcode147 = new Leetcode147();
        leetcode147.sortList(l1);
    }


}

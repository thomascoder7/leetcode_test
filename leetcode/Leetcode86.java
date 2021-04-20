public class Leetcode86 {


      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }


    public ListNode partition(ListNode head, int x) {
          if (head==null)
              return head;
          ListNode temp1 = null;
          ListNode temp2 = null;
          ListNode temp_head = null;

          ListNode cur = head;
          while (cur!=null)
          {
              if (cur.val<x)
              {
                  if(temp1==null)
                  {
                      temp1 = cur;
                      head = cur;
                  }
                  else
                  {
                      temp1.next = cur;
                      temp1 = temp1.next;
                  }

              }
              else if (cur.val>=x)
              {
                  if (temp2==null)
                  {
                      temp2 = cur;
                      temp_head = cur;
                  }
                  else
                  {
                      temp2.next = cur;
                      temp2 = temp2.next;
                  }

              }
              cur = cur.next;
          }
          if (temp1==null)
          {
              head = temp_head;
          }
          else
          {
              temp1.next = temp_head;
          }
          if (temp2!=null)
              temp2.next = null;
          return head;

    }

    // Leetcode 328
    public ListNode oddEvenList(ListNode head) {
        if (head==null)
            return head;
        int i=2;
        if (head.next==null)
            return head;
        ListNode cur = head;
        ListNode temp_head = head.next;
        ListNode odd = head.next;
        while (cur.next!=null)
        {
            cur.next = odd.next;
            if (odd.next==null)
                break;
            odd.next = cur.next.next;
            odd = odd.next;
            cur = cur.next;
        }
        cur.next = temp_head;
        return head;
    }

    // Leetcode 2
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int temp = 0;
        ListNode head = l1;
        while (l1!=null&&l2!=null)
        {
            if (l1.val+l2.val+temp>=10)
            {
                l1.val = (l1.val+l2.val+temp)%10;
                temp = 1;
            }
            else
            {
                l1.val = l1.val+l2.val+temp;
                temp = 0;
            }
            l2 = l2.next;
            if (l1.next==null)
            {
                l1.next = l2;
                l2=null;
                break;
            }
            else if (l1.next!=null&&l2!=null)
                l1 = l1.next;

        }
        while (l1.next!=null)
        {
            l1 = l1.next;
            if (temp!=0)
            {
                if (l1.val+temp>=10)
                {
                    l1.val = (l1.val+temp)%10;
                    temp = 1;
                }
                else
                {
                    l1.val = l1.val+temp;
                    temp = 0;
                    break;
                }
            }
        }
        if (temp!=0)
        {
            l1.next = new ListNode(1,null);
        }

        return head;
    }


}

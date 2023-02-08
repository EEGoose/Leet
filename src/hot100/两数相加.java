package hot100;

/**
 * @author: EEGoose
 * @since: 2023-01-17 10:11
 */
public class 两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        int val = l1.val + l2.val;
        boolean jinwei = false;
        if (val > 9) {
            jinwei = true;
        }
        result.val = val % 10;
        ListNode p = result;
        while (jinwei || (null != l1 && null != l1.next) || (null != l2 && null != l2.next)) {
            int val1 = 0;
            if (null != l1) {
                l1 = l1.next;
                if (null != l1) {
                    val1 = l1.val;
                }
            }

            int val2 = 0;
            if (null != l2) {
                l2 = l2.next;
                if (null != l2) {
                    val2 = l2.val;
                }
            }

            int val0 = 0;
            if (jinwei) {
                val0 = 1;
            }
            ListNode next = new ListNode();
            int sum = val0 + val1 + val2;
            if (sum > 9) {
                jinwei = true;
            } else {
                jinwei = false;
            }
            next.val = sum%10;
            p.next = next;
            p = next;
        }
        return result;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }
}



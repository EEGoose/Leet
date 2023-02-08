package hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: EEGoose
 * @since: 2023-01-18 16:16
 */
public class 环形链表 {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            slow = slow.next;
            if (null == slow) {
                break;
            }
            fast = fast.next;
            if (null == fast) {
                break;
            }
            fast = fast.next;
            if (null == fast) {
                break;
            }
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {

        Set<ListNode> set = new HashSet<>();

        while (head != null) {
            if (set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}

package hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: EEGoose
 * @since: 2023-01-28 10:32
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class 相交链表 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (true) {
            if (null == headA && null == headB) {
                return null;
            }

            if (null != headA) {
                if (!set.add(headA)) {
                    return headA;
                } else {
                    headA = headA.next;
                }
            }

            if (null != headB) {
                if (!set.add(headB)) {
                    return headB;
                } else {
                    headB = headB.next;
                }
            }

        }
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (null == headA || null == headB) {
            return null;
        }

        ListNode pA = headA;
        boolean changeA = false;

        ListNode pB = headB;
        boolean changeB = false;

        while (true) {
            if (null == pA && null == pB) {
                return null;
            }

            if (pA.equals(pB)) {
                return pA;
            }

            pA = pA.next;
            pB = pB.next;

            if (null == pA && !changeA) {
                pA = headB;
                changeA = true;
            }


            if (null == pB && !changeB) {
                pB = headA;
                changeB = true;
            }

        }
    }
}
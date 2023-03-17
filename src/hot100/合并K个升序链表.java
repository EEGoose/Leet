package hot100;

/**
 * @author: EEGoose
 * @since: 2023-03-17 15:27
 */
public class 合并K个升序链表 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return fenzhi(lists, 0, lists.length - 1);
    }

    static private ListNode fenzhi(ListNode[] lists, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return lists[startIndex];
        }

        if (endIndex - startIndex == 1) {
            return merge(lists[startIndex], lists[endIndex]);
        }

        return merge(fenzhi(lists, startIndex, (endIndex - startIndex) / 2 + startIndex), fenzhi(lists,
                (endIndex - startIndex) / 2 + startIndex + 1, endIndex));
    }

    private static ListNode merge(ListNode one, ListNode two) {
        if (null == one && null == two) {
            return null;
        }
        if (null == one || null == two) {
            return null == one ? two : one;
        }
        ListNode x = null;
        if (one.val <= two.val) {
            x = one;
            one = one.next;
        } else {
            x = two;
            two = two.next;
        }
        ListNode start = x;

        while (true) {
            if (one == null) {
                x.next = two;
                break;
            }
            if (two == null) {
                x.next = one;
                break;
            }
            if (one.val <= two.val) {
                x.next = one;
                one = one.next;
            } else {
                x.next = two;
                two = two.next;
            }
            x = x.next;
        }
        return start;
    }

    public static void main(String[] args) {

        ListNode one = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode two = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode three = new ListNode(2, new ListNode(6));

        ListNode[] nodes = {one, two, three};
        ListNode[] nodes2 = {null, null, null, null, null, null, null, null, null, null};
        ListNode listNode = mergeKLists(nodes2);
        while (null != listNode) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

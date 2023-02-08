package hot100;

/**
 * @author: EEGoose
 * @since: 2023-01-17 11:28
 */
public class 合并两个有序联表 {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p = new ListNode();
        ListNode listNode = p;
        while (null != list1 && null != list2) {
            ListNode q =  new ListNode();
            if (list1.val <= list2.val) {
                q.val = list1.val;
                list1 = list1.next;
            } else {
                q.val = list2.val;
                list2 = list2.next;
            }
            p.next = q;
            p = p.next;
        }

        if (null != list1) {
            p.next =  list1;
        } else if (null != list2) {
            p.next =  list2;
        }
        return listNode.next;
    }


    static class ListNode {
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

    public static void main(String[] args) {
        ListNode one = new ListNode(-1);
        one.next = new ListNode(1);
        one.next.next = new ListNode(2);
        one.next.next.next = new ListNode(4);

        ListNode two = new ListNode(-1);
        two.next = new ListNode(1);
        two.next.next = new ListNode(3);
        two.next.next.next = new ListNode(4);

        ListNode listNode = mergeTwoLists(one, two);
        while(null != listNode){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}




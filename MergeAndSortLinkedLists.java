
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class MergeAndSortLinkedLists {
    public static void main(String[] args) {
        ListNode head1 = createLinkedList(new int[]{25, 35, 12, 4, 36, 48});
        ListNode head2 = createLinkedList(new int[]{8, 32, 22, 45, 63, 49});

        ListNode mergedAndSorted = mergeAndSortLinkedLists(head1, head2);
        printLinkedList(mergedAndSorted);
    }

    public static ListNode createLinkedList(int[] nums) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int num : nums) {
            current.next = new ListNode(num);
            current = current.next;
        }

        return dummy.next;
    }

    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    public static ListNode mergeAndSortLinkedLists(ListNode head1, ListNode head2) {
        ListNode merged = mergeLists(head1, head2);
        return mergeSort(merged);
    }

    public static ListNode mergeLists(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                current.next = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }

        current.next = (head1 != null) ? head1 : head2;

        return dummy.next;
    }

    public static ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMiddle(head);
        ListNode nextOfMid = mid.next;
        mid.next = null;

        ListNode left = mergeSort(head);
        ListNode right = mergeSort(nextOfMid);

        return merge(left, right);
    }

    public static ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (left != null && right != null) {
            if (left.val < right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }

        current.next = (left != null) ? left : right;

        return dummy.next;
    }
}

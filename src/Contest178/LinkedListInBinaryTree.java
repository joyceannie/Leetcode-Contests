package Contest178;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class LinkedListInBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head.val==root.val) {
            if (checkPath(head, root)) {
                return true;
            }
        }
        boolean left = false, right = false;
        if (root.left!=null) {
            left = isSubPath(head, root.left);
        }
        if (root.right!=null) {
            right = isSubPath(head, root.right);
        }
        return left || right;
    }
    
    public boolean checkPath(ListNode head, TreeNode root) {
        if (head==null) {
            return true;
        }
        if (root.val!=head.val) {
            return false;
        }
        if (root.left==null && root.right==null && head.next==null) {
            return true;
        }
        boolean left = false, right = false;
        if (root.left!=null) {
            left = checkPath(head.next, root.left);
        }
        if (root.right!=null) {
            right = checkPath(head.next, root.right);
        }
        return left || right;
    }
}

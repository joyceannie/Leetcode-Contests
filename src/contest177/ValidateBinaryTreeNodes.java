package contest177;

import java.util.Stack;

/*
 * You have n binary tree nodes numbered from 0 to n - 1 where node i has two children leftChild[i] and rightChild[i], return true if and only if all the given nodes form exactly one valid binary tree.

If node i has no left child then leftChild[i] will equal -1, similarly for the right child.

Note that the nodes have no values and that we only use the node numbers in this problem.
 * 
 * Input: n = 4, leftChild = [1,-1,3,-1], rightChild = [2,-1,-1,-1]
Output: true

 * 
 * Input: n = 4, leftChild = [1,-1,3,-1], rightChild = [2,3,-1,-1]
Output: false
 * 
 * Input: n = 2, leftChild = [1,0], rightChild = [-1,-1]
Output: false
 *
 *1 <= n <= 10^4
leftChild.length == rightChild.length == n
-1 <= leftChild[i], rightChild[i] <= n - 1
 *
 **/
public class ValidateBinaryTreeNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        //dfs
        for (int i=0;i<n;i++) {
            if (!visited[i]) {
                if (stack.isEmpty() && i!=0) {
                    //graph is not connected
                    return false;
                }
                stack.push(i);
                visited[i] = true;

                while(!stack.isEmpty()) {
                    int cur = stack.pop();
                    int left = leftChild[cur];
                    int right = rightChild[cur];
                    if (left!=-1) {
                        if (visited[left]) {
                            return false;
                        } else {
                            stack.push(left);
                            visited[left] = true;
                        }
                    }
                    if (right!=-1) {
                        if (visited[right]) {
                            return false;
                        } else {
                            stack.push(right);
                            visited[right] = true;
                        }
                    }
                }
            }
        }
        return true;
    }

}

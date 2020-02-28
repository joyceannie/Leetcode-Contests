package contest177;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 *Given an integer array of digits, return the largest multiple of three that can be formed by concatenating some of the given digits in any order.

Since the answer may not fit in an integer data type, return the answer as a string.

If there is no answer return an empty string.
 * 
 * Input: digits = [8,1,9]
Output: "981"
 * 
 * 
 * Input: digits = [8,6,7,1,0]
Output: "8760"
 * 
 * Input: digits = [1]
Output: ""
 * 
 * 
 * Input: digits = [0,0,0,0,0,0]
Output: "0" * 
 * 
 * 
 */


public class LargestMultipleOfThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}  
	
    public String largestMultipleOfThree(int[] digits) {
        Arrays.sort(digits);
        Queue<Integer> q0 = new LinkedList<>();
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        int sum = 0;
        for (int i=0;i<digits.length;i++) {
            sum += digits[i];
            
            if (digits[i]%3==0) {
                q0.add(digits[i]);
            } else if (digits[i]%3==1) {
                q1.add(digits[i]);
            } else {
                q2.add(digits[i]);
            }
        }
        if (sum==0) {
            return "0";
        }
        if (sum%3==1) {
            //remove 1 digit from q1
            //if q1 is empty, remove 2 digits from q2
            if (!q1.isEmpty()) {
                q1.remove();
            } else {
                if (!q2.isEmpty()) {
                    q2.remove();
                } else {
                    return "";
                } 
                if (!q2.isEmpty()) {
                    q2.remove();
                } else {
                    return "";
                }                
            }
        } else if (sum%3==2) {
            //remove 1 digit from q2 or 2 digits from q1
            if (!q2.isEmpty()) {
                q2.remove();
            } else {
                if (!q1.isEmpty()) {
                    q1.remove();
                } else {
                    return "";
                }
                if (!q1.isEmpty()) {
                    q1.remove();
                } else {
                    return "";
                }
            }
        }
        int len = q0.size() + q1.size() + q2.size();
        int[] num = new int[len];
        getNum(num, q0, q1, q2);
        Arrays.sort(num);
        StringBuilder ans = new StringBuilder();
        for (int i=len-1;i>=0;i--) {
            ans.append(num[i]);
        }
        
        return ans.toString();
    }
    
    public int[] getNum(int[] num, Queue<Integer> q0, Queue<Integer> q1, Queue<Integer> q2) {
        int pos = 0;
        while (!q0.isEmpty()) {
            num[pos++] = q0.remove();
        }
        while (!q1.isEmpty()) {
            num[pos++] = q1.remove();
        }
        while (!q2.isEmpty()) {
            num[pos++] = q2.remove();
        }
        return num;
    }

}

package contest177;
/*
 * Given an integer num, find the closest two integers in absolute difference whose product equals num + 1 or num + 2.

Return the two integers in any order.
 * 
 * Input: num = 8
Output: [3,3]
Explanation: For num + 1 = 9, the closest divisors are 3 & 3, for num + 2 = 10, the closest divisors are 2 & 5, hence 3 & 3 is chosen.
 * 
 * 
 * Input: num = 123
 * Output: [5,25]
 * 
 * 
 * Input: num = 999
 *  Output: [40,25]
 * * 
 * 
 */
public class ClosestDivisors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int[] closestDivisors(int num) {
        int num1 = num + 1;
        int num2 = num + 2;
        if (isPerfectSquare(num1)){
            int root = (int)Math.sqrt(num1);
            return new int[] {root, root};
        } else if (isPerfectSquare(num2)){
            int root = (int)Math.sqrt(num2);
            return new int[] {root, root};
        } else {
            int[] output1 = find(num1);
            int[] output2 = find(num2);  
            int v1 = Math.abs(output1[0] - output1[1]);
            int v2 = Math.abs(output2[0] - output2[1]);
            return v1<v2? output1 : output2;
        }
        
    }
    
    public boolean isPerfectSquare(int num) {
        double sr = Math.sqrt(num);
        return ((sr - Math.floor(sr)) == 0);
    }
    
    public int[] find(int num) {
        int min = Integer.MAX_VALUE;
        int[] result = new int[2];
        for (int i=1;i<Math.sqrt(num);i++) {
            if ((num%i)==0) {
                if (Math.abs(i - num/i) < min) {
                    result[0] =i;
                    result[1] = num/i;
                }
            }
        }
        return result;
    }

}

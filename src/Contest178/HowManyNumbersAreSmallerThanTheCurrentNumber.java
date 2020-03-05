package Contest178;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HowManyNumbersAreSmallerThanTheCurrentNumber {
   
	public int[] smallerNumbersThanCurrent(int[] nums) {
        int len = nums.length;
        int[] num = new int[len];
        for (int i=0; i<len; i++) {
            num[i] = nums[i];
        }
        Arrays.sort(num);
        Map<Integer, Integer> hmap = new HashMap<>();
        for (int i=0;i<len;i++) {
            if (!hmap.containsKey(num[i])) {
                hmap.put(num[i], i);
            }
        }
        int[] result = new int[len];
        for (int i=0;i<len;i++) {
            result[i] = hmap.get(nums[i]);
        }
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

package info.sandroalmeida;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK_includeNegative {

    // the idea is created a map with all pre contiguous sums we can obtain until some point
    // than we can pick up the current sum and subtract from the target k
    // and check if we have this result on the map of pre sums
    // in case we have means there are contiguous subarray than can be removed from the current subarray
    // to build a correct target k
    // the beauty of this solution is the map will storage 1 or more possible pre sums
    // so for each pre sum founded we will have a valid result

    public static int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        Map<Integer, Integer> mapPreSums = new HashMap<>();
        mapPreSums.put(0, 1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(mapPreSums.containsKey(sum - k)){
                count += mapPreSums.get(sum - k);
            }
            mapPreSums.put(sum, mapPreSums.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(subarraySum(nums, 6));
    }
}

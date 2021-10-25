package info.sandroalmeida;

import java.util.Arrays;

public class SubarraySumEqualsK {

    // This solution is possible only if the array doesn't have negative numbers
    public static int subarraySum(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = 0, sum = nums[0], count = 0;
        while(right < nums.length){
            if(sum > k){
                sum -= nums[left];
                left++;
            } else if(sum < k){
                right++;
                if(right < nums.length)
                    sum += nums[right];
            } else{
                count++;
                right++;
                if(right < nums.length)
                    sum += nums[right];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(subarraySum(nums, 6));
    }
}

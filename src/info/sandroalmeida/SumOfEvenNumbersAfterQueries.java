package info.sandroalmeida;

import java.util.HashMap;
import java.util.Map;

public class SumOfEvenNumbersAfterQueries {

    public static int sum = 0;

    public static int[] sumEvenAfterQueries(int[] nums, int[][] queries) {

        // map of even numbers where key is the index and value is the number value
        Map<Integer, Integer> mapEvenNumbers = new HashMap<>();

        // variable for storage current even number sum
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 == 0){
                sum += nums[i];
                mapEvenNumbers.put(i, nums[i]);
            }
        }

        int[] result = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            executeQuery(nums, queries[i], mapEvenNumbers);
            result[i] = sum;
        }

        return result;
    }

    private static void executeQuery(int[] nums, int[] query, Map<Integer, Integer> mapEvenNumbers) {
        int index = query[1];
        int value = query[0];
        if(mapEvenNumbers.containsKey(index))
            sum -= nums[index];
        nums[index] += value;
        if(nums[index] % 2 != 0) {
            mapEvenNumbers.remove(index);
        } else{
            mapEvenNumbers.put(index, nums[index]);
            sum += nums[index];
        }
    }

    public static void main(String[] args) {
        // Input: nums = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
        // Output: [8,6,2,4]
        int[] nums = {1,2,3,4};
        int[][] queries = {{1,0},{-3,1},{-4,0},{2,3}};
        int[] result = sumEvenAfterQueries(nums, queries);
        for(int i: result)
            System.out.print(i + " ");
    }
}

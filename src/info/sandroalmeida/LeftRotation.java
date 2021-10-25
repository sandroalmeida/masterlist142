package info.sandroalmeida;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LeftRotation {

    public static List<Integer> rotLeft(List<Integer> a, int d) {

        int[] result = new int[a.size()];
        for(int i = 0; i < a.size(); i++){
            result[calcIndex(i, d, a.size())] = a.get(i);
        }
        return Arrays.stream(result).boxed().collect(Collectors.toList());
    }

    private static int calcIndex(int index, int factor, int size){
        factor = factor % size;
        int result = index - factor;
        if(result < 0)
            result = size + result;
        return result;
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        List<Integer> result = rotLeft(nums, 4);
        for(int num: result)
            System.out.print(num + " ");
    }
}

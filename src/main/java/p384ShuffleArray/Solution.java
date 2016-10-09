package p384ShuffleArray;

/**
 * Your Idea object will be instantiated and called as such:
 * Idea obj = new Idea(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */

import java.util.*;

/**
 * Created by Dawei on 10/4/2016.
 */
public class Solution {
    int value[];
    public Solution(int[] nums) {
        this.value = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.value;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if (value.length == 0)
            return value;
        List<Integer> v = new ArrayList<>();
        for (int i : value)
            v.add(i);
        int[] result = new int[v.size()];
        Random r = new Random();
        int begin = 0;
        while(v.size() > 1) {
            int curr = r.nextInt(v.size());
            result[begin++] = v.get(curr);
            v.remove(curr);
        }
        result[result.length - 1] = v.get(0);
        return result;
    }

}

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
public class Solution2 {
    int value[];

    public Solution2(int[] nums) {
        this.value = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.value;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] result = Arrays.copyOf(value, value.length);
        for (int i = value.length-1; i > 0; i--) {
            int temp = result[i];
            int index = (int)(Math.random() * (i+1));
            result[i] = result[index];
            result[index] = temp;
        }
        return result;
    }

}

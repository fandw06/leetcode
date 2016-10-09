package p384ShuffleArray;

/**
 * Created by Dawei on 10/4/2016.
 */

import java.util.Arrays;

/**
 * Your Idea object will be instantiated and called as such:
 * Idea obj = new Idea(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
public class Main {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5};
    //    int nums[] = {};
        Solution2 s = new Solution2(nums);
        int p1[] = s.shuffle();
        System.out.println(Arrays.toString(p1));
        int p2[] = s.shuffle();
        System.out.println(Arrays.toString(p2));
        int p3[] = s.shuffle();
        System.out.println(Arrays.toString(p3));
        int p4[] = s.shuffle();
        System.out.println(Arrays.toString(p4));
        int p5[] = s.shuffle();
        System.out.println(Arrays.toString(p5));
        int p6[] = s.shuffle();
        System.out.println(Arrays.toString(p6));
        int p7[] = s.reset();
        System.out.println(Arrays.toString(p7));
    }
}

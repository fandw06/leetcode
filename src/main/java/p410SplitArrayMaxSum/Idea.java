package p410SplitArrayMaxSum;

/**
 * Created by Dawei on 10/5/2016.
 */

import java.util.Arrays;
import java.util.Collections;

/**
 * exhaustive search?
 * tree?
 * DP?(for m? for n?)
 * Divide and concur?
 *
 * Idea 1: image m splitters, move the last splitter to the best place, then second last.
 *  But there is inter dependence.
 *
 * Idea2: Initialize splitters, find the max sum, try to reduce it with its neighbors.
 *  The logic is incorrect. test case: {10, 5, 13, 4, 8, 4, 5, 11, 14, 9, 16, 10, 20, 8}, 8
 *
 *  主要问题在于局部最优不是全局最优
 */
public class Idea {

    public int splitArray(int[] nums, int m) {
        if (m == 1) {
            return sum(nums);
        }
        int position[] = new int[m - 1];
        for (int i = 0; i < m - 1; i++) {
            position[i] = i;
        }
        int psum[] = new int[m];
        for (int i = 0; i < m-1; i++) {
            psum[i] = nums[i];
        }
        psum[m-1] = sum(nums, m-1, nums.length);
        int maxData[] = getMax(psum);
        boolean next = true;
        while (next) {
            System.out.println("Positions: " + Arrays.toString(position));
            System.out.println("Max：" + Arrays.toString(maxData));
            next = false;
            int index = maxData[0];

            // The first group is the max
            if (index == 0) {
                if (position[0] > 0) {
                    if (nums[position[0]] < Integer.MAX_VALUE && nums[position[0]] + psum[1] < psum[0]) {
                        next = true;
                        psum[0] -= nums[position[0]];
                        psum[1] += nums[position[0]];
                        position[0]--;
                        maxData = getMax(psum);
                        continue;
                    }
                }
            }
            // The last group is the max
            else if (index == m-1) {
                if (position[m-2] < nums.length -2) {
                    if (nums[position[m-2] + 1] < Integer.MAX_VALUE && nums[position[m-2] + 1] + psum[m-2] < psum[m-1]) {
                        next = true;
                        psum[m-1] -= nums[position[m-2] + 1];
                        psum[m-2] += nums[position[m-2] + 1];
                        position[m-2]++;
                        maxData = getMax(psum);
                        continue;
                    }
                }
            }
            // In the middle
            else {

                if (nums[position[index-1] + 1] < Integer.MAX_VALUE && nums[position[index - 1] + 1] + psum[index-1] < psum[index]) {
                    next = true;
                    psum[index] -= nums[position[index-1] + 1];
                    psum[index - 1] += nums[position[index-1] + 1];
                    position[index - 1]++;
                    maxData = getMax(psum);
                    continue;
                }

                if (nums[position[index]] < Integer.MAX_VALUE && nums[position[index]] + psum[index + 1] < psum[index]) {
                    next = true;
                    psum[index] -= nums[position[index]];
                    psum[index + 1] += nums[position[index]];
                    position[index]--;
                    maxData = getMax(psum);
                    continue;
                }

            }
        }
        return getMax(psum)[1];
    }

    public int sum(int nums[]) {
        int sum = 0;
        for (int i : nums)
            sum += i;
        return sum;
    }

    public int sum(int nums[], int a, int b) {
        int sum = 0;
        for (int i = a; i< b; i++)
            sum += nums[i];
        return sum;
    }

    public int[] getMax(int value[]) {
        int index = 0;
        int max = 0;
        for (int i = 0; i< value.length; i++) {
            if (value[i] > max) {
                max = value[i];
                index = i;
            }
        }
        return new int[]{index, max};
    }
}

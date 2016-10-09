package p410SplitArrayMaxSum;

import java.util.Arrays;

/**
 * Created by Dawei on 10/5/2016.
 */
public class Solution {


    public int splitArrayWithoutBS(int[] nums, int m) {
        int l = nums.length;
        int psum[] = new int[l];
        psum[0] = nums[0];
        for (int i = 1; i < l; i++)
            psum[i] = psum[i-1] + nums[i];
        int prev[] = psum;
        int curr[] = new int[l - m + 1];
        for (int i = 0; i < m-1; i++) {
            curr[0] = Math.max(prev[0], nums[i+1]);
            for (int j = 1; j < l - m + 1; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k <= j; k++) {
                    min = Math.min(min, Math.max(prev[k], psum[j+i+1]-psum[k + i]));
                }
                curr[j] = min;
            }
            System.out.println(Arrays.toString(curr));
            prev = curr;
            curr = new int[l - m + 1];
        }
        return prev[l - m];
    }

    public int splitArray(int[] nums, int m) {
        int l = nums.length;
        int psum[] = new int[l];
        psum[0] = nums[0];
        for (int i = 1; i < l; i++)
            psum[i] = psum[i-1] + nums[i];
        int prev[] = psum;
        int curr[] = new int[l - m + 1];
        for (int i = 0; i < m-1; i++) {
            curr[0] = Math.max(prev[0], nums[i+1]);
            for (int j = 1; j < l - m + 1; j++) {
                int left = 0, right = j, mid = (right + left)/2;
                for(; left < right - 1; ) {
                    if (Math.max(prev[mid], psum[j+i+1]-psum[mid + i]) > Math.max(prev[mid + 1], psum[j+i+1]-psum[mid + i + 1])) {
                        left = mid;
                    }
                    else if (Math.max(prev[mid], psum[j+i+1]-psum[mid + i]) < Math.max(prev[mid + 1], psum[j+i+1]-psum[mid + i + 1])) {
                        right = mid;
                    }
                    else {
                        int ll = mid, rr = mid;
                        while (ll > left && Math.max(prev[ll], psum[j+i+1]-psum[ll + i]) == Math.max(prev[ll-1], psum[j+i+1]-psum[ll-1 + i]))
                            ll--;
                        while (rr < right && nums[rr] == Math.max(prev[rr+1], psum[j+i+1]-psum[rr+1 + i]))
                            rr++;
                        if (ll > left && Math.max(prev[ll-1], psum[j+i+1]-psum[ll-1 + i]) > Math.max(prev[mid], psum[j+i+1]-psum[mid + i])) {
                            left = rr;
                        }
                        else
                            right = ll;
                    }
                    mid = (left + right)/2;
          //          System.out.println("Left: " + left + " Right: " + right + " Current: " + curr);
                }
                curr[j] = Math.min(Math.max(prev[left], psum[j+i+1]-psum[left + i]), Math.max(prev[right], psum[j+i+1]-psum[right + i]));
            }
            System.out.println(Arrays.toString(curr));
            prev = curr;
            curr = new int[l - m + 1];
        }
        return prev[l - m];
    }
}

package __search;

/**
 * Created by Dawei on 10/5/2016.
 */
public class VBS {
    /**
     * Binary search in a V shape (or reverted) array.
     * @param nums
     * @return
     */
    public int searchMax(int nums[]) {
        if (nums.length == 0)
            return -1;
        if (nums.length == 1)
            return nums[0];
        if (nums[0] >= nums[1])
            return nums[0];
        int left = 0, right = nums.length -1, curr = (right + left)/2;
        for(; left < right - 1; ) {
            if (nums[curr] <= nums[curr+1]) {
                left = curr;
            }
            else
                right = curr;
            curr = (left + right)/2;
            System.out.println("Left: " + left + " Right: " + right + " Current: " + curr);
        }
        return nums[right];

    }

    /**
     * Deal with equal scenario: 10, 3, 4, 4, 4, 4, 4, 9
     * @param nums
     * @return
     */
    public int searchMin(int nums[]) {
        if (nums.length == 0)
            return -1;
        if (nums.length == 1)
            return nums[0];
        if (nums[0] <= nums[1])
            return nums[0];
        int left = 0, right = nums.length -1;
        while (left <= right && nums[left+1] == nums[left])
            left++;
        while (left <= right && nums[right-1] == nums[right])
            right--;
        int curr = (right + left)/2;

        for(; left < right - 1; ) {
            if (nums[curr] > nums[curr+1]) {
                left = curr;
            }
            else if (nums[curr] < nums[curr+1])
                right = curr;

            else{
                int ll = curr, rr = curr;
                while (ll > left && nums[ll] == nums[ll-1])
                    ll--;
                while (rr < right && nums[rr] == nums[rr+1])
                    rr++;
                if (ll-1 >= left && nums[ll-1] > nums[curr]) {
                    left = rr;
                }
                else
                    right = ll;
            }
            curr = (left + right)/2;
            System.out.println("Left: " + left + " Right: " + right + " Current: " + curr);
        }
        return Math.min(nums[left], nums[right]);

    }
    public static void main(String[] args) {
        VBS v = new VBS();
    //    int num[] = {1, 4, 6, 7, 8, 10, 9, 7, 3, 1, -8};
    //    int num[] = {1, 4, 6, 7, 8, 10, 9, 7, 3, 1, -8};
        int num[] = {10, 5, 5, 5, 5, 5, 5, 5, 5, 5, 3, 4, 4, 9};
        int max = v.searchMin(num);
        System.out.println(max);

    }
}

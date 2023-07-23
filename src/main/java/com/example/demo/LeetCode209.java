package com.example.demo;

public class LeetCode209 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen3(7, nums));
    }

    /**
     * 暴力 O(n2)
     *
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum >= target) {
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    /**
     * 最优解 O(n)
     *
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen1(int target, int[] nums) {
        int left = 0, n = nums.length, res = Integer.MAX_VALUE, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while (sum >= target) {
                res = Math.min(res, i - left + 1);
                sum -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static int minSubArrayLen2(int target, int[] nums) {
        int n = nums.length, ans = Integer.MAX_VALUE, start = 0, end = 0, sum = 0;
        if (n == 0) {
            return 0;
        }
        while (end < n) {
            sum += nums[end];
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    /**
     * o(nlogn)
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen3(int target, int[] nums) {
        int i = 1, j = nums.length, res = 0;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (validWindow(mid, nums, target)) {
                j = mid - 1;
                res = mid;
            } else i = mid + 1;
        }
        return res;
    }

    private static boolean validWindow(int mid, int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i - mid >= 0) {
                sum -= nums[i - mid];
            }
            if (sum >= target) {
                return true;
            }
        }
        return false;
    }
}

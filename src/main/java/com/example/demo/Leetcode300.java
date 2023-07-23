package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode300 {
    public static void main(String[] args) {
        int[] a = {10,9,2,5,3,7};
        System.out.println(lengthOfLIS(a));
    }
    public static int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;

        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int res = 1;
        for (int i=1;i<nums.length;i++) {
            for (int j = 0;j<i;j++) {
                if (nums[j] <nums[i]) {
                    dp[i] = Math.max(dp[j] +1,dp[i]);
                }
                res = Math.max(res,dp[i]);
            }
        }
        return res;
    }
    public static int lengthOfLIS1(int[] nums) {
        List<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        for (int i =1;i<nums.length;i++) {
            int num = nums[i];
            if (num > sub.get(sub.size() -1)) {
                sub.add(num);
            }else {
                /*int j =0;
                while (num >sub.get(j)) j++;*/
                int j = binarySearch(sub,num);
                sub.set(j,num);
            }
        }
        return sub.size();
    }

    private static int binarySearch(List<Integer> list, int target) {
        int left = 0,right = list.size()-1;
        while (left <= right) {
            int mid = left +(right -left)/2;
            if (list.get(mid) >=target) right = mid -1;
            else if (list.get(mid) <target) left = mid +1;
            else return mid;
        }
        return left;
    }

}

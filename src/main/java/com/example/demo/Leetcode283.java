package com.example.demo;

public class Leetcode283 {
    public static void main(String[] args) {
        int [] nums = {0,1,0,3,12};
        moveZeroes1(nums);
    }
    private static void moveZeroes(int[] nums){
        if (nums == null) {
            return;
        }
        int j=0;
        for (int i=0; i<nums.length;i++){
            if (nums[i] !=0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
    }
    public static void moveZeroes1(int[] nums) {
        int left = 0, n = nums.length;
        for(int right = 0;right < n; right++)
            if(nums[right]!=0)
                nums[left++] = nums[right];
        while(left <n) nums[left++] =0;

    }
}

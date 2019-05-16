package 下一个排列_31;

/*		解题思路：  1：先从低位找第一个转折点a
 * 				   2：然后在遍历中的数，找到序号最大的比 a大的数字
 * 					3：交换这两个值，然后翻转
 * 
 * */

public class Solution {

    public static void main(String[] args) {
        int[] nums = { 2,3,1 };
        for(int i=0;i<nums.length;i++)
        	System.out.print(nums[i]);
        System.out.println();
        nextPermutation(nums);
        for(int i=0;i<nums.length;i++)
        	System.out.print(nums[i]);
    }

    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        int len = nums.length;
        int a = nums[len - 1];
        int i = len - 1;
        while (i >= 0) {
            if (nums[i] < a)
                break;
            else
                i--;
        }
        if (i<0)
            i = 0;
        nums[len - 1] = nums[i];
        nums[i] = a;
        sort(nums, i+1, len - 1);
    }

    private static void sort(int[] nums, int begin, int end) {

        for (int i = begin; i <= end - 1; i++) {
            for (int j = end; j > i; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;

                }
            }
        }

    }

}
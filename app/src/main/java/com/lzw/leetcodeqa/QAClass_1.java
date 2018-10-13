package com.lzw.leetcodeqa;

import java.util.Arrays;

/**
 * Author: lzw
 * Date: 2018/10/13
 * Description: This is QAClass_1
 */

public class QAClass_1 {
    /**
     * 两数之和
     * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
     * <p>
     * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
     * <p>
     * 示例:
     * <p>
     * 给定 nums = [2, 7, 11, 15], target = 9
     * <p>
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    if (nums[i] + nums[j] == target) {
                        int array[] = {i, j};
                        return array;
                    }
                }
            }
        }
        return null;
    }

    /**
     * 两个排序数组的中位数
     * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
     * <p>
     * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
     * <p>
     * 你可以假设 nums1 和 nums2 不同时为空
     * <p>
     * 示例 1:
     * <p>
     * nums1 = [1, 3]
     * nums2 = [2]
     * <p>
     * 中位数是 2.0
     * 示例 2:
     * <p>
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     * <p>
     * 中位数是 (2 + 3)/2 = 2.5
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] array = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, array, 0, nums1.length);
        System.arraycopy(nums2, 0, array, nums1.length, nums2.length);
        Arrays.sort(array);
        if (array.length == 1) {
            return array[0];
        } else {
            if (array.length % 2 == 0) {//数组为偶数位
                int a = array.length / 2;
                double sum = ((double) array[a] + (double) array[a - 1]) / 2;
                return sum;
            } else {//数组为奇数位
                int a = array.length / 2;
                return array[a];
            }
        }
    }

    /**
     * 最长回文子串
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
     * <p>
     * 示例 1：
     * <p>
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba"也是一个有效答案。
     * 示例 2：
     * <p>
     * 输入: "cbbd"
     * 输出: "bb"
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s.length() > 0) {
            String lastValue = s.charAt(0) + "";
            for (int i = 0; i < s.length(); i++) {
                for (int j = i + 1; j < s.length(); j++) {
                    if ((s.charAt(i) + "").equals(s.charAt(j) + "")) {
                        if (s.substring(i, j + 1).length() >= lastValue.length()) {
                            lastValue = s.substring(i, j + 1);
                        }
                    }
                }
            }
            return lastValue;
        } else {
            return "";
        }
    }
}

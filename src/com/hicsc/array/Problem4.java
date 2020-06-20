package com.hicsc.array;

public class Problem4 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        if (length1 < length2) {
            return findMedian(nums1,nums2);
        }
        return findMedian(nums2,nums1);
    }

    public static double findMedian(int[] small, int[] big) {
        int sl = small.length, bl = big.length;
        int start = 0, end = sl;
        while (start <= end) {
            int i = (start + end) / 2;
            int j = (sl + bl + 1) / 2 - i;
            if (i < end && big[j - 1] > small[i]) {
                start = i + 1;
            } else if (i > start && small[i - 1] > big[j]) {
                end = i - 1;
            } else {
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = big[j - 1];
                } else if (j == 0) {
                    maxLeft = small[i - 1];
                } else {
                    maxLeft = Math.max(small[i-1],big[j-1]);
                }
                // 如果大数组个数是奇数，中位数= Max(A[i-1],B[j-1])
                if ((sl + bl) % 2 == 1) {
                    return maxLeft;
                }
                // 如果大数组个数是偶数，中位数=（Max(A[i-1],B[j-1]) + Min（A[i], B[i]））/2
                int minRight = 0;
                if (i == sl) {
                    minRight = big[j];
                } else if (j == bl) {
                    minRight = small[i];
                } else {
                    minRight = Math.min(small[i],big[j]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }
}

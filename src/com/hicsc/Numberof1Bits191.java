package com.hicsc;

public class Numberof1Bits191 {

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Numberof1Bits191().hammingWeight(3));
        System.out.println(new Numberof1Bits191().hammingWeight(5));
        System.out.println(new Numberof1Bits191().hammingWeight(777));
    }
}

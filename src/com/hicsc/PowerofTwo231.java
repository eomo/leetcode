package com.hicsc;

public class PowerofTwo231 {

    public boolean isPowerOfTwo(int n) {
        // 将n转化为2进制后，只有一位是1，其余全是0
        // 比如：
        // 2 = 10
        // 4 = 100
        // 8 = 1000
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(new PowerofTwo231().isPowerOfTwo(1));
        System.out.println(new PowerofTwo231().isPowerOfTwo(16));
        System.out.println(new PowerofTwo231().isPowerOfTwo(218));
    }
}

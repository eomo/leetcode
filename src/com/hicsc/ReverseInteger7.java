package com.hicsc;

public class ReverseInteger7 {

    public int reverse(int x) {
        char[] chars = String.valueOf(x).toCharArray();
        String str = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] != '-') {
                str = str + chars[i];
            }
        }
        try {
            return Integer.parseInt(str) * (x > 0 ? 1 : -1);
        }catch (NumberFormatException e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new ReverseInteger7().reverse(-123));
    }
}

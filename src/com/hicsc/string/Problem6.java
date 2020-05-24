package com.hicsc.string;

public class Problem6 {

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING",3));
        System.out.println(convert("PAYPALISHIRING",4));
    }

    public static String convert(String s, int numRows) {
        if (s == null || s.length() < 2) {
            return s;
        }
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }
        int direction = 1;
        int index = 0;
        for (char ch : s.toCharArray()) {
            sbs[index].append(ch);
            index += direction;
            if (index == 0 || index == numRows - 1) {
                direction = -direction;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            sb.append(sbs[i]);
        }
        return sb.toString();
    }

}

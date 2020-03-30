package com.hicsc;

import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters1002 {

    public List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();
        if (A == null || A.length == 0) {
            return result;
        }
        int[] arr_ori = new int[26];
        for (char c : A[0].toCharArray()) {
            arr_ori[c - 'a']++;
        }
        for (int i = 1; i < A.length; i++) {
            countValid(A[i], arr_ori);
        }
        for (int i = 0; i < 26; i++) {
            if (arr_ori[i] != 0) {
                for (int j = 0; j < arr_ori[i]; j++) {
                    result.add((char)(i+'a') + "");
                }
            }
        }
        return result;
    }

    private void countValid(String str, int[] arr_ori) {
        int[] arr = new int[26];
        for (char c : str.toCharArray()) {
            arr[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (arr_ori[i] != 0 && arr[i] != arr_ori[i]) {
                arr_ori[i] = Math.min(arr_ori[i], arr[i]);
            }
        }
    }

    public static void main(String[] args) {
        String[] ss = new String[]{"bella", "label", "roller"};
        System.out.println(new FindCommonCharacters1002().commonChars(ss));
    }

}

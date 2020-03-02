package com.hicsc.tree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class LongestSubstring3 {
    public int lengthOfLongestSubstring(String s) {
        Queue<Character> queue = new LinkedList<>();
        int res = 0;
        for (char c : s.toCharArray()) {
            while (queue.contains(c)) {
                queue.poll();
            }
            queue.offer(c);
            res = Math.max(res, queue.size());
        }
        return res;
    }


//    public int lengthOfLongestSubstring(String s) {
//        if (Objects.isNull(s) || s.length() == 0) {
//            return 0;
//        }
//        int maxLength = 1;
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = i; j < s.length(); j++) {
//                if (sb.indexOf(String.valueOf(s.charAt(j))) < 0) {
//                    sb.append(s.charAt(j));
//                } else {
//                    if (maxLength < sb.length()) {
//                        maxLength = sb.length();
//                    }
//                    sb.delete(0, sb.length());
//                    break;
//                }
//            }
//        }
//        return maxLength;
//    }


    public static void main(String[] args) {
//        System.out.println(new LongestSubstring3().lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(new LongestSubstring3().lengthOfLongestSubstring("bbbbbbbb"));
        System.out.println(new LongestSubstring3().lengthOfLongestSubstring("b"));
    }
}

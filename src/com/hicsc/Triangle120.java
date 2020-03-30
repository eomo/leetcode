package com.hicsc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Triangle120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }
        int[] result = new int[triangle.size()];
        result[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> list = triangle.get(i);
            for (int j = i; j >= 0; j--) {
                if (j == 0) {
                    result[j] = result[0] + list.get(0);
                } else if (j == i) {
                    result[j] = result[j-1] + list.get(j);
                } else {
                    result[j] = Math.min(result[j-1],result[j]) + list.get(j);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i : result) {
            min = Math.min(min, i);
        }
        return min;
    }


    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);

        List<List<Integer>> list5 = new ArrayList<>();
        list5.add(list1);
        list5.add(list2);
        list5.add(list3);
        list5.add(list4);
        System.out.println(new Triangle120().minimumTotal(list5));
    }
}

package com.hicsc;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses22 {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateOneByOne("", result, n, n);
        return result;
    }

    public void generateOneByOne(String sublist, List<String> list, int leftRemain, int rightRemain) {
        if (leftRemain == 0 && rightRemain == 0) {
            list.add(sublist);
            return;
        }
        if (leftRemain > 0) {
            generateOneByOne(sublist + "(", list, leftRemain - 1, rightRemain);
        }
        if (rightRemain > leftRemain) {
            generateOneByOne(sublist + ")", list, leftRemain, rightRemain - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses22().generateParenthesis(3));
    }
}

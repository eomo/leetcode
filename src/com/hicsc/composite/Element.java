package com.hicsc.composite;

/**
 * UI元素
 */
public class Element implements UIComponent {

    public String name;

    public Element(String name) {
        this.name = name;
    }

    @Override
    public void draw() {
        System.out.println("Print " + name);
    }
}

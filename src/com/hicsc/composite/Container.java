package com.hicsc.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 容器组件
 */
public class Container implements UIComponent {

    public String name;

    private List<UIComponent> components;

    public Container(String name) {
        this.name = name;
    }

    @Override
    public void draw() {
        System.out.println("Print " + name);
        if (components != null && !components.isEmpty()) {
            components.stream().forEach(component -> component.draw());
        }
    }

    @Override
    public void add(UIComponent child) {
        if (components == null) {
            components = new ArrayList<>();
        }
        components.add(child);
    }
}

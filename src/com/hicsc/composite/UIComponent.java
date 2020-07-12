package com.hicsc.composite;

/**
 * UI组件,所有组件的公共操作
 */
public interface UIComponent {

    /**
     * 绘制
     */
    void draw();

    /**
     * 添加控件
     */
    default void add(UIComponent component) {
        throw new UnsupportedOperationException("不支持此操作");
    }

    /**
     * 移除控件
     */
    default void remove(UIComponent component) {
        throw new UnsupportedOperationException("不支持此操作");
    }
}

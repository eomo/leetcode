package com.hicsc.composite;

public class Client {

    public static void main(String[] args) {
        UIComponent form = new Container("WINDOW窗口");
        UIComponent logo = new Element("LOGO图片");
        UIComponent loginButton = new Element("登录");
        UIComponent registerButton = new Element("注册");

        form.add(logo);
        form.add(loginButton);
        form.add(registerButton);

        UIComponent frame = new Container("FRAME1");
        UIComponent userNameLabel = new Element("用户名");
        UIComponent userNameTextBox = new Element("文本框");
        UIComponent passwordLabel = new Element("密码");
        UIComponent passwordTextBox = new Element("密码框");
        UIComponent rememberCheckbox = new Element("复选框");
        UIComponent rememberTextBox = new Element("记住用户名");
        UIComponent forgetPasswordLinkLabel = new Element("忘记密码");

        frame.add(userNameLabel);
        frame.add(userNameTextBox);
        frame.add(passwordLabel);
        frame.add(passwordTextBox);
        frame.add(rememberCheckbox);
        frame.add(rememberTextBox);
        frame.add(forgetPasswordLinkLabel);
        form.add(frame);

        form.draw();
    }
}

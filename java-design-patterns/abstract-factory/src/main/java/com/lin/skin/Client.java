package com.lin.skin;

public class Client {
    public static void main(String[] args) {
        SkinFactory skinFactory;
        Button bt;
        TextField tf;
        ComboBox cb;

        skinFactory = (SkinFactory) XMLUtil.getBean();
        bt = skinFactory.createButton();
        tf = skinFactory.createTextField();
        cb = skinFactory.createComboBox();
        bt.display();
        tf.display();
        cb.display();
    }
}

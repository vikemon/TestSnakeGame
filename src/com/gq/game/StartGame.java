package com.gq.game;

import javax.swing.*;
import java.awt.*;

public class StartGame {

    public static void main(String[] args) {
        JFrame jf = new JFrame();
        //标题
        jf.setTitle("贪吃蛇");

        //得到屏幕的大小
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;

        //位置和大小
        jf.setBounds((width-810)/2,(height-810)/2,810,810);
        //设置窗口大小不可调
        jf.setResizable(false);
        //关闭窗口的时候关闭程序
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //创建面板放入窗体
        GamePanel gp = new GamePanel();
        jf.add(gp);

        //显示
        jf.setVisible(true);

    }
}

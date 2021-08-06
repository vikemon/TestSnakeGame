package com.gq.game;

import javax.swing.*;
import java.net.URL;

public class Images {

    //将图片路径封装为一个对象
    public static URL bodyURL = Images.class.getResource("/images/13.png");
    //将图片给封装为一个对象
    public static ImageIcon bodyImg = new ImageIcon(bodyURL);

    public static URL foodURL = Images.class.getResource("/images/11.png");
    public static ImageIcon foodImg = new ImageIcon(foodURL);

    public static URL headerURL = Images.class.getResource("/images/14.png");
    public static ImageIcon headerImg = new ImageIcon(headerURL);

    public static URL upURL = Images.class.getResource("/images/12.png");
    public static ImageIcon upImg = new ImageIcon(upURL);

    public static URL downURL = Images.class.getResource("/images/12.png");
    public static ImageIcon downImg = new ImageIcon(downURL);

    public static URL leftURL = Images.class.getResource("/images/12.png");
    public static ImageIcon leftImg = new ImageIcon(leftURL);

    public static URL rightURL = Images.class.getResource("/images/12.png");
    public static ImageIcon rightImg = new ImageIcon(rightURL);


}

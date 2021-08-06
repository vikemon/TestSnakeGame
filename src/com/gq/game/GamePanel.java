package com.gq.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel {
    //定义方向
    String direction;
    //蛇的长度
    int length;
    //游戏的状态
    boolean isStart;
    //加入一个定时器
    Timer timer;
    //蛇的坐标
    int[] snakeX = new int[600];
    int[] snakeY = new int[600];
    //食物坐标
    int foodX;
    int foodY;
    //定义一个积分
    int score;
    //判断小蛇状态
    boolean isDie;


    //初始化函数
    public void init(){
        direction = "R";
        length = 3;
        isStart = false;
        isDie = false;
        score = 0;

        snakeX[0] = 190;
        snakeY[0] = 290;

        snakeX[1] = 160;
        snakeY[1] = 290;

        snakeX[2] = 130;
        snakeY[2] = 290;

        //定义食物的坐标
        foodX = 280;
        foodY = 110;
    }
    public GamePanel(){
        init();
        //加入监听
        this.setFocusable(true);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {//监听键盘按键的按下操作
                super.keyPressed(e);
                int keyCode = e.getKeyCode();
                System.out.println(keyCode);
                if(keyCode == KeyEvent.VK_SPACE){//监听空格
                    if(isDie){
                        init();
                        isStart = true;
                    }else {
                        isStart = !isStart;
                        repaint();//重绘操作
                    }
                }
                if(keyCode ==KeyEvent.VK_UP){
                    direction = "U";
                }
                if(keyCode ==KeyEvent.VK_DOWN){
                    direction = "D";
                }
                if(keyCode ==KeyEvent.VK_LEFT){
                    direction = "L";
                }
                if(keyCode ==KeyEvent.VK_RIGHT){
                    direction = "R";
                }

            }
        });
        //对定时器进行初始化操作
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(isStart){
                    for(int i=length-1;i>0;i--){
                        snakeX[i] = snakeX[i-1];
                        snakeY[i] = snakeY[i-1];
                    }

                    if("R".equals(direction)){
                        snakeX[0] +=30;
                        if(snakeX[0]>760){
                            snakeX[0] = 10;
                        }
                    }
                    if("L".equals(direction)){
                        snakeX[0] -=30;
                        if(snakeX[0]<10){
                            snakeX[0] = 760;
                        }
                    }
                    if("U".equals(direction)){
                        snakeY[0] -=30;
                        if(snakeY[0]<50){
                            snakeY[0] = 740;
                        }
                    }
                    if("D".equals(direction)){
                        snakeY[0] +=30;
                        if(snakeY[0]>740){
                            snakeY[0] = 50;
                        }
                    }
                    if(snakeX[0] == foodX && snakeY[0] == foodY){
                        length++;
                        snakeX[length-1]=snakeX[length-2];
                        snakeY[length-1]=snakeY[length-2];
                        foodX = ((int)(Math.random()*26))*30+10;//[10，790)
                        foodY = ((int)(Math.random()*24))*30+50;//[50，770)
//                        foodY = (new Random().nextInt(24))*30+50;

                        score += 10;
                    }
                    for(int i = 1;i<length;i++){
                        if(snakeX[0]==snakeX[i]&&snakeY[0]==snakeY[i]){
                            //将死亡
                            isDie = true;
                        }
                    }
                   repaint();
                }
            }
        });
        timer.start();
    }

    /**
     * 相当于图形版的main方法
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //填充背景色
        this.setBackground(new Color(214, 179, 77));
        //画头部图片
        Images.headerImg.paintIcon(this,g,10,10);
        //调整画笔颜色
        g.setColor(new Color(173, 143, 55));
        //画一个矩形
        g.fillRect(10,50,780,720);

        //画小蛇
        if("R".equals(direction)){
            Images.rightImg.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        if("L".equals(direction)){
            Images.leftImg.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        if("U".equals(direction)){
            Images.upImg.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        if("D".equals(direction)){
            Images.downImg.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        for(int i = 1; i<length ;i++){
            Images.bodyImg.paintIcon(this,g,snakeX[i],snakeY[i]);
        }
        if(isStart == false){
            //画一个文字
            g.setColor(new Color(1,1,1));
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("点击空格开始游戏",250,330);


        }
        //画食物
        Images.foodImg.paintIcon(this,g,foodX,foodY);
        //画积分
        g.setColor(new Color(210, 229, 235));
        g.setFont(new Font("微软雅黑",Font.BOLD,20));
        g.drawString("积分："+score,620,32);

        //死亡时
        if(isDie) {
            g.setColor(new Color(1, 1, 1));
            g.setFont(new Font("微软雅黑", Font.BOLD, 40));
            g.drawString("小蛇死亡，点击空格重新开始", 150, 330);
            Images.rightImg.paintIcon(this,g,snakeX[0],snakeY[0]);
            isStart = false;
        }

    }
}

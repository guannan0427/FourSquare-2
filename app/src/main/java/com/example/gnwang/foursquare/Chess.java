package com.example.gnwang.foursquare;

import android.support.annotation.IdRes;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by guannan on 3/11/2016.
 */

public class Chess extends PlayGameActivity {
    ImageButton clickbutton[][] = new ImageButton[7][8];//存放棋子
    int ifclicked[][] = new int[7][8];//存放棋子点击状态
    int whichstep[][] = new int[7][8];//存放棋子的步数
    int totalsteps;//整局的布棋数
    int whichcolor[][] = new int[7][8];//棋子的颜色
    int winnerbox[][] = new int[7][8];//赢了的棋子标记

/*
    public void restart(){
        clickbutton[0][0] = (ImageButton) findViewById(R.id.empty_00);
        clickbutton[0][1] = (ImageButton) findViewById(R.id.empty_01);
        clickbutton[0][2] = (ImageButton) findViewById(R.id.empty_02);
        clickbutton[0][3] = (ImageButton) findViewById(R.id.empty_03);
        clickbutton[0][4] = (ImageButton) findViewById(R.id.empty_04);
        clickbutton[0][5] = (ImageButton) findViewById(R.id.empty_05);
        clickbutton[0][6] = (ImageButton) findViewById(R.id.empty_06);

        clickbutton[1][0] = (ImageButton) findViewById(R.id.empty_10);
        clickbutton[1][1] = (ImageButton) findViewById(R.id.empty_11);
        clickbutton[1][2] = (ImageButton) findViewById(R.id.empty_12);
        clickbutton[1][3] = (ImageButton) findViewById(R.id.empty_13);
        clickbutton[1][4] = (ImageButton) findViewById(R.id.empty_14);
        clickbutton[1][5] = (ImageButton) findViewById(R.id.empty_15);
        clickbutton[1][6] = (ImageButton) findViewById(R.id.empty_16);

        clickbutton[2][0] = (ImageButton) findViewById(R.id.empty_20);
        clickbutton[2][1] = (ImageButton) findViewById(R.id.empty_21);
        clickbutton[2][2] = (ImageButton) findViewById(R.id.empty_22);
        clickbutton[2][3] = (ImageButton) findViewById(R.id.empty_23);
        clickbutton[2][4] = (ImageButton) findViewById(R.id.empty_24);
        clickbutton[2][5] = (ImageButton) findViewById(R.id.empty_25);
        clickbutton[2][6] = (ImageButton) findViewById(R.id.empty_26);

        clickbutton[3][0] = (ImageButton) findViewById(R.id.empty_30);
        clickbutton[3][1] = (ImageButton) findViewById(R.id.empty_31);
        clickbutton[3][2] = (ImageButton) findViewById(R.id.empty_32);
        clickbutton[3][3] = (ImageButton) findViewById(R.id.empty_33);
        clickbutton[3][4] = (ImageButton) findViewById(R.id.empty_34);
        clickbutton[3][5] = (ImageButton) findViewById(R.id.empty_35);
        clickbutton[3][6] = (ImageButton) findViewById(R.id.empty_36);

        clickbutton[4][0] = (ImageButton) findViewById(R.id.empty_40);
        clickbutton[4][1] = (ImageButton) findViewById(R.id.empty_41);
        clickbutton[4][2] = (ImageButton) findViewById(R.id.empty_42);
        clickbutton[4][3] = (ImageButton) findViewById(R.id.empty_43);
        clickbutton[4][4] = (ImageButton) findViewById(R.id.empty_44);
        clickbutton[4][5] = (ImageButton) findViewById(R.id.empty_45);
        clickbutton[4][6] = (ImageButton) findViewById(R.id.empty_46);

        clickbutton[5][0] = (ImageButton) findViewById(R.id.empty_50);
        clickbutton[5][1] = (ImageButton) findViewById(R.id.empty_51);
        clickbutton[5][2] = (ImageButton) findViewById(R.id.empty_52);
        clickbutton[5][3] = (ImageButton) findViewById(R.id.empty_53);
        clickbutton[5][4] = (ImageButton) findViewById(R.id.empty_54);
        clickbutton[5][5] = (ImageButton) findViewById(R.id.empty_55);
        clickbutton[5][6] = (ImageButton) findViewById(R.id.empty_56);
    }

*/

    //初始棋子状态
    public void clicked() {
        for (int a = 0; a < 6; a++) {
            for (int b = 0; b < 7; b++) {
                ifclicked[a][b] = 0;
            }
        }

    }

    public void allclicked(){
        for (int a = 0; a < 6; a++) {
            for (int b = 0; b < 7; b++) {
                ifclicked[a][b] = 1;
            }
        }
    }

    //初始winnerbox
    public void setWinnerbox() {
        for (int a = 0; a < 6; a++) {
            for (int b = 0; b < 7; b++) {
                winnerbox[a][b] = 0;
            }
        }
    }

    //结束游戏
    public void gameover() {
        for (int a = 0; a < 6; a++) {
            for (int b = 0; b < 7; b++) {
                ifclicked[a][b] = 1;
            }
        }
    }

    //输赢判断
    public void winnervertival(int a, int b) {

        //竖向遍历
        int count1 = 1;//设置计数器,计算相同棋子数
        int i1 = 1;//行数转换
        int winnerabnotchange=winnerbox[a][b];
        //行数增加,列数不变
        for (; a + i1 <= 5; ) {
            //判断颜色是否相同
            if (whichcolor[a][b] == whichcolor[a + i1][b] && whichcolor[a][b] != 0) {
                winnerbox[a + i1][b] = whichcolor[a][b];//颜色相同,则为该点做标记,存放在winnerbox中存放棋子颜色编码
                i1++;//行数加1,查看下一行;
                count1++;//计数器加一
            } else {
                break;//一旦发现不一样颜色的棋子,则跳出for循环
            }
        }

        //判断相同颜色棋子数有没有到4
        if (count1 < 4) {
            //如果未到4,则将winnerbox全部归零
            for (int aaa = 0; aaa < 6; aaa++) {
                for (int bbb = 0; bbb < 7; bbb++) {
                    winnerbox[aaa][bbb] = 0;
                }
            }
            winnerbox[a][b]=winnerabnotchange;
        } else if (count1 >= 4) {//如果有一方到了赢点,则将最后一落子点的winnerbox做上标记 ?结束后需要winnerbox归零
            winnerbox[a][b] = whichcolor[a][b];//赢了的标记
        }

    }


    public void winnerhorizon(int a,int b) {
        //横向遍历
        int count2 = 1;
        int i2 = 1;
        int ii2 = 1;
        for (; b + i2 <= 6; ) {
            if (whichcolor[a][b] == whichcolor[a][b + i2] && whichcolor[a][b] != 0) {
                winnerbox[a][b + i2] = whichcolor[a][b];
                i2++;
                count2++;
            } else {
                break;
            }
        }

        for (; b - ii2 >= 0; ) {
            if (whichcolor[a][b] == whichcolor[a][b - ii2] && whichcolor[a][b] != 0) {
                winnerbox[a][b - ii2] = whichcolor[a][b];
                ii2++;
                count2++;
            } else {
                break;
            }
        }

        if (count2 < 4) {
            int winnerabnotchange=winnerbox[a][b];
            for (int aaa = 0; aaa < 6; aaa++) {
                for (int bbb = 0; bbb < 7; bbb++) {
                    winnerbox[aaa][bbb] = 0;
                }
            }
            winnerbox[a][b]=winnerabnotchange;
        } else if (count2 >= 4) {
            winnerbox[a][b] = whichcolor[a][b];
        }

    }
    public void winnerleft(int a,int b) {
        //左斜遍历
        int count3 = 1;
        int i3 = 1;
        int ii3 = 1;

        for (; a - i3 >= 0; ) {
            if (whichcolor[a][b] == whichcolor[a - i3][b + i3] && whichcolor[a][b] != 0) {
                winnerbox[a - i3][b + i3] = whichcolor[a][b];
                i3++;
                count3++;
            } else {
                break;
            }
        }
        for (; b - ii3 >= 0; ) {
            if (whichcolor[a][b] == whichcolor[a + ii3][b - ii3] && whichcolor[a][b] != 0) {
                winnerbox[a + ii3][b - ii3] = whichcolor[a][b];
                ii3++;
                count3++;
            } else {
                break;
            }
        }


        if (count3 < 4) {
            int winnerabnotchange=winnerbox[a][b];
            for (int aaa = 0; aaa < 6; aaa++) {
                for (int bbb = 0; bbb < 7; bbb++) {
                    winnerbox[aaa][bbb] = 0;
                }
            }
            winnerbox[a][b]=winnerabnotchange;
        } else if (count3 >= 4) {
            winnerbox[a][b] = whichcolor[a][b];
        }

    }
    public void winnerright(int a,int b){
        //右斜遍历
        int count4=1;
        int i4=1;
        int ii4=1;

        for (;a+i4<=5 && b+i4<=6;){
            if(whichcolor[a][b]==whichcolor[a+i4][b+i4] && whichcolor[a][b]!=0){
                winnerbox[a+i4][b+i4]=whichcolor[a][b];
                i4++;
                count4++;
            }
            else {break;}
        }
        for(;a-ii4>=0 && b-ii4>=0;){
            if(whichcolor[a][b]==whichcolor[a-ii4][b-ii4] && whichcolor[a][b]!=0){
                winnerbox[a-ii4][b-ii4]=whichcolor[a][b];
                ii4++;
                count4++;
            }
            else {break;}
        }


        if(count4<4){
            int winnerabnotchange=winnerbox[a][b];
            for (int aaa=0;aaa<6;aaa++){
                for(int bbb=0;bbb<7;bbb++){
                    winnerbox[aaa][bbb]=0;
                }
            }
            winnerbox[a][b]=winnerabnotchange;
        }
        else if(count4>=4){
            winnerbox[a][b]=whichcolor[a][b];
        }


    }
}

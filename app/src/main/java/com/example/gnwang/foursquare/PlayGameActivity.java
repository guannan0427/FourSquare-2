package com.example.gnwang.foursquare;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by guannan on 2/11/2016.
 */

public class PlayGameActivity extends AppCompatActivity {

    int count = 0;
    int step;
    int row, column;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playgame);

        //初始化棋盘
        final Chess buttonid = new Chess();
        //buttonid.restart();
        final ImageView turn=(ImageView) findViewById(R.id.turnred);

        buttonid. clickbutton[0][0] = (ImageButton) findViewById(R.id.empty_00);
        buttonid.clickbutton[0][1] = (ImageButton) findViewById(R.id.empty_01);
        buttonid.clickbutton[0][2] = (ImageButton) findViewById(R.id.empty_02);
        buttonid. clickbutton[0][3] = (ImageButton) findViewById(R.id.empty_03);
        buttonid. clickbutton[0][4] = (ImageButton) findViewById(R.id.empty_04);
        buttonid. clickbutton[0][5] = (ImageButton) findViewById(R.id.empty_05);
        buttonid. clickbutton[0][6] = (ImageButton) findViewById(R.id.empty_06);

        buttonid. clickbutton[1][0] = (ImageButton) findViewById(R.id.empty_10);
        buttonid. clickbutton[1][1] = (ImageButton) findViewById(R.id.empty_11);
        buttonid. clickbutton[1][2] = (ImageButton) findViewById(R.id.empty_12);
        buttonid. clickbutton[1][3] = (ImageButton) findViewById(R.id.empty_13);
        buttonid. clickbutton[1][4] = (ImageButton) findViewById(R.id.empty_14);
        buttonid. clickbutton[1][5] = (ImageButton) findViewById(R.id.empty_15);
        buttonid. clickbutton[1][6] = (ImageButton) findViewById(R.id.empty_16);

        buttonid. clickbutton[2][0] = (ImageButton) findViewById(R.id.empty_20);
        buttonid.  clickbutton[2][1] = (ImageButton) findViewById(R.id.empty_21);
        buttonid.  clickbutton[2][2] = (ImageButton) findViewById(R.id.empty_22);
        buttonid.  clickbutton[2][3] = (ImageButton) findViewById(R.id.empty_23);
        buttonid. clickbutton[2][4] = (ImageButton) findViewById(R.id.empty_24);
        buttonid. clickbutton[2][5] = (ImageButton) findViewById(R.id.empty_25);
        buttonid. clickbutton[2][6] = (ImageButton) findViewById(R.id.empty_26);

        buttonid. clickbutton[3][0] = (ImageButton) findViewById(R.id.empty_30);
        buttonid. clickbutton[3][1] = (ImageButton) findViewById(R.id.empty_31);
        buttonid.  clickbutton[3][2] = (ImageButton) findViewById(R.id.empty_32);
        buttonid.  clickbutton[3][3] = (ImageButton) findViewById(R.id.empty_33);
        buttonid.  clickbutton[3][4] = (ImageButton) findViewById(R.id.empty_34);
        buttonid.  clickbutton[3][5] = (ImageButton) findViewById(R.id.empty_35);
        buttonid.  clickbutton[3][6] = (ImageButton) findViewById(R.id.empty_36);

        buttonid.  clickbutton[4][0] = (ImageButton) findViewById(R.id.empty_40);
        buttonid.clickbutton[4][1] = (ImageButton) findViewById(R.id.empty_41);
        buttonid.clickbutton[4][2] = (ImageButton) findViewById(R.id.empty_42);
        buttonid. clickbutton[4][3] = (ImageButton) findViewById(R.id.empty_43);
        buttonid.clickbutton[4][4] = (ImageButton) findViewById(R.id.empty_44);
        buttonid.clickbutton[4][5] = (ImageButton) findViewById(R.id.empty_45);
        buttonid.clickbutton[4][6] = (ImageButton) findViewById(R.id.empty_46);

        buttonid.clickbutton[5][0] = (ImageButton) findViewById(R.id.empty_50);
        buttonid.clickbutton[5][1] = (ImageButton) findViewById(R.id.empty_51);
        buttonid.clickbutton[5][2] = (ImageButton) findViewById(R.id.empty_52);
        buttonid.clickbutton[5][3] = (ImageButton) findViewById(R.id.empty_53);
        buttonid.clickbutton[5][4] = (ImageButton) findViewById(R.id.empty_54);
        buttonid.clickbutton[5][5] = (ImageButton) findViewById(R.id.empty_55);
        buttonid.clickbutton[5][6] = (ImageButton) findViewById(R.id.empty_56);


        buttonid.clicked();

        //落子
        for (row = 0; row <= 5; row++) {
            for (column = 0; column <= 6; column++) {
                final int c = column;
                buttonid.clickbutton[row][c].setOnClickListener(new View.OnClickListener() {
                    //点击某个按钮改变按钮图片
                    @Override
                    public void onClick(View view) {
                        count = count + 1;
                        for (int a = 5; a >= 0; ) {//找未落子的cell
                            int t = buttonid.ifclicked[a][c];

                            if (t == 0) {//未落子过

                                if (count % 2 == 0) {//落子顺序,2的倍数即第二个落子方,为绿色
                                    if(count!=0) {
                                        turn.setImageResource(R.drawable.red_t);
                                    }
                                    else if(count==0)
                                    {
                                        turn.setImageResource(R.drawable.empty_t);
                                    }

                                    buttonid.whichcolor[a][c] = 2;//棋子颜色记号,绿色为2
                                    buttonid.setWinnerbox();//判断之前先初始化winnerbox;

                                   buttonid.winnervertival(a,c);//开始判断,首先竖着判断
                                    int vertical1=buttonid.winnerbox[a][c];
                                    if(vertical1==0)
                                    {
                                        buttonid.winnerhorizon(a,c);
                                        int horizon1=buttonid.winnerbox[a][c];
                                        if(horizon1==0)
                                        {
                                            buttonid.winnerright(a,c);
                                            int right1=buttonid.winnerbox[a][c];
                                            if(right1==0)
                                            {
                                                buttonid.winnerleft(a,c);
                                                int left1=buttonid.winnerbox[a][c];
                                                if(left1==0)
                                                {
                                                    //break;
                                                }
                                                else if(left1!=0)
                                                {

                                                }
                                            }
                                            else if(right1!=0)
                                            {

                                            }
                                        }
                                        else if(horizon1!=0)
                                        {

                                        }
                                    }
                                    else if(vertical1!=0)
                                    {


                                    }





                                   // buttonid.winner1(a, c);//判断棋局输赢
                                    //buttonid.winner2(a,c);

                                    //如果落该子,赢
                                    if (buttonid.winnerbox[a][c] == 2) {
                                        //遍历winnerbox,找到相同标记的点,改变点的ImageButton
                                       // buttonid.winnerhorizon(a,c);
                                       // buttonid.winnerright(a,c);
                                       // buttonid.winnerleft(a,c);
                                      //  buttonid.winnervertival(a,c);
                                        for (int aa = 0; aa <= 5; aa++) {
                                            for (int bb = 0; bb <= 6; bb++) {
                                                if (buttonid.winnerbox[aa][bb] == 2) {
                                                    buttonid.clickbutton[aa][bb].setImageResource(R.drawable.green_wint);
                                                    //buttonid.gameover();




                                                }
                                            }
                                        }
                                        buttonid.whichstep[a][c] = count;//记录落下该点时的步数
                                        buttonid.totalsteps = count;//记录总步数
                                        showresult(2);
                                        buttonid.allclicked();
                                        buttonid.totalsteps=0;
                                        count=0;
                                        turn.setImageResource(R.drawable.empty_t);


                                    }
                                    //如果落该子,不赢
                                    else {
                                        buttonid.clickbutton[a][c].setImageResource(R.drawable.green_t);

                                        buttonid.whichstep[a][c] = count;
                                        buttonid.totalsteps = count;

                                    }
                                } else if (count % 2 == 1) {//落子顺序,第一个为红色

                                    turn.setImageResource(R.drawable.green_t);
                                    buttonid.whichcolor[a][c] = 1;//红色颜色代号为1
                                    buttonid.setWinnerbox();

                                    buttonid.winnervertival(a,c);//开始判断,首先竖着判断
                                    int vertical2=buttonid.winnerbox[a][c];
                                    if(vertical2==0)
                                    {
                                        buttonid.winnerhorizon(a,c);
                                        int horizon2=buttonid.winnerbox[a][c];
                                        if(horizon2==0)
                                        {
                                            buttonid.winnerright(a,c);
                                            int right2=buttonid.winnerbox[a][c];
                                            if(right2==0)
                                            {
                                                buttonid.winnerleft(a,c);
                                                int left2=buttonid.winnerbox[a][c];
                                                if(left2==0)
                                                {
                                                  //  break;
                                                }
                                                else if(left2!=0)
                                                {
                                                   // break;
                                                }
                                            }
                                            else if(right2!=0)
                                            {
                                              //  break;
                                            }
                                        }
                                        else if(horizon2!=0)
                                        {
                                         //   break;
                                        }
                                    }
                                    else if(vertical2!=0)
                                    {
                                     //   break;
                                    }






                                    //buttonid.winner1(a, c);//落子即判断
                                    //   buttonid.winner2(a,c);
                                    if (buttonid.winnerbox[a][c] == 1) {//如果落子就赢
                                       // buttonid.winnerhorizon(a,c);
                                       // buttonid.winnerright(a,c);
                                       // buttonid.winnerleft(a,c);
                                      //  buttonid.winnervertival(a,c);
                                        for (int aa = 0; aa <= 5; aa++) {
                                            for (int bb = 0; bb <= 6; bb++) {
                                                if (buttonid.winnerbox[aa][bb] == 1) {
                                                    buttonid.clickbutton[aa][bb].setImageResource(R.drawable.red_wint);
                                                    // buttonid.gameover();

                                                }
                                            }
                                        }

                                        buttonid.whichstep[a][c] = count;
                                        buttonid.totalsteps = count;
                                        showresult(1);
                                        buttonid.allclicked();
                                        buttonid.totalsteps=0;
                                        count=0;
                                        turn.setImageResource(R.drawable.empty_t);
                                    } else {//未赢
                                        buttonid.clickbutton[a][c].setImageResource(R.drawable.red_t);

                                        buttonid.whichstep[a][c] = count;
                                        buttonid.totalsteps = count;

                                    }
                                }
                                buttonid.ifclicked[a][c] = 1;
                                break;
                            } else {//该点已经落果子
                                a--;
                            }

                        }
                        if(count==42)
                        {
                            showresult(0);

                        }
                    }
                });


            }
        }


        Button retract = (Button) findViewById(R.id.retract);
        retract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (row = 0; row <= 5; row++) {
                    for (column = 0; column <= 6; column++) {
                        int r = row;
                        int c = column;
                        if (buttonid.whichstep[r][c] == buttonid.totalsteps) {
                            buttonid.clickbutton[r][c].setImageResource(R.drawable.empty_t);
                            buttonid.ifclicked[r][c] = 0;
                            buttonid.winnerbox[r][c] = 0;
                            buttonid.whichcolor[r][c] = 0;

                            break;
                        }

                    }
                }
                buttonid.totalsteps--;
                count--;
                if (count >= 0) {
                    if (count % 2 == 1) {
                        turn.setImageResource(R.drawable.green_t);
                    } else if (count % 2 == 0) {
                        if (count != 0) {
                            turn.setImageResource(R.drawable.red_t);
                        } else if (count == 0) {
                            turn.setImageResource(R.drawable.empty_t);
                        }
                    }

                }
            }
        });


        Button restart=(Button)findViewById(R.id.restart);
        restart.setOnClickListener(new  View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent myIntent=new Intent(view.getContext(),PlayGameActivity.class);
                startActivityForResult(myIntent,0);
            }
        });}


        public void showresult(int a){

        int winnercolor=a;

            if(winnercolor==0){
                new AlertDialog.Builder(PlayGameActivity.this).setTitle("Outcome")
                        .setMessage("Game Draw!")
                        .setPositiveButton("Ok",new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog,int which){
                                dialog.cancel();
                            }
                        }).show();
                //设置对话框标题
            }

            if(winnercolor==1){
                new AlertDialog.Builder(PlayGameActivity.this)
                        .setTitle("Outcome")
                        .setMessage("Red win!")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();

                            }
                        }).show();
                //设置对话框标题
            }

            if(winnercolor==2){
                new AlertDialog.Builder(PlayGameActivity.this)
                        .setTitle("Outcome")
                        .setMessage("Green win!")
                        .setPositiveButton("Ok",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        }).show();
                //设置对话框标题
            }

    }




}

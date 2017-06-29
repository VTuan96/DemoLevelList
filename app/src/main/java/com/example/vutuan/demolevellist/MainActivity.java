package com.example.vutuan.demolevellist;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private ImageView imgView;
    Handler handler;
    Timer timer;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgView= (ImageView) findViewById(R.id.imgView);

        //handler thuc hien tac vu, tien trinh ngoai luong, no nhu 1 ben trung gian xu ly cac tien trinh
        // roi dua ket qua tro ve activity
        handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what==0){
                    if (i<5){
                        i++;
                        imgView.setImageLevel(i);
                    } else {
                        i=0;
                        imgView.setImageLevel(i);
                    }

                }
            }
        };

        //timer thuc hien cac cong viec co tinh chat lap lai trong mot khoang thoi gian nhat dinh
        //hoac de dinh thoi cho cac tac vu
        timer=new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        },1000,1000);
    }
}

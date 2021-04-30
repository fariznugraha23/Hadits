package com.klawstrad.hadist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MotionEvent;

import androidx.annotation.Nullable;

public class ActivitySplashScreen extends Activity {
    protected boolean active = true;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread timeThread = new Thread(){
            public void run(){
                try {
                    sleep(2500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    startMainScreen();
                }
            }

        };
        timeThread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
    public void  startMainScreen(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
       if (event.getAction()== MotionEvent.ACTION_DOWN){
           active = false;
       }
       return true;

    }
}

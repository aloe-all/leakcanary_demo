package com.example.com.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.squareup.leakcanary.LeakCanary;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = MainActivity.class.getSimpleName();

    private static Handler mHandler;
    private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LeakCanary.install(getApplication());
        mButton = findViewById(R.id.button);
        mButton.setOnClickListener(this);
        Log.d(TAG,"onCreate");
//        mHandler = new Handler() {
//            @Override
//            public void handleMessage(Message msg) {
//                super.handleMessage(msg);
//                Toast.makeText(MainActivity.this, "receive msg", Toast.LENGTH_LONG).show();
//            }
//        };
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }

    @Override
    public void finish() {
        super.finish();
        Log.d(TAG,"finish");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
//
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
//        mHandler.sendEmptyMessageDelayed(1, 10*60*1000);
//        mHandler.post(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(10*60*1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(this, SecondActivity.class));
    }
}

package com.example.com.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.ref.WeakReference;

/**
 * Created by aloe on 17-11-4.
 */

public class SecondActivity extends Activity {
    private static TextView mTextView;
//    public static TextView mTextView = new TextView(SecondActivity.this);
private static Handler mHandler;
//        = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
////                Toast.makeText(SecondActivity.this, "receive msg", Toast.LENGTH_LONG).show();
//        }
//    };
    private Button mButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
//                Toast.makeText(SecondActivity.this, "receive msg", Toast.LENGTH_LONG).show();
            }
        };

        WeakReference<Context> weakReference = new WeakReference<Context>(getApplicationContext());
        mTextView = new TextView(weakReference.get());
        mTextView.setBackground(getResources().getDrawable(R.drawable.ssss));
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mTextView.setLayoutParams(layoutParams);
        mTextView.setText("second activity");
//        FrameLayout frameLayout = findViewById(R.id.frame_layout);
//        frameLayout.addView(mTextView);
        Button button = findViewById(R.id.button_second);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondActivity.this, SecondActivity.class));
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
//        mTextView = null;
    }

    @Override
    protected void onStop() {
        super.onStop();
//        mTextView = null;
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG", "=====================crg: mTextView" + mTextView);
        Log.d("TAG", "=====================crg mHandler: " + mHandler);
    }
}

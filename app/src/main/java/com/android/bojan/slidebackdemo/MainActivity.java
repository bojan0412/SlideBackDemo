package com.android.bojan.slidebackdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.android.bojan.slidebackdemo.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setSlideable(false);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showBackButton(false);
        findViewById(R.id.btn_click_me).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BlueActivity.class);
                startActivity(intent);
            }
        });
    }
}

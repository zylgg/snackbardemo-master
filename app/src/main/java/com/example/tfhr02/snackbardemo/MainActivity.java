package com.example.tfhr02.snackbardemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bt_hello, bt_hello2, bt_hello3, bt_toast;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bt_hello = (Button) findViewById(R.id.bt_hello);
        bt_hello2 = (Button) findViewById(R.id.bt_hello2);
        bt_hello3 = (Button) findViewById(R.id.bt_hello3);
        bt_toast = (Button) findViewById(R.id.bt_toast);
        bt_hello.setOnClickListener(this);
        bt_hello2.setOnClickListener(this);
        bt_hello3.setOnClickListener(this);
        bt_toast.setOnClickListener(this);
    }

    int count = 0, count2 = 0, count3 = 0;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_hello:
                String title = bt_hello.getText().toString();
                new MySnackbarUtils.Builder(this).setCoverStatusBar(true).setTitle(title + "" + (count++) + "").show();
                break;
            case R.id.bt_hello2:
                String title2 = bt_hello2.getText().toString();
                new MySnackbarUtils.Builder(this).setCoverStatusBar(false).setTitle(title2 + "" + (count2++) + "").show();
                break;
            case R.id.bt_hello3:
                String title3 = bt_hello2.getText().toString();
                new MySnackbarUtils.Builder(this).setLayoutGravity(Gravity.BOTTOM).setTitle(title3 + "" + (count3++) + "").show();
                break;
            case R.id.bt_toast:
                String toast = bt_toast.getText().toString();
//                Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
                MyToast.makeText(this,toast,MyToast.LENGTH_LONG).show();
                break;
        }

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "我点了返回！", Toast.LENGTH_SHORT).show();
        super.onBackPressed();
    }
}

package com.rynfar.listenertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyListenter myListenter = new MyListenter();

        //第一种：将点击事件写入内部类（实现View.OnClickListener接口）
        Button btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(myListenter);

        Button btn11 = (Button) findViewById(R.id.btn11);
        btn11.setOnClickListener(myListenter);

        Button btn12 = (Button) findViewById(R.id.btn12);
        btn12.setOnClickListener(myListenter);

        Button btn13 = (Button) findViewById(R.id.btn13);
        btn13.setOnClickListener(myListenter);

        //第二种：匿名类
        Button btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btn2) {
                    System.out.println("第二种");
                    Toast.makeText(getApplicationContext(), "第二种", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //第三种：自身类实现接口
        Button btn3 = (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(this);

        //第四种：点击时调用xml中声明的 android:onClick="btn4OnClick"同名方法，需要带参数（View v）
        Button btn4 = (Button) findViewById(R.id.btn4);

    }

    //方法一使用到的内部类
    class MyListenter implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.btn1) {
                System.out.println("第一种");
                Toast.makeText(getApplicationContext(), "第一种", Toast.LENGTH_SHORT).show();
            } else if (v.getId() == R.id.btn11) {
                System.out.println("第一种1");
                Toast.makeText(getApplicationContext(), "第一种1", Toast.LENGTH_SHORT).show();
            } else if (v.getId() == R.id.btn12) {
                System.out.println("第一种2");
                Toast.makeText(getApplicationContext(), "第一种2", Toast.LENGTH_SHORT).show();
            } else if (v.getId() == R.id.btn13) {
                System.out.println("第一种3");
                Toast.makeText(getApplicationContext(), "第一种3", Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    //对应第三种方法
    public void onClick(View v) {
        if (v.getId() == R.id.btn3) {
            System.out.println("第三种");
            Toast.makeText(getApplicationContext(), "第三种", Toast.LENGTH_SHORT).show();
        }
    }

    //第四种：点击时调用xml中声明的 android:onClick="btn4OnClick"同名方法，需要带参数（View v）
    public void btn4OnClick(View v) {
        if (v.getId() == R.id.btn4) {
            System.out.println("第四种");
            Toast.makeText(getApplicationContext(), "第四种", Toast.LENGTH_SHORT).show();
        }
    }
}


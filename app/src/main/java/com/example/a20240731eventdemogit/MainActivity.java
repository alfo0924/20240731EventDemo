package com.example.a20240731eventdemogit;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


//impement OnClickListener,OnLongClickListener
public class MainActivity extends AppCompatActivity implements View

        .OnClickListener , View.OnLongClickListener,View.OnTouchListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button b=(Button)findViewById(R.id.button);
        b.setOnClickListener(this);
        b.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View view) {
    TextView tv_text=(TextView) findViewById(R.id.tv_text);
    TextView tv_size=(TextView) findViewById(R.id.tv_size);
    float size=tv_text.getTextSize()+5;   //按下按鈕增加tv_text 的大小
    tv_text.setTextSize(size);
    tv_size.setText(String.valueOf(size));
    }

    @Override
    public boolean onLongClick(View view) {
        TextView tv_text=(TextView) findViewById(R.id.tv_text);
        TextView tv_size=(TextView) findViewById(R.id.tv_size);
        tv_text.setTextSize(30);
        tv_size.setText(String.valueOf("30"));

        return true;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TextView tv_action=(TextView)findViewById(R.id.action);
        TextView tv_position=(TextView)findViewById(R.id.position);
        int act=motionEvent.getAction();
        return false;
    }
}
package com.example.classattendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TeacherActivity extends AppCompatActivity implements View.OnClickListener{
    TextView text_day, text_name;
    Button btn_setting, btn_record, btn_logout;
    String username, currentDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        text_day = (TextView) findViewById(R.id.text_day);
        text_name = (TextView) findViewById(R.id.text_name);

        btn_setting = (Button) findViewById(R.id.btn_setting);
        btn_setting.setOnClickListener(this);
        btn_record = (Button) findViewById(R.id.btn_record);
        btn_record.setOnClickListener(this);
        btn_logout = (Button) findViewById(R.id.btn_back);
        btn_logout.setOnClickListener(this);

        currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        text_day.setText(currentDate);

        Intent intent = getIntent();
        username = intent.getStringExtra("username");
        text_name.setText(username);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_setting:
                Intent intent1 = new Intent(this, ClasssettingActivity.class);
                startActivity(intent1);

                break;
            case R.id.btn_record:
                Intent intent3 = new Intent(this,RecordActivity.class);
                startActivity(intent3);

                break;
            case R.id.btn_back:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);

                break;
            default:
                break;
        }
    }
}
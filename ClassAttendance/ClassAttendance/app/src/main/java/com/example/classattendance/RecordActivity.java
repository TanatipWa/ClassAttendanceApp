package com.example.classattendance;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class RecordActivity extends AppCompatActivity implements View.OnClickListener{
    TextView mDisplayDate;
    DatePickerDialog.OnDateSetListener mDateSetListener;

    TextView text_count;
    ListView listView;
    Button btn_back, btn_show;
    String[] name, surname, show;
    String currentDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        mDisplayDate = (TextView) findViewById(R.id.mDisplayDate);
        text_count = (TextView) findViewById(R.id.text_name);

        listView = (ListView) findViewById(R.id.listView);

        currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        mDisplayDate.setText(currentDate);

        DownloadTextTask task = new DownloadTextTask();
        task.execute("http://192.168.1.35/classattendance/today_attendance.php?currentDate=" + currentDate);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        RecordActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;

                String add1 = "", add2 = "";

                if(day < 10) { add1 = "0"; }
                if(month < 10) { add2 = "0"; }

                String date = add1 + day + "-" + add2 + month + "-" + year;
                mDisplayDate.setText(date);
                currentDate = date;
            }
        };

        btn_show = (Button) findViewById(R.id.btn_show);
        btn_show.setOnClickListener(this);
        btn_back = (Button) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(this);
    }

    private String downloadText(String strUrl) {
        String strResult = "";
        try {
            URL url = new URL(strUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            strResult = readStream(con.getInputStream());
        }catch (Exception e) {
            e.printStackTrace();
        }
        return strResult;
    }

    private String readStream(InputStream in) {
        BufferedReader reader = null;
        StringBuilder sb = new StringBuilder();
        try {
            reader = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(reader != null) {
                try {
                    reader.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_show:
                DownloadTextTask task = new DownloadTextTask();
                task.execute("http://192.168.1.35/classattendance/today_attendance.php?currentDate=" + currentDate);
                break;
            case R.id.btn_back:
                super.onBackPressed();
                break;
            default:
                break;
        }
    }

    private class DownloadTextTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            try {
                return downloadText(urls[0]);
            } catch (Exception e) {
                return e.toString();
            }
        }

        @Override
        protected void onPostExecute(String result) {
            String number_of_students = "0";

            JSONObject contactObject;
            JSONArray jsonArray = null;
            show = new String[0];

            try {
                jsonArray = new JSONArray(result);

                name = new String[jsonArray.length()];
                surname = new String[jsonArray.length()];
                show = new String[jsonArray.length()];

                for(int i = 0; i < jsonArray.length(); i++)
                {
                    contactObject = jsonArray.optJSONObject(i);

                    name[i] = contactObject.optString("name");
                    surname[i] = contactObject.optString("surname");
                    show[i] = (i + 1) + ". name : " + name[i] + "\n"
                            + "surname : " + surname[i];
                }

                number_of_students = Integer.toString(jsonArray.length());
            } catch (Exception ex) {}

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(RecordActivity.this,android.R.layout.simple_list_item_2,android.R.id.text1,show);
            listView.setAdapter(adapter);
            text_count.setText(number_of_students);
        }
    }
}
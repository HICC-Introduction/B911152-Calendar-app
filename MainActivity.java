package com.example.calendar;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.time.Month;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CalendarView calendarView = findViewById(R.id.calendarView);
        //xml file  에서 만든거
        final TextView selectedDay = findViewById(R.id.selectedDay);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                selectedDay.setText(year + "년 " + (month+1) + "월 " + dayOfMonth + "일"); // 선택된 날짜가 위에 중간에 뜨도록
            }
        });

        final EditText textInput = findViewById(R.id.textInput);

    }
}

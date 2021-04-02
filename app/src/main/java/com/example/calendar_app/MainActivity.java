package com.example.calendar_app;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private int currentYear = 0;
    private int currentMonth = 0;
    private int currentDay = 0;

    private int Index = 0;

    private List<String> calendarStrings;
    private int[] days;
    private int[] months;
    private int[] years;
    //private int monthIndex = 0;
//private int yearIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final CalendarView calendarView = findViewById(R.id.calendarView);
        final TextView selectedDay = findViewById(R.id.selectedDay);

        calendarStrings = new ArrayList<>();

        final int numberOfDays = 3000;
        days = new int[numberOfDays];
        months = new int[numberOfDays];
        years = new int[numberOfDays];

        final EditText textInput = findViewById(R.id.textInput);

        final View dayContent = findViewById(R.id.dayContent);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                selectedDay.setText(year + "년 " + (month + 1) + "월 " + dayOfMonth + "일");
                // 선택된 날짜가 위에 중간에 뜨도록
                currentYear = year;
                currentMonth = month;
                currentDay = dayOfMonth;
                /*long saveDate = Long.parseLong(calendarStrings.get(0));
                if(view.getDate() == saveDate){
                    textInput.setText(calendarStrings.get(1));
                }*/
                if (dayContent.getVisibility() == View.GONE) {
                    dayContent.setVisibility(View.VISIBLE);
                }
                for (int h = 0; h < Index; h++) {
                    if (years[h] == currentYear) {
                        for (int i = 0; i < Index; i++) {
                            if (days[i] == currentDay) {
                                for (int j = 0; j < Index; j++) {
                                    if (months[j] == currentMonth && days[j] == currentDay && years[j] == currentYear) {
                                        textInput.setText(calendarStrings.get(j));
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }

                textInput.setText("");
            }
        });

        final Button saveTextButton = findViewById(R.id.saveTextButton);

        saveTextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                days[Index] = currentDay;
                months[Index] = currentMonth;
                years[Index] = currentYear;
                calendarStrings.add(Index, textInput.getText().toString());
                textInput.setText("");
                Index++;
                dayContent.setVisibility(View.GONE);
            }
        });

        }
        @Override
        protected void onPause(){
            super.onPause();
            saveInfo();
        }
        private void saveInfo() {
            File file = new File(this.getFilesDir(), "calendarStrings");
            FileWriter fileWriter = new FileWriter("calendarStrings");

            FileOutputStream out;
            try{
                out = openFileOutput("calendarStrings", Context.MODE_PRIVATE);
                out.write(calendarStrings);
            }catch(Exception e){
                e.printStackTrace();
            }
    }
}
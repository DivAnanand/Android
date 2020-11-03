package com.example.dailyreport2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class EditRecordActivity2 extends AppCompatActivity {
    private EditText DateEt,ProjectEt,ChallengeEt,DifficultyEt,StaffNameEt,TimeEt, VillageEt, PersonGroupEt, MeetingPointEt, ActionPointEt, NextDayPlanningEt;
    private DatabaseHelper dbHelper;
    private String id,date,project,challenge,difficulty,staffname,time, village, personGroup, meetingPoint, actionPoint, nextDayPlanning;
    private boolean editMode = false;
    ActionBar actionBar;
    Button add;
    EditText dateformat;

    int year;
    int month;
    int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_record2);
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);


        DateEt = findViewById(R.id.Date);
        ProjectEt = findViewById(R.id.Project);
        ChallengeEt = findViewById(R.id.challenge);
        DifficultyEt = findViewById(R.id.difficulty);
        StaffNameEt = findViewById(R.id.staffname);
        TimeEt = findViewById(R.id.time);
        VillageEt = findViewById(R.id.village);
        PersonGroupEt = findViewById(R.id.personGroup);
        MeetingPointEt = findViewById(R.id.meetingPoint);
        ActionPointEt = findViewById(R.id.ActionPoint);
        NextDayPlanningEt = findViewById(R.id.nextDayPlanning);
        add = findViewById(R.id.addButton);

        Intent intent = getIntent();
        editMode = intent.getBooleanExtra("editMode", editMode);
        id = intent.getStringExtra("ID");
        date = intent.getStringExtra("DATE");
        project = intent.getStringExtra("PROJECT");
        challenge = intent.getStringExtra("CHALLENGE");
        difficulty = intent.getStringExtra("DIFFICULTY");
        staffname = intent.getStringExtra("STAFFNAME");
        time = intent.getStringExtra("TIME");
        village = intent.getStringExtra("VILLAGE");
        personGroup = intent.getStringExtra("PERSONGROUP");
        meetingPoint = intent.getStringExtra("MEETINGPOINT");
        nextDayPlanning = intent.getStringExtra("NEXTDAYPLANNING");

        if (editMode) {
            actionBar.setTitle("Update Information ");
            editMode = intent.getBooleanExtra("editMode", editMode);
            id = intent.getStringExtra("ID");
            date = intent.getStringExtra("DATE");
            project = intent.getStringExtra("PROJECT");
            challenge = intent.getStringExtra("CHALLENGE");
            difficulty = intent.getStringExtra("DIFFICULTY");
            staffname = intent.getStringExtra("STAFFNAME");
            time = intent.getStringExtra("TIME");
            village = intent.getStringExtra("VILLAGE");
            personGroup = intent.getStringExtra("PERSONGROUP");
            meetingPoint = intent.getStringExtra("MEETINGPOINT");
            actionPoint = intent.getStringExtra("ACTIONPOINT");
            nextDayPlanning = intent.getStringExtra("NEXTDAYPLANNING");

            DateEt.setText(date);
            ProjectEt.setText(project);
            ChallengeEt.setText(challenge);
            DifficultyEt.setText(difficulty);
            StaffNameEt.setText(staffname);
            TimeEt.setText(time);
            VillageEt.setText(village);
            PersonGroupEt.setText(personGroup);
            MeetingPointEt.setText(meetingPoint);
            ActionPointEt.setText(actionPoint);
            NextDayPlanningEt.setText(nextDayPlanning);
        }

        //init dbhelper
        dbHelper = new DatabaseHelper(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
                startActivity(new Intent(EditRecordActivity2.this, MainActivity.class));
                Toast.makeText(EditRecordActivity2.this,"Update Successfully", Toast.LENGTH_SHORT).show();
            }
        });
        dateformat = findViewById(R.id.display_Date);
        final Calendar calendar = Calendar.getInstance();
        dateformat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(EditRecordActivity2.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        dateformat.setText(SimpleDateFormat.getDateInstance().format(calendar.getTime()));
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });
    }
        private void getData () {
            date = "" + DateEt.getText().toString().trim();
            project = "" + ProjectEt.getText().toString().trim();
            challenge = "" + ChallengeEt.getText().toString().trim();
            difficulty = "" + DifficultyEt.getText().toString().trim();
            staffname = "" + StaffNameEt.getText().toString().trim();
            time = "" + TimeEt.getText().toString().trim();
            village = "" + VillageEt.getText().toString().trim();
            personGroup = "" + PersonGroupEt.getText().toString().trim();
            meetingPoint = "" + MeetingPointEt.getText().toString().trim();
            actionPoint = "" + ActionPointEt.getText().toString().trim();
            nextDayPlanning = "" + NextDayPlanningEt.getText().toString().trim();


            if(editMode) {
                {
                    String newTime = "" + System.currentTimeMillis();
                    dbHelper.updateInfo(
                            "" + id,
                            ""+ date,
                            ""+ project,
                            ""+ challenge,
                            ""+ difficulty,
                            "" + staffname,
                            "" + time,
                            "" + village,
                            "" + personGroup,
                            "" + meetingPoint,
                            "" + actionPoint,
                            "" + nextDayPlanning
                    );

                }
            }
            else

            dbHelper.insertInfo(
                    ""+ date,
                    ""+ project,
                    ""+ challenge,
                    ""+ difficulty,
                    "" + staffname,
                    "" + time,
                    "" + village,
                    "" + personGroup,
                    "" + meetingPoint,
                    "" + actionPoint,
                    "" + nextDayPlanning
            );
        }
        @Override
        public boolean onSupportNavigateUp()
        {
            onBackPressed();
            return super.onSupportNavigateUp();
        }
    }

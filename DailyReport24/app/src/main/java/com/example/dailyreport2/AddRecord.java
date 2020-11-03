package com.example.dailyreport2;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class AddRecord extends AppCompatActivity {
    //view
    private EditText DateEt,ProjectEt,ChallengeEt,DifficultyEt,StaffNameEt,TimeEt, VillageEt, PersonGroupEt, MeetingPointEt, ActionPointEt, NextDayPlanningEt;
    private DatabaseHelper dbHelper;
    private String date,project,challenge,difficulty,staffname,time, village, personGroup, meetingPoint, actionPoint, nextDayPlanning;
    ActionBar actionBar;
    Button add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityadd);
        actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Add Information");
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        DateEt = findViewById(R.id.Date);
        ProjectEt = findViewById(R.id.Project);
        ChallengeEt = findViewById(R.id.challenge);
        DifficultyEt = findViewById(R.id.difficulty);
        StaffNameEt = findViewById(R.id.staffname);
        TimeEt =    findViewById(R.id.time);
        VillageEt = findViewById(R.id.village);
        PersonGroupEt = findViewById(R.id.personGroup);
        MeetingPointEt = findViewById(R.id.meetingPoint);
        ActionPointEt = findViewById(R.id.ActionPoint);
        NextDayPlanningEt = findViewById(R.id.nextDayPlanning);
        add = findViewById(R.id.addButton);
        //init dbhelper
        dbHelper = new DatabaseHelper(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               getData();
               startActivity(new Intent(AddRecord.this, MainActivity.class));
               Toast.makeText(AddRecord.this,"Add Successfully",Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void getData(){
        date = "" + DateEt.getText().toString().trim();
        project = "" + ProjectEt.getText().toString().trim();
        challenge = "" + ChallengeEt.getText().toString().trim();
        difficulty = ""+ DifficultyEt.getText().toString().trim();
        staffname = "" +StaffNameEt.getText().toString().trim();
        time = "" + TimeEt.getText().toString().trim();
        village = "" + VillageEt.getText().toString().trim();
        personGroup = "" + PersonGroupEt.getText().toString().trim();
        meetingPoint = "" + MeetingPointEt.getText().toString().trim();
        actionPoint = "" + ActionPointEt.getText().toString().trim();
        nextDayPlanning = "" + NextDayPlanningEt.getText().toString().trim();




        dbHelper.insertInfo(
                  "" +date,
                ""+project,
                ""+challenge,
                ""+difficulty,
                "" +staffname,
                "" +time,
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

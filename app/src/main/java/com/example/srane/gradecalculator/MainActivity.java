package com.example.srane.gradecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void calculateGPA(View view) {

        //grab all the EditTexts pertaining to the grade
        EditText g1 = (EditText) findViewById(R.id.g1);
        EditText g2 = (EditText) findViewById(R.id.g2);
        EditText g3 = (EditText) findViewById(R.id.g3);
        EditText g4 = (EditText) findViewById(R.id.g4);
        EditText g5 = (EditText) findViewById(R.id.g5);

        //grab all the EditTexts pertaining to the units
        EditText u1 = (EditText) findViewById(R.id.u1);
        EditText u2 = (EditText) findViewById(R.id.u2);
        EditText u3 = (EditText) findViewById(R.id.u3);
        EditText u4 = (EditText) findViewById(R.id.u4);
        EditText u5 = (EditText) findViewById(R.id.u5);



        //Convert the grade EditText entries into strings
        String g1Grade = g1.getText().toString();
        String g2Grade = g2.getText().toString();
        String g3Grade = g3.getText().toString();
        String g4Grade = g4.getText().toString();
        String g5Grade = g5.getText().toString();

        double g1ScaledGrade, g2ScaledGrade, g3ScaledGrade, g4ScaledGrade, g5ScaledGrade;

        //If the edit text entry is empty, then scale the GPA to 0.0; otherwise call the conversion function
        if(g1Grade.trim().length() == 0) {
            g1ScaledGrade = 0.0;
        } else {
            g1ScaledGrade = convertToScale(g1Grade);
        }
        if(g2Grade.trim().length() == 0) {
            g2ScaledGrade = 0.0;
        } else {
            g2ScaledGrade = convertToScale(g2Grade);
        }
        if(g3Grade.trim().length() == 0) {
            g3ScaledGrade = 0.0;
        } else {
            g3ScaledGrade = convertToScale(g3Grade);
        }
        if(g4Grade.trim().length() == 0) {
            g4ScaledGrade = 0.0;
        } else {
            g4ScaledGrade = convertToScale(g4Grade);
        }
        if(g5Grade.trim().length() == 0) {
            g5ScaledGrade = 0.0;
        } else {
            g5ScaledGrade = convertToScale(g5Grade);
        }

        //Checks to ensure no entry is invalid and proceeds to calculate GPA
        if(g1ScaledGrade != -1.0 && g2ScaledGrade != -1.0 && g3ScaledGrade != -1.0 &&
                g4ScaledGrade != -1.0 && g5ScaledGrade != -1.0) {

            int u1n,u2n,u3n,u4n,u5n;


            //If the unit EditText is empty, set the units to 0; otherwise, set the units to the indicated value
            if(u1.getText().toString().trim().length() == 0) {
                u1n = 0;
            } else {
                u1n = Integer.parseInt(u1.getText().toString());
            }
            if(u2.getText().toString().trim().length() == 0) {
                u2n = 0;
            } else {
                u2n = Integer.parseInt(u2.getText().toString());
            }
            if(u3.getText().toString().trim().length() == 0) {
                u3n = 0;
            } else {
                u3n = Integer.parseInt(u3.getText().toString());
            }
            if(u4.getText().toString().trim().length() == 0) {
                u4n = 0;
            } else {
                u4n = Integer.parseInt(u4.getText().toString());
            }
            if(u5.getText().toString().trim().length() == 0) {
                u5n = 0;
            } else {
                u5n = Integer.parseInt(u5.getText().toString());
            }


            double GP = g1ScaledGrade*u1n + g2ScaledGrade*u2n + g3ScaledGrade*u3n + g4ScaledGrade*u4n + g5ScaledGrade*u5n;
            double GPA = GP/(u1n + u2n + u3n + u4n + u5n);
            String displayGPA = String.format("%.3f", GPA);

            TextView gpaBox = (TextView) findViewById(R.id.gpa_box);
            gpaBox.setText(displayGPA);
        }


    }

    private double convertToScale(String s){
        if(s.equals("A+")) {
            return 4.3;
        } else if(s.equals("A")) {
            return 4.0;
        } else if(s.equals("A-")) {
            return 3.7;
        } else if(s.equals("B+")) {
            return 3.3;
        } else if(s.equals("B")) {
            return 3.0;
        } else if(s.equals("B-")) {
            return 2.7;
        } else if(s.equals("C+")) {
            return 2.3;
        } else if(s.equals("C")) {
            return 2.0;
        } else if(s.equals("C-")) {
            return 1.7;
        } else if(s.equals("D+")) {
            return 1.3;
        } else if(s.equals("D")) {
            return 1.0;
        } else if(s.equals("D-")) {
            return 0.7;
        } else if(s.substring(0,1).equals("F")) {
            return 0.0;
        }
        //Invalid entry
        else {
            TextView gpaBox = (TextView) findViewById(R.id.gpa_box);
            gpaBox.setText("Error! Incorrect Entry");
            return -1.0;//You want to indicate that there was an error entry
        }
    }

    public void refresh(View view) {
        EditText g1 = (EditText) findViewById(R.id.g1);
        EditText g2 = (EditText) findViewById(R.id.g2);
        EditText g3 = (EditText) findViewById(R.id.g3);
        EditText g4 = (EditText) findViewById(R.id.g4);
        EditText g5 = (EditText) findViewById(R.id.g5);

        EditText u1 = (EditText) findViewById(R.id.u1);
        EditText u2 = (EditText) findViewById(R.id.u2);
        EditText u3 = (EditText) findViewById(R.id.u3);
        EditText u4 = (EditText) findViewById(R.id.u4);
        EditText u5 = (EditText) findViewById(R.id.u5);

        g1.getText().clear();
        g2.getText().clear();
        g3.getText().clear();
        g4.getText().clear();
        g5.getText().clear();

        u1.getText().clear();
        u2.getText().clear();
        u3.getText().clear();
        u4.getText().clear();
        u5.getText().clear();
    }
}

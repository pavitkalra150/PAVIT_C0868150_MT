package com.example.pavit_c0868150_mt;

import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner cars;
    EditText dailyrent;
    TextView noofdays;
    SeekBar daysBar;
    RadioGroup group;
    CheckBox gps;
    CheckBox childSeat;
    CheckBox unlimitedMileage;
    EditText amount;
    EditText payment;
    Button detailsbtn;
    int days;
    int amt;
    int dailyCarPrice;
    double tamt;
    double roundtamt;
    String cartype;
Button placeorder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cars = findViewById(R.id.carsdropdown);
        dailyrent = findViewById(R.id.dailyrent);
        noofdays = findViewById(R.id.noofdays);
        daysBar = findViewById(R.id.daysbar);
        group = findViewById(R.id.group);
        gps = findViewById(R.id.one);
        childSeat = findViewById(R.id.two);
        unlimitedMileage = findViewById(R.id.three);
        amount = findViewById(R.id.amount);
        payment = findViewById(R.id.total);
        detailsbtn = findViewById(R.id.detailsbtn);
        placeorder = findViewById(R.id.placeorder);
        daysBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                noofdays.setText(String.valueOf(progress) + " days");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        cars.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                calculateDailyRent();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        detailsbtn.setOnClickListener(v -> {
            if(checkError()) {
                calculateAmount();
            }
        });

        placeorder.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);

            intent.putExtra("car", cartype);
            intent.putExtra("days", days);
            intent.putExtra("amount", amt);
            intent.putExtra("payment",tamt);
            startActivity(intent);
        });
    }


        boolean checkError(){
            if(group.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "Please select Age Range", Toast.LENGTH_SHORT).show();
                return false;
            }
            return true;
        }


    void calculateDailyRent(){
        cartype = cars.getSelectedItem().toString();

        switch(cartype){
            case "Please choose a car":
                dailyCarPrice = 0;
                dailyrent.setText("");
                break;
            case "BMW":
                dailyCarPrice = 100;
                dailyrent.setText(dailyCarPrice + "$");
                break;
            case "AUDI":
                dailyCarPrice = 120;
                dailyrent.setText(dailyCarPrice + "$");
                break;
            case "CARDILLAC":
                dailyCarPrice = 130;
                dailyrent.setText(dailyCarPrice + "$");
                break;
            case "VOLKS WAGON":
                dailyCarPrice = 140;
                dailyrent.setText(dailyCarPrice + "$");
                break;
            case "MERCEDES":
                dailyCarPrice = 150;
                dailyrent.setText(dailyCarPrice + "$");
                break;
            case "PEUGEOT":
                dailyCarPrice = 160;
                dailyrent.setText(dailyCarPrice + "$");
                break;
            default:
                dailyCarPrice = 100;
                break;
        }
    }
    void calculateAmount(){

        cartype = cars.getSelectedItem().toString();

        switch(cartype){
            case "Please choose a car":
                dailyCarPrice = 0;
                dailyrent.setText("");
                break;
            case "BMW":
                dailyCarPrice = 100;
                dailyrent.setText(dailyCarPrice + "$");
                break;
            case "AUDI":
                dailyCarPrice = 120;
                dailyrent.setText(dailyCarPrice + "$");
                break;
            case "CARDILLAC":
                dailyCarPrice = 130;
                dailyrent.setText(dailyCarPrice + "$");
                break;
            case "VOLKS WAGON":
                dailyCarPrice = 140;
                dailyrent.setText(dailyCarPrice + "$");
                break;
            case "MERCEDES":
                dailyCarPrice = 150;
                dailyrent.setText(dailyCarPrice + "$");
                break;
            case "PEUGEOT":
                dailyCarPrice = 160;
                dailyrent.setText(dailyCarPrice + "$");
                break;
            default:
                dailyCarPrice = 100;
                break;
        }
        int dealId = group.getCheckedRadioButtonId();
        int value;
        switch(dealId){
            case R.id.first:
                value = dailyCarPrice + 5;
                break;
            case R.id.second:
                value = dailyCarPrice;
                break;
            case R.id.third:
                value = dailyCarPrice - 10;
                break;
            default:
                value = dailyCarPrice;
        }

        if(gps.isChecked()){
            value = value + 5;
        }
        if(childSeat.isChecked()){
            value = value + 7;
        }
        if(unlimitedMileage.isChecked()){
            value = value + 10;
        }

        days = daysBar.getProgress();
        amt = days * value;
        amount.setText(String.valueOf(amt) + "$");


        tamt = amt + (amt * 0.13);
        payment.setText(String.valueOf(tamt) + "$");

        placeorder.setVisibility(View.VISIBLE);
    }
}
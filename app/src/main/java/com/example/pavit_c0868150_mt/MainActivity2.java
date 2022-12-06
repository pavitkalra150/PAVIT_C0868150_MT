package com.example.pavit_c0868150_mt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String car = getIntent().getStringExtra("car");
        TextView carvalue = findViewById(R.id.carvalue);

        int day = getIntent().getIntExtra("days", 0);
        TextView daysvalue = findViewById(R.id.daysvalue);

        int amount = getIntent().getIntExtra("amount", 0);
        TextView amountvalue = findViewById(R.id.amountvalue);

        double payment = getIntent().getDoubleExtra("payment", 0.00);
        TextView paymentvalue = findViewById(R.id.paymentvalue);

        carvalue.setText(car);
        daysvalue.setText(String.valueOf(day));
        amountvalue.setText(String.valueOf(amount));
        paymentvalue.setText(String.valueOf(payment));

        Button order = findViewById(R.id.order);


        order.setOnClickListener(v -> {
            Toast.makeText(this, "Congrats Your Order is Placed", Toast.LENGTH_LONG).show();
        });
    }
}
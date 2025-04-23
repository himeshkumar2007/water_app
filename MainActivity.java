package com.example.water_app;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etPH, etTurbidity;
    Button btnCheck;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPH = findViewById(R.id.etPH);
        etTurbidity = findViewById(R.id.etTurbidity);
        btnCheck = findViewById(R.id.btnCheck);
        tvResult = findViewById(R.id.tvResult);

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkWaterQuality();
            }
        });
    }

    private void checkWaterQuality() {
        String phStr = etPH.getText().toString();
        String turbStr = etTurbidity.getText().toString();

        if (phStr.isEmpty() || turbStr.isEmpty()) {
            tvResult.setText("Please enter all values.");
            return;
        }

        double ph = Double.parseDouble(phStr);
        double turbidity = Double.parseDouble(turbStr);

        if (ph >= 6.5 && ph <= 8.5 && turbidity < 5) {
            tvResult.setText("Water Quality: SAFE ✅");
        } else {
            tvResult.setText("Water Quality: UNSAFE ❌");
        }
    }
}

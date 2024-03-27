package com.example.maliyethesap;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editText1, editText2, editText3, editText4, editText5, editText6;
    TextView resultTextView;
    Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        editText5 = findViewById(R.id.editText5);
        editText6 = findViewById(R.id.editText6);
        resultTextView = findViewById(R.id.resultTextView);
        calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateCost();
            }
        });
    }

    private void calculateCost() {
        double kumasParasi = parseDoubleOrZero(editText1.getText().toString());
        double dikimciParasi = parseDoubleOrZero(editText2.getText().toString());
        double kesimciParasi = parseDoubleOrZero(editText3.getText().toString());
        double biyeParasi = parseDoubleOrZero(editText4.getText().toString());
        double paketParasi = parseDoubleOrZero(editText5.getText().toString());
        double toplamUrunSayisi = parseDoubleOrZero(editText6.getText().toString());

        double toplamMaliyet = kumasParasi + dikimciParasi + kesimciParasi + biyeParasi + paketParasi;
        double birimMaliyet = toplamMaliyet / toplamUrunSayisi;

        resultTextView.setText("Maliyet: " + birimMaliyet);
    }

    private double parseDoubleOrZero(String text) {
        if (text.trim().isEmpty()) {
            return 0;
        }
        return Double.parseDouble(text);
    }
}

package com.example.indicant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.warkiz.widget.IndicatorSeekBar;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private IndicatorSeekBar heightValue, weightValue;
    private Button btn;
    private TextView textView,textView1;
    private static DecimalFormat df2 = new DecimalFormat("##.##");
    private ToggleButton toggleButton;
    ImageView imageView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heightValue = (IndicatorSeekBar) findViewById(R.id.HeightValue);
        weightValue = (IndicatorSeekBar) findViewById(R.id.WeightValue);
        btn = (Button) findViewById(R.id.btn);
        textView = (TextView)findViewById(R.id.txt);
        textView1 = (TextView)findViewById(R.id.txt1);
        toggleButton = (ToggleButton)findViewById(R.id.toggle2);
        imageView = (ImageView)findViewById(R.id.icon);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double height = Double.parseDouble(String.valueOf(heightValue.getProgress()));
                double weight = Double.parseDouble(String.valueOf(weightValue.getProgress()));
                Boolean aBoolean = toggleButton.isChecked();

                double bmi = ((weight*10000)/Math.pow(height, 2));

                if (aBoolean == true) {
                    if (bmi <= 18.5) {
                        textView.setText(df2.format(bmi) + " kg/m^2");
                        textView1.setText("UNDERWEIGHT");
                        imageView.setBackgroundResource(R.drawable.underweightf);
                    } else if (bmi <= 24.9) {
                        textView.setText(df2.format(bmi) + " kg/m^2");
                        textView1.setText("NORMAL");
                        imageView.setBackgroundResource(R.drawable.normalf);
                    } else if (bmi <= 29.9) {
                        textView.setText(df2.format(bmi) + " kg/m^2");
                        textView1.setText("OVERWEIGHT");
                        imageView.setBackgroundResource(R.drawable.overweightf);
                    } else {
                        textView.setText(df2.format(bmi) + " kg/m^2");
                        textView1.setText("OBESE");
                        imageView.setBackgroundResource(R.drawable.obesef);
                    }
                }
                else {
                    if (bmi <= 18.5) {
                        textView.setText(df2.format(bmi) + " kg/m^2");
                        textView1.setText("UNDERWEIGHT");
                        imageView.setBackgroundResource(R.drawable.underweight);
                    } else if (bmi <= 24.9) {
                        textView.setText(df2.format(bmi) + " kg/m^2");
                        textView1.setText("NORMAL");
                        imageView.setBackgroundResource(R.drawable.normal);
                    } else if (bmi <= 29.9) {
                        textView.setText(df2.format(bmi) + " kg/m^2");
                        textView1.setText("OVERWEIGHT");
                        imageView.setBackgroundResource(R.drawable.overweight);
                    } else {
                        textView.setText(df2.format(bmi) + " kg/m^2");
                        textView1.setText("OBESE");
                        imageView.setBackgroundResource(R.drawable.obese);
                    }
                }
            }
        });

    }
}

package sg.edu.rp.c346.id20042755.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button calculate;
    TextView results;
    EditText weightText,heightText;
    ImageView face;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculate = findViewById(R.id.buttonCalculate);

        results = findViewById(R.id.textViewBMI);
        heightText = findViewById(R.id.editTextHeight);
        weightText = findViewById(R.id.editTextWeight);
        face = findViewById(R.id.imageView);
        face.setVisibility(View.INVISIBLE);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (v.getId() == R.id.buttonCalculate) {

                    EditText weightText = findViewById(R.id.editTextWeight);
                    EditText heightText = findViewById(R.id.editTextHeight);
                    TextView resultText = findViewById(R.id.textViewBMI);


                    float weight =  Float.parseFloat(weightText.getText().toString());
                    float height = Float.parseFloat(heightText.getText().toString());

                    float bmiValue = calculateBMI(weight, height);

                    String bmiInterpretation = interpretBMI(bmiValue);

                    resultText.setText(bmiValue + " and you are " + bmiInterpretation + " \n Click on the image to find out more");
                }
            }

            private float calculateBMI(float weight, float height) {

                  return  weight / (height*height);

            }

            private String interpretBMI(float bmiValue) {

                if (bmiValue < 18.5) {
                    face.setImageResource(R.drawable.clipart1978283);
                    face.setVisibility(View.VISIBLE);
                    face.setOnClickListener(v -> {
                        Intent i = new Intent(MainActivity.this, activity_main2.class);
                        startActivity(i);
                    });
                    return "Underweight";
                } else if (bmiValue < 25) {
                    face.setImageResource(R.drawable.smiling_face_emoji_large);
                    face.setVisibility(View.VISIBLE);
                    face.setOnClickListener(v -> {
                        Intent i = new Intent(MainActivity.this, MainActivity2.class);
                        startActivity(i);
                    });
                    return "Normal";

                } else if (bmiValue < 30) {
                    face.setImageResource(R.drawable.pouting_face_emoji_by_google);
                    face.setVisibility(View.VISIBLE);
                    face.setOnClickListener(v ->{
                        Intent i = new Intent(MainActivity.this, MainActivity3.class);
                        startActivity(i);
                    });
                    return "Overweight";
                } else {
                    return "Obese";
                }
            }

        });


    }

}
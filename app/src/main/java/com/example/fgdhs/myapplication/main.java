package com.example.fgdhs.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class main extends AppCompatActivity {
    Button calculation;
    EditText tall;
    EditText body;
    EditText year;
    TextView BMI_textView;
    TextView TextView2;
    TextView textView1;

    int sex=0;
    double BMI;
    double x,z;
    int y;
    String pp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BMI_textView = (TextView) findViewById(R.id.BMI_textView);
        TextView2 = (TextView) findViewById(R.id.TextView2) ;
        textView1 = (TextView)findViewById(R.id.textView1);
        RadioGroup rg1 = (RadioGroup) findViewById(R.id.radioGroup);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId)
                {
                    case R.id.boy:
                        sex=1;
                        y=25;
                        break;
                    case R.id.girl:
                        sex=0;
                        y=22;
                        break;
                }
            }
        });

        calculation = (Button) findViewById(R.id.calculation);
        calculation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tall = (EditText) findViewById(R.id.tall);
                body= (EditText) findViewById(R.id.body);
                year= (EditText) findViewById(R.id.year);
                double tall_tem = Integer.parseInt(tall.getText().toString());
                double body_temp = Integer.parseInt(body.getText().toString());
                double year_temp = Integer.parseInt(year.getText().toString());
                    double tall_temp = tall_tem/100;
                BMI= body_temp / (tall_temp*tall_temp);
                x= (1.2*BMI)+(0.23*year_temp-5.4)-(10.8*sex);
                z=tall_temp*y;
                if (BMI<18.5)
                {
                    pp ="體重過輕";
                }
                else if ((18.5<=BMI)&&(BMI<24))
                {
                    pp ="正常";
                }
                else if ((24<=BMI)&&(BMI<27))
                {
                    pp ="過重";
                }
                else if ((27<=BMI)&&(BMI<30))
                {
                    pp ="輕度肥胖";
                }
                else if ((30<=BMI)&&(BMI<35))
                {
                    pp ="中度肥胖";
                }
                else if (BMI<=35)
                {
                    pp ="重度肥胖";
                }
                BMI_textView.setText("BMI:"+BMI+"\n"+pp);
                TextView2.setText("標準體重:"+z);
                textView1.setText("體指率:"+x);

            }
        });
    }
}

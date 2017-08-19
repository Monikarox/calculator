package com.rcpl.calculatorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{    Button badd,bsub, bdiv, bmult;
    TextView result;
    EditText ed1, ed2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    void init()
    {
        badd=(Button)findViewById(R.id.button);
        bsub=(Button)findViewById(R.id.button2);
        bdiv=(Button)findViewById(R.id.button3);
        bmult=(Button)findViewById(R.id.button4);

        ed1=(EditText)findViewById(R.id.editText);
        ed2=(EditText)findViewById(R.id.editText2);
        result = (TextView)findViewById(R.id.textView);

        Calculate c = new Calculate();
        badd.setOnClickListener( c );
        bsub.setOnClickListener(c);
        bdiv.setOnClickListener(c);
        bmult.setOnClickListener(c);

    }
    class Calculate implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            String num1 = ed1.getText().toString();
            String num2 = ed2.getText().toString();

            switch (view.getId()) {
                case R.id.button:
                    int addition = Integer.parseInt(num1) + Integer.parseInt(num2);
                    result.setText(String.valueOf(addition));
                    break;
                case R.id.button2:
                    int subtract = Integer.parseInt(num1) - Integer.parseInt(num2);
                    result.setText(String.valueOf(subtract));
                    break;
                case R.id.button4:
                    try {
                        int division = Integer.parseInt(num1) / Integer.parseInt(num2);
                        result.setText(String.valueOf(division));
                    } catch (Exception e) {
                        result.setText("Can't DIVIDE");
                    }
                    break;
                case R.id.button3:
                    int multiply = Integer.parseInt(num1) * Integer.parseInt(num2);
                    result.setText(String.valueOf(multiply));
                    break;
            }
        }
    }

}

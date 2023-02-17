package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mariuszgromada.math.mxparser.Expression;

public class MainActivity extends AppCompatActivity {

     TextView tvResult;
    TextView tvExpression;

    public void initValues(){
        tvExpression.setText("");
        tvResult.setText("0");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = findViewById(R.id.result_view);
        tvExpression = findViewById(R.id.expression_view);
        initValues();
    }


    public void calculate(View v){

        String  expression = tvExpression.getText().toString();
        Expression exp = new Expression(expression);
        String result = String.valueOf(exp.calculate());
        tvResult.setText(result.substring(0, Math.min(result.length(), 10)));

    }
    public void setTextViewExpression(View v){
        String val = ((Button)v).getText().toString();
        switch (val){
            case "!x": val="!"; break;
            case "x^2": val="^2"; break;
            case "1/x": val="1/"; break;
            case "0":
                if(tvExpression.getText().toString().equals("0")){
                    val="0";
                }
                break;
        }
        tvExpression.setText(tvExpression.getText().toString()+val);
    }

    public void clearScrean(View v){
        initValues();
    }

    public void backSpace(View v){
        String expression = tvExpression.getText().toString();
        if(expression.length() > 0){
            expression = expression.substring(0, expression.length()-1);
            tvExpression.setText(expression);
        }
    }


}
package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.SolverVariable;

import android.accessibilityservice.AccessibilityService;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView Screen;
    private Button AC,power,back,div,mul,add,min,one,two,three,four,five,six,seven,eight,nine,zero,ans,point,equal;
    private String input,answer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Screen=findViewById(R.id.screen);
        AC=findViewById(R.id.ac);
        power=findViewById(R.id.power);
        back=findViewById(R.id.back);
        div=findViewById(R.id.div);
        mul=findViewById(R.id.mul);
        add=findViewById(R.id.add);
        min=findViewById(R.id.min);
        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
        four=findViewById(R.id.four);
        five=findViewById(R.id.five);
        six=findViewById(R.id.six);
        seven=findViewById(R.id.seven);
        eight=findViewById(R.id.eight);
        nine=findViewById(R.id.nine);
        zero=findViewById(R.id.zero);
        ans=findViewById(R.id.ans);
        point=findViewById(R.id.point);
        equal=findViewById(R.id.equal);
    }
    //add
    public void Buttonclick(View VIew){
        Button button=(Button) VIew;
        String data=button.getText().toString();
        switch (data){
            case"AC":
                input="";
                break;
            case "ans":
                input+=answer;
                break;
            case "x":
                solve();
                input+="*";
                break;
            case "^":
                solve();
                input+="^";
                break;
            case "=":
                solve();
                answer=input;
                break;
            case "B":
                String newText=input.substring(0,input.length()-1);
                input=newText;
                break;
            default:
                if (input==null){
                    input="";
                }
                if (data.equals("+") || data.equals("-") || data.equals("/") ){
                        solve();
                    }
                    input+=data;
        }
        Screen.setText(input);
    }

    private void solve(){


        if (input.split("\\*").length==2) {
            String number[] = input.split("\\*");
            try {
                double mul = Double.parseDouble(number[0]) * Double.parseDouble(number[1]);
                input = Double.toString(mul);
            } catch (Exception e) {
                //toggle error
            }
        }
        else if (input.split( "/").length==2) {
            String number[] = input.split("\\/");
            try {
                double div = Double.parseDouble(number[0])/Double.parseDouble(number[1]);
                input = Double.toString(div);
            } catch (Exception e) {
                //toggle error
            }
        }
       else if (input.split( "\\^").length==2) {
            String number[] = input.split("\\^");
            try {
                double power = Math.pow(Double.parseDouble(number[0]),Double.parseDouble(number[1]));
                input = power+ "";
            } catch (Exception e) {
                //toggle error
            }
        }
        else if (input.split( "\\+").length==2) {
            String number[] = input.split("\\+");
            try {
                double add = Double.parseDouble(number[0])+Double.parseDouble(number[1]);
                input =Double.toString(add);
            } catch (Exception e) {
                //toggle error
            }
        }
         else if (input.split( "-").length==2) {
             String number[] = input.split("\\-");
             //to min from a negative number like -5-8
             if (number[0]==""&& number.length==2){
                 number[0]=0+"";
             }
             try {
                 double min = Double.parseDouble(number[0])-Double.parseDouble(number[1]);
                 input =Double.toString(min);
             } catch (Exception e) {
                 //toggle error
             }
         }

         //to remove the last digit .0 from the integer result like 9 instead of 9.0
        String n[]=input.split("\\.");
         if (n.length>1){
             if (n[1].equals("0")){
                 input=n[0];
             }
         }
         Screen.setText(input);
    }

}
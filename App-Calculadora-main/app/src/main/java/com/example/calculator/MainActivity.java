package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView Screen;
    private Button One, Two, Three, Four, Five, Six, Seven, Eight, Nine, Zero;
    private Button AC, Power, Raiz, Back, Div, Mul, Plus, Min, Ans, Point, Equal;
    private String input, Answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Screen = findViewById(R.id.screen);
        AC = findViewById(R.id.ac);
        Power = findViewById(R.id.power);
        Back = findViewById(R.id.back);
        Div = findViewById(R.id.div);
        Nine = findViewById(R.id.nine);
        Eight = findViewById(R.id.eight);
        Seven = findViewById(R.id.seven);
        Six = findViewById(R.id.six);
        Five = findViewById(R.id.five);
        Four = findViewById(R.id.four);
        Three = findViewById(R.id.three);
        Two = findViewById(R.id.two);
        One = findViewById(R.id.one);
        Zero = findViewById(R.id.zero);
        Mul = findViewById(R.id.mul);
        Plus = findViewById(R.id.plus);
        Min = findViewById(R.id.min);
        Ans = findViewById(R.id.ans);
        Point = findViewById(R.id.point);
        Equal = findViewById(R.id.equal);
        Raiz = findViewById(R.id.raiz);
    }

    public void ButtonClick(View view){
        Button button = (Button)view;
        String data = button.getText().toString();
        switch(data){
            case "AC":
                input = "";
                break;
            case "Ans":
                input += Answer;
                break;
            case "x":
                Solve();
                input += "*";
                break;
            case "√":
                Solve();
                input += "√";
                break;
            case "^":
                Solve();
                input += "^";
                break;
            case "=":
                Solve();
                Answer = input;
                break;
            case "←":
                String newText = input.substring(0,input.length()-1);
                input = newText;
                break;
            default:
                if(input == null){
                    input = "";
                }
                if(data.equals("+") || data.equals("-") || data.equals("/")){
                    Solve();
                }
                input += data;
        }
        Screen.setText(input);
    }

    private void Solve(){
        if(input.split("\\*").length == 2){
            String number[] = input.split("\\*");
            try{
                double mul = Double.parseDouble(number[0]) * Double.parseDouble(number[1]);
                input = mul+"";
            } catch(Exception e){
                e.printStackTrace(System.out);
            }
        }

        else if(input.split("/").length == 2){
            String number[] = input.split("/");
            try{
                double div = Double.parseDouble(number[0]) / Double.parseDouble(number[1]);
                input = div+"";
            } catch(Exception e){
                e.printStackTrace(System.out);
            }
        }

        else if(input.split("\\√").length == 2){
            String number[] = input.split("\\√");
            try{
                double raiz = Math.sqrt(Double.parseDouble(number[1]));
                input = raiz+"";
            } catch(Exception e){
                e.printStackTrace(System.out);
            }
        }

        else if(input.split("\\^").length == 2){
            String number[] = input.split("\\^");
            try{
                double pow = Math.pow(Double.parseDouble(number[0]), Double.parseDouble(number[1]));
                input = pow+"";
            } catch(Exception e){
                e.printStackTrace(System.out);
            }
        }

        else if(input.split("\\+").length == 2){
            String number[] = input.split("\\+");
            try{
                double sum = Double.parseDouble(number[0]) + Double.parseDouble(number[1]);
                input = sum+"";
            } catch(Exception e){
                e.printStackTrace(System.out);
            }
        }

        else if(input.split("-").length > 1){
            String number[] = input.split("-");
            if(number[0] == "" && number.length == 2){
                number[0] = 0 + "";
            }
            try{
                double sub = 0;
                if(number.length == 2){
                    sub = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
                }
                else if(number.length == 3){
                    sub = Double.parseDouble(number[1]) - Double.parseDouble(number[2]);
                }
                input = sub+"";
            } catch(Exception e){
                e.printStackTrace(System.out);
            }
        }
        String n[] = input.split("\\.");
        if(n.length > 1){
            if(n[1].equals("0")){
                input = n[0];
            }
        }
        Screen.setText(input);
    }
}
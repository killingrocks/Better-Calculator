package com.example.meoryou.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class calculator extends AppCompatActivity {
    private static final String TAG= "Calculator";
    Button num1,num2,num3,num4,num5,num6,num7,num8,num9,num0;
    Button answer,add,sub,divide,multiply;
    Button back_space, clear, decimal, plus_min;
    TextView display;
    double result;
    String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        initializeViewComponents();
    }

    // on click listener update the method
    public void button0OnClick(View view){ display.setText(display.getText()+ "0");}
    public void button1OnClick(View view){display.setText(display.getText()+ "1");}
    public void button2OnClick(View view){display.setText(display.getText()+ "2");}
    public void button3OnClick(View view){display.setText(display.getText()+ "3");}
    public void button4OnClick(View view){display.setText(display.getText()+ "4");}
    public void button5OnClick(View view){display.setText(display.getText()+ "5");}
    public void button6OnClick(View view){display.setText(display.getText()+ "6");}
    public void button7OnClick(View view){display.setText(display.getText()+ "7");}
    public void button8OnClick(View view){display.setText(display.getText()+ "8");}
    public void button9OnClick(View view){display.setText(display.getText()+ "9");}

    public void buttonAddOnClick(View view){
        try {
            // you get the result of what was place before you click the button
            result = Double.parseDouble((String) display.getText());
            // then you clear the screen so that you can write another number
            display.setText("");
            // check
            if (operation != "")
                Operation(operation);
        } catch(NumberFormatException e){
            Log.e(TAG,"converting String to integer");
            e.printStackTrace();
        }
        operation= "+";

    }
    public void buttonSubtractOnClick(View view) {
        try {
            // you get the result of what was place before you click the button
            result = Double.parseDouble((String) display.getText());
            // then you clear the screen so that you can write another number
            display.setText("");
            // check
            if (operation != "")
                Operation(operation);
        } catch(NumberFormatException e){
            Log.e(TAG,"converting String to integer");
            e.printStackTrace();
        }
        operation= "-";


    }
    public void buttonMultiplyOnClick(View view){
        try {
            // you get the result of what was place before you click the button
            result = Double.parseDouble((String) display.getText());
            // then you clear the screen so that you can write another number
            display.setText("");
            // check
            if (operation != "")
                Operation(operation);
        } catch(NumberFormatException e){
            e.printStackTrace();
        }
        operation= "*";
    }
    public void buttonDivisionOnClick(View view){
        try {
            // you get the result of what was place before you click the button
            result = Double.parseDouble((String) display.getText());
            // then you clear the screen so that you can write another number
            display.setText("");
            // check
            if (operation != "")
                Operation(operation);
        } catch(NumberFormatException e){
            e.printStackTrace();
        }
        operation= "/";
    }

    public void buttonAnswerOnClick(View view) {
        try {
            if (operation != "")
                Operation(operation);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        display.setText(String.valueOf(result));
        result = 0;
        operation ="";
    }


    public void Operation(String operation) {
        switch (operation) {
            case "+":
                result += Double.parseDouble((String) display.getText());
                break;
            case "-":
                result -= Double.parseDouble((String) display.getText());
                break;
            case "*":
                result *= Double.parseDouble((String) display.getText());
                break;
            case "/":
                result /= Double.parseDouble((String) display.getText());
                break;

        }
    }
    // everything should be initialize
    public void buttonClearViewOnClick(View view){
        display.setText("");
        operation= "";
        result =  0;
    }
    // i need to take off the values of this thing one by one.
    public void buttonBackSpaceOnClick(View view){
        char[] CharacterOfString ;
        String Word = (String) display.getText();
        CharacterOfString = Word.toCharArray();
        Word="";
        for (int count = 0; CharacterOfString.length-1 > count; count++){
            Word+=CharacterOfString[count];
        }
       /* for(char SingleChar: CharacterOfString){
            if(CharacterOfString[CharacterOfString.length-1]!= SingleChar)
            Word+=SingleChar;
        }*/
        display.setText(Word);

    }

    public void buttonPlusOrMinusOnClick(View view){
        try{
        display.setText(String.valueOf(-1*Double.parseDouble((String) display.getText())));
    }catch(NumberFormatException e){}
}

    public void buttonDecimalPlaceOnClick(View view) {display.setText(display.getText() + ".");    }





    private void initializeViewComponents() {
        num0 = (Button)findViewById(R.id.num_0);
        num1 = (Button)findViewById(R.id.num_1);
        num2 = (Button)findViewById(R.id.num_2);
        num3 = (Button)findViewById(R.id.num_3);
        num4 = (Button)findViewById(R.id.num_4);
        num5 = (Button)findViewById(R.id.num_5);
        num6 = (Button)findViewById(R.id.num_6);
        num7 = (Button)findViewById(R.id.num_7);
        num8 = (Button)findViewById(R.id.num_8);
        num9 = (Button)findViewById(R.id.num_9);
        add = (Button)findViewById(R.id.basic_add);
        sub = (Button)findViewById(R.id.basic_subtract);
        multiply = (Button)findViewById(R.id.basic_multiply);
        divide = (Button)findViewById(R.id.basic_division);
        display = (TextView)findViewById(R.id.display_operation);
        answer = (Button) findViewById(R.id.basic_answer);
        back_space= (Button) findViewById(R.id.back_space);
        clear =(Button) findViewById(R.id.clear_view);
        decimal = (Button) findViewById(R.id.decimal_place);
        result =0;
        operation ="";
    }



}

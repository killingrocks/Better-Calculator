package com.example.meoryou.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class calculator extends AppCompatActivity {
    TextView display, logical;
    double result;
    String operation;
    String logic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        initializeViewComponents();
    }

    // on click listener update the method
    public void button0OnClick(View view){display.setText(display.getText()+ "0");}
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
            checkIfResultInitialize();
            // check
            if (operation != "")
                Operation(operation);
        } catch(NumberFormatException e){e.printStackTrace(); }
        operation= "+";

    }
    public void buttonSubtractOnClick(View view) {
        try {
            checkIfResultInitialize();
            // check the sign of the operation
            if (operation != "")
                Operation(operation);
        } catch(NumberFormatException e){e.printStackTrace();}
        operation= "-";


    }
    public void buttonMultiplyOnClick(View view){
        try {
            checkIfResultInitialize();
            // check
            if (operation != "")
                Operation(operation);
            logical.setText(logic);
        } catch(NumberFormatException e){}
        operation= "*";
    }
    public void buttonDivisionOnClick(View view){
        try {
            checkIfResultInitialize();
            // check
            if (operation != "")
                Operation(operation);
        } catch(NumberFormatException e){}
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
        logic = (String) display.getText();
        result = 0;
        operation ="=";
    }


    public void Operation(String operation) {
        switch (operation) {
            case "+":
                result += Double.parseDouble((String) display.getText());
                logic += operation +""+(String) display.getText();
                logical.setText(logic);
                //clear the left over text
                display.setText("");
                break;
            case "-":
                result -= Double.parseDouble((String) display.getText());
                logic += operation +""+(String) display.getText();
                logical.setText(logic);
                // clear
                display.setText("");
                break;
            case "*":
                result *= Double.parseDouble((String) display.getText());
                logic += operation +""+(String) display.getText();
                logical.setText(logic);
                // clear
                display.setText("");
                break;
            case "/":
                result /= Double.parseDouble((String) display.getText());
                logic += operation +""+(String) display.getText();
                logical.setText(logic);
                //clear
                display.setText("");
                break;

        }
    }
    // everything should be initialize
    public void buttonClearViewOnClick(View view){
        display.setText("");
        operation= "";
        result =  0;
        logical.setText("");
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
        display = (TextView)findViewById(R.id.display_operation);
        logical= (TextView) findViewById(R.id.logic_operation);
        result =0;
        operation ="";
    }
    public void checkIfResultInitialize(){
        // you get the result of what was place before you click the button
        // then you clear the screen so that you can write another number
        if(result == 0) {
            logic = (String) display.getText()+ "";
            logical.setText(logic);
            result = Double.parseDouble((String) display.getText());
            display.setText("");
        }
    }




}

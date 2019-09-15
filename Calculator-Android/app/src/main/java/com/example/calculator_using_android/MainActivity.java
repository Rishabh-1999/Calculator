package com.example.calculator_using_android;

import android.content.DialogInterface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText inputtext;
    private TextView resulttext;
    private Button but0;
    private Button but1;
    private Button but2;
    private Button but3;
    private Button but4;
    private Button but5;
    private Button but6;
    private Button but7;
    private Button but8;
    private Button but9;
    private ImageButton butadd;
    private ImageButton butmin;
    private ImageButton butmulti;
    private Button butdivi;
    private ImageButton butdelet;
    private Button butc;
    private Button butbra;
    private Button but100;
    private Button butequl;
    private Button butsing;
    private Button butvir;
    private boolean stateError;
    private boolean isNumber;
    private boolean lastDot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputtext = findViewById(R.id.input);
        resulttext = findViewById(R.id.result);
        but0 = findViewById(R.id.but0);
        but1 = findViewById(R.id.but1);
        but2 = findViewById(R.id.but2);
        but3 = findViewById(R.id.but3);
        but4 = findViewById(R.id.but4);
        but5 = findViewById(R.id.but5);
        but6 = findViewById(R.id.but6);
        but7 = findViewById(R.id.but7);
        but8 = findViewById(R.id.but8);
        but9 = findViewById(R.id.but9);
        but100 = findViewById(R.id.but100);
        butadd = findViewById(R.id.butplus);
        butmin = findViewById(R.id.butmin);
        butmulti = findViewById(R.id.butmult);
        butdivi = findViewById(R.id.butdivi);
        butdelet = findViewById(R.id.butdelet);
        butbra = findViewById(R.id.butbra);
        butsing = findViewById(R.id.butsin);
        butc = findViewById(R.id.butc);
        butequl = findViewById(R.id.butequl);
        butvir = findViewById(R.id.butv);

        but0.setOnClickListener(this);
        but1.setOnClickListener(this);
        but2.setOnClickListener(this);
        but3.setOnClickListener(this);
        but4.setOnClickListener(this);
        but5.setOnClickListener(this);
        but6.setOnClickListener(this);
        but7.setOnClickListener(this);
        but8.setOnClickListener(this);
        but9.setOnClickListener(this);
        but100.setOnClickListener(this);
        butadd.setOnClickListener(this);
        butmulti.setOnClickListener(this);
        butmin.setOnClickListener(this);
        butdelet.setOnClickListener(this);
        butdivi.setOnClickListener(this);
        butvir.setOnClickListener(this);
        butequl.setOnClickListener(this);
        butc.setOnClickListener(this);
        butdelet.setOnClickListener(this);
        butsing.setOnClickListener(this);
        butbra.setOnClickListener(this);

        inputtext.setRawInputType(InputType.TYPE_NULL);
        inputtext.addTextChangedListener(textWatcher);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setIcon(R.mipmap.ic_launcher_round);
        actionBar.setTitle("Calculator");
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        butdelet.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                inputtext.setText("");
                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        int Id = v.getId();
        switch (Id) {
            case R.id.but0:
                appendToLast("0");
                isNumber = true;
                break;
            case R.id.but1:
                appendToLast("1");
                isNumber = true;
                break;
            case R.id.but2:
                appendToLast("2");
                isNumber = true;
                break;
            case R.id.but3:
                appendToLast("3");
                isNumber = true;
                break;
            case R.id.but4:
                appendToLast("4");
                isNumber = true;
                break;
            case R.id.but5:
                appendToLast("5");
                isNumber = true;
                break;
            case R.id.but6:
                appendToLast("6");
                isNumber = true;
                break;
            case R.id.but7:
                appendToLast("7");
                isNumber = true;
                break;
            case R.id.but8:
                appendToLast("8");
                isNumber = true;
                break;
            case R.id.but9:
                appendToLast("9");
                isNumber = true;
                break;
            case R.id.but100:
                if (!isEmpty() && isNumber)
                    appendToLast("%");
                break;
            case R.id.butplus:
                if (!isEmpty())
                    if (endsWithOperatore())
                        replace("+");
                    else
                        appendToLast("+");
                isNumber = false;
                lastDot = false;
                break;
            case R.id.butmin:
                if (endsWithOperatore())
                    replace("-");
                else
                    appendToLast("-");
                isNumber = false;
                lastDot = false;
                break;
            case R.id.butmult:
                if (!isEmpty())
                    if (endsWithOperatore())
                        replace("x");
                    else
                        appendToLast("x");
                isNumber = false;
                lastDot = false;
                break;
            case R.id.butdivi:
                if (!isEmpty())
                    if (endsWithOperatore())
                        replace("\u00F7");
                    else
                        appendToLast("\u00F7");
                isNumber = false;
                lastDot = false;
                break;
            case R.id.butv:
                if (isNumber && !stateError && !lastDot) {
                    appendToLast(".");
                    isNumber = false;
                    lastDot = true;
                } else if (isEmpty()) {
                    appendToLast("0.");
                    isNumber = false;
                    lastDot = true;
                }
                break;
            case R.id.butdelet:
                delete();
                break;
            case R.id.butc:
                clearEverything();
                break;
            case R.id.butbra:
                bracket();
                break;
            case R.id.butequl:
                calculateData(true);
                break;
            case R.id.butsin:
                setSing();
                break;
            default:
                break;
        }
    }

    private void setSing() {
        if (isEmpty()){
            appendToLast("(-");
        }else if (isNumber && !endsWithOperatore()){
            int index1;
            int index2;
            int index3;
            int index4;
            int lastone = 0;
            index1 = getinput().lastIndexOf("x") + 1;
            index2 = getinput().lastIndexOf("+") + 1;
            index3 = getinput().lastIndexOf("-") + 1;
            index4 = getinput().lastIndexOf("/") + 1;
            if (index1 > index2 && index1 > index3 && index1 > index4)
                lastone = index1;
            else if (index2 > index1 && index2 > index3 && index2 > index4)
                lastone = index2;
            else if (index3 > index2 && index3 > index1 && index3 > index4)
                lastone = index1;
            else if (index4 > index1 && index4 > index3 && index4 > index2)
                lastone = index1;
            char ch=getinput().charAt(lastone);
            appendsing("(-" + String.valueOf(ch), lastone);
        }
    }

    private void appendsing(String str,int index) {
        inputtext.getText().replace(index,index+1,str);
    }

    private void bracket() {
        if ((!stateError && !isEmpty() && !endsWithbra() && isNumber) || isclosed()) {
            appendToLast("x(");
        } else if (isEmpty() || endsWithOperatore() || endsWithbra()) {
            appendToLast("(");
        } else if (!isEmpty() && !endsWithbra()) {
            appendToLast(")");
        }
    }

    private boolean endsWithbra() {
        return getinput().endsWith("(");
    }

    private boolean isclosed() {
        return getinput().endsWith(")");
    }

    private boolean endsWithOperatore() {
        return getinput().endsWith("+") || getinput().endsWith("-") || getinput().endsWith("/") || getinput().endsWith("x");
    }

    private void replace(String str) {
        inputtext.getText().replace(getinput().length() - 1, getinput().length(), str);
    }

    //Function to clear everything
    private void clearEverything() {
        lastDot = false;
        isNumber = false;
        stateError = false;
        inputtext.getText().clear();
    }

    // Function to add char to string
    private void appendToLast(String str) {
        this.inputtext.getText().append(str);
    }

    private void delete() {
        if (!isEmpty()) {
            this.inputtext.getText().delete(getinput().length() - 1, getinput().length());

        } else clearEverything();
    }

    private String getinput() {
        return this.inputtext.getText().toString();
    }

    private boolean isEmpty() {
        return getinput().isEmpty();
    }

    private void calculateData(boolean isequlclick) {
        String input = getinput();
        try {
            if (!isEmpty() && !endsWithOperatore()) {
                if (input.contains("x")) {
                    input = input.replaceAll("x", "*");
                }

                if(input.contains("\u00F7")){
                    input=input.replaceAll("\u00F7","/");
                }
                Expression expression = new ExpressionBuilder(input).build();
                double result = expression.evaluate();
                if (isequlclick) {
                    inputtext.setText(String.valueOf(result));
                    resulttext.setText("");
                } else
                    resulttext.setText(String.valueOf(result));
            } else resulttext.setText("");
        } catch (Exception e) {
            stateError = true;
            isNumber = false;
        }
    }

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            calculateData(false);
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    public void onBackPressed()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Exit");
        builder.setMessage("Are You Sure?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                finish();
                System.exit(0);
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}

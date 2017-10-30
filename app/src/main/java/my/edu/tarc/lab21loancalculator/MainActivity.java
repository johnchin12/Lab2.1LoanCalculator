package my.edu.tarc.lab21loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.R.id.message;

public class MainActivity extends AppCompatActivity {
    public static final String DOWNPAYMENT = "downpayment";
    public static final String LOANPERIOD = "loanperiod";
    public static final String MONTHREPAYMENT = "monthrepayment";
    public static final String INTERESTRATE = "interestrate";
    private EditText editTextPrice;
    private EditText editTextPayment;
    private EditText editTextLoan;
    private EditText editTextInterest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextPrice = (EditText)findViewById(R.id.editTextPrice);
        editTextPayment = (EditText)findViewById(R.id.editTextPayment);
        editTextLoan = (EditText)findViewById(R.id.editText3);
        editTextInterest = (EditText)findViewById(R.id.editText4);
    }

    public void calculateLoan(View view){
        Intent intent = new Intent(this, ResultActivity2.class);

        double price = Double.parseDouble(editTextPrice.getText().toString());
        double payment = Double.parseDouble(editTextPayment.getText().toString());
        int loan = Integer.parseInt(editTextLoan.getText().toString());
        double interestrate = Double.parseDouble(editTextInterest.getText().toString());

        double carloan = price - payment;
        double interest = interestrate*carloan*loan;
        double monthly = (carloan + interest)/loan/12;

        intent.putExtra(INTERESTRATE, interestrate);
        intent.putExtra(DOWNPAYMENT, payment);
        intent.putExtra(LOANPERIOD, loan);
        intent.putExtra(MONTHREPAYMENT, monthly);

        startActivity(intent);
    }
}

package my.edu.tarc.lab21loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity2 extends AppCompatActivity {
    TextView textViewPayment;
    TextView textViewLoan;
    TextView textViewInterest;
    TextView textViewMonthly;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result3);

        textViewPayment = (TextView)findViewById(R.id.textViewPayment);
        textViewLoan = (TextView)findViewById(R.id.textViewLoan);
        textViewInterest = (TextView)findViewById(R.id.textViewInterest);
        textViewMonthly = (TextView)findViewById(R.id.textViewMonth);

        Intent intent = getIntent();
        double downpayment = intent.getDoubleExtra(MainActivity.DOWNPAYMENT,0.00);
        int loanperiod = intent.getIntExtra(MainActivity.LOANPERIOD, 0);
        double interestrate = intent.getDoubleExtra(MainActivity.INTERESTRATE, 0.00);
        double monthrepay = intent.getDoubleExtra(MainActivity.MONTHREPAYMENT, 0.00);

        textViewPayment.setText(getString(R.string.EditPayment) + " " + downpayment);
        textViewLoan.setText(getString(R.string.EditLoan) + " " + loanperiod);
        textViewInterest.setText(getString(R.string.EditInterest) + " " + interestrate);
        textViewMonthly.setText(getString(R.string.ViewMonth) + " " + monthrepay);
    }

    public void closeActivity(View view){
        finish();
    }
}

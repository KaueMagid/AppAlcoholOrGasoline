package com.kauemagid.alcoholorgasoline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private EditText gasoinePrice;
    private EditText alcoholPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result =        findViewById(R.id.txt_response);
        gasoinePrice =  findViewById(R.id.txtBox_gasoline_price);
        alcoholPrice =  findViewById(R.id.txtBox_alcohol_price);
    }

    public void calculatePrice(View view){

        String sAlcoholPrice = alcoholPrice.getText().toString();
        String sGasolinePrice = gasoinePrice.getText().toString();
        if(validationPrices(sAlcoholPrice, sGasolinePrice)){
            double valueAlcohol = Double.parseDouble(sAlcoholPrice);
            double valueGasoline= Double.parseDouble(sGasolinePrice);
            if (valueAlcohol/valueGasoline > 0.7){
                result.setText(R.string.txt_response_gasoline);
            }else if(valueAlcohol/valueGasoline == 0.7){
                result.setText(R.string.txt_response_anyway);
            }else {
                result.setText(R.string.txt_response_alcohol);
            }
        }
    }

    private boolean validationPrices(String sAcoholPrice, String sGasolinePrice){
        if (sAcoholPrice == null || sAcoholPrice.equals("")||
                sGasolinePrice == null || sGasolinePrice.equals("")){
            result.setText(R.string.txt_invalid_data);
            return false;
        }
        return true;
    }
}

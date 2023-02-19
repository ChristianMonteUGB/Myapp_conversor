package com.ugb.myapp_conversor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TabHost tbh;

    TextView temp;

    Spinner spn;

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tbh = findViewById(R.id.tbhConversores);
        tbh.setup();

        tbh.addTab(tbh.newTabSpec("longitud").setContent(R.id.Longitud).setIndicator("", getDrawable(R.drawable.longitud)));
        tbh.addTab(tbh.newTabSpec("monedas").setContent(R.id.Monedas).setIndicator("", getDrawable(R.drawable.dinero)));
        tbh.addTab(tbh.newTabSpec("peso").setContent(R.id.Peso).setIndicator("", getDrawable(R.drawable.masa)));
        tbh.addTab(tbh.newTabSpec("opciones_aritmeticas").setContent(R.id.opciones_aritmeticas).setIndicator("", getDrawable(R.drawable.aritmetica)));

        btn = (Button) findViewById(R.id.btnCalcular);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp = findViewById(R.id.txtNum1);
                double num1 = Double.parseDouble(temp.getText().toString());
                double num2 = 0;
                temp = (TextView) findViewById(R.id.txtNum2);
                try {
                    num2 = Double.parseDouble(temp.getText().toString());
                }catch (Exception e){
                    //manejador de error
                }
                double resp = 0;
                String msg = "Operacion invalida";
                /*rgp = (RadioGroup)findViewById(R.id.rgpOpciones);
                switch (rgp.getCheckedRadioButtonId()){
                    case R.id.optSuma:
                        resp = num1 + num2;
                        msg = "La suma es: "+ resp;
                        break;
                    case R.id.optResta:
                        resp = num1 - num2;
                        msg = "La resta es: "+ resp;
                        break;
                    case R.id.optMultiplicacion:
                        resp = num1 * num2;
                        msg = "La multiplicacion es: "+ resp;
                        break;
                    case R.id.optDivision:
                        resp = num1 / num2;
                        msg = "La division es: "+ resp;
                        break;
                    case R.id.optExponente:
                        resp = Math.pow(num1, num2);
                        msg = "Exponente: "+ resp;
                        break;
                }*/
                spn = (Spinner)findViewById(R.id.spnOpciones);
                switch (spn.getSelectedItemPosition()){
                    case 0: //Suma
                        resp = num1 + num2;
                        msg = "La suma es: "+ resp;
                        break;
                    case 1://Resta
                        resp = num1 - num2;
                        msg = "La resta es: "+ resp;
                        break;
                    case 2://Multiplicacion
                        resp = num1 * num2;
                        msg = "La multiplicacion es: "+ resp;
                        break;
                    case 3://division
                        resp = num1 / num2;
                        msg = "La division es: "+ resp;
                        break;
                    case 4://exponente
                        resp = Math.pow(num1,num2);
                        msg = "La exponenciacion es: "+ resp;
                        break;
                    case 5://factorial
                        resp = 1;
                        for(int i=2; i<=num1; i++){
                            resp *= i;//resp = resp * i;
                        }
                        msg = "Factorial!: "+ resp;
                        break;
                }
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
            }
        });
    }
}











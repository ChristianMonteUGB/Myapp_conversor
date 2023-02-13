package com.ugb.myapp_conversor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView temp;

    Spinner spn;

    Button btn;

    conversores miConversor=new conversores();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.btnconvertir);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spn = findViewById(R.id.spnDo);
                int de = spn.getSelectedItemPosition();

                spn = findViewById(R.id.spnDe);
                int a = spn.getSelectedItemPosition();

                temp =(TextView) findViewById(R.id.cantidad);
                double cantidad = Double.parseDouble(temp.getText().toString());

                double respuesta = miConversor.convertir(0, de, a, cantidad);
                temp = findViewById(R.id.lblrespuesta);
                temp.setText("Respuesta: "+ respuesta);
            }
        });
    }
}


class conversores{
    double[][] valores ={
            {1, 7.84, 24.66, 36.56, 580.23, 8.75, 0.94, 131.33, 82.54},//monedas


    };
    public double convertir(int opcion, int de , int a, double cantidad){
        return valores[opcion][a]/ valores[opcion][de] * cantidad;
    }
}

class conversores2{

    double[][] valores2 ={
            {1, 10, 100, 1000, 10000, 100000},//longitudes
    };

    public double convertir(int opcion, int de , int a, double cantidad) {
        return valores2[opcion][a] / valores2[opcion][de] * cantidad;
    }

}

class conversores3{

    double[][] valores3 ={
            {1, 16, 0.453592, 0.000453592},//Peso
    };

    public double convertir(int opcion, int de , int a, double cantidad) {
        return valores3[opcion][a] / valores3[opcion][de] * cantidad;
    }

}

class conversores4{
    double[][] valores4 ={
            {1, 1024, 1048579, 1073741824},//almacenamiento
    };
    public double convertir(int opcion, int de , int a, double cantidad) {
        return valores4[opcion][a] / valores4[opcion][de] * cantidad;
    }

}

class conversores5{
    double[][] valores5 ={
            {1, 1024},//transferencia de datos (internet)
    };
    public double convertir(int opcion, int de , int a, double cantidad) {
        return valores5[opcion][a] / valores5[opcion][de] * cantidad;
    }
}




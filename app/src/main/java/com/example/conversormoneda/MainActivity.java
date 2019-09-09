package com.example.conversormoneda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText cantidad;
    TextView respuesta;
    TextView wii;
    RadioButton r1,r2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cantidad=findViewById(R.id.cantidad);
        respuesta=findViewById(R.id.respuesta);
        wii=findViewById(R.id.whatIsIt);
        r1=findViewById(R.id.rbDolar);
        r2=findViewById(R.id.rbEuro);
    }

    public void aDolar(View v) {
        if(r1.isChecked()){
            r2.setChecked(false);
            wii.setText("Monto en Euros:");
        }
    }
    public void aEuro(View v){
        if(r2.isChecked()){
            r1.setChecked(false);
            wii.setText("Monto en Dolares:");
        }
    }

    public void convertir(View v){
        double monto=Double.parseDouble(cantidad.getText().toString());
        if(r1.isChecked()){
            if(cantidad!=null&&monto>0){
                respuesta.setText("$"+monto*1.10);
            } else {
                Toast.makeText(this, "Ingrese un monto", Toast.LENGTH_SHORT).show();
            }
        } else if(r2.isChecked()){
            if(cantidad!=null&&monto>0){
                respuesta.setText("$"+monto*0.91);
            } else {
                Toast.makeText(this, "Ingrese un monto", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void limpiar(View v){
        respuesta.setText("$0");
        cantidad.setText("");
    }
}

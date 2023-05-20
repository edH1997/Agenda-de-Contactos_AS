package com.example.agenda_contactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {
    Contactos contactos;
    EditText txtNombre, txtTelefono, txtDireccion, txtEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

       // contactos = new Contactos(this, "empresa.db", 1);
        txtNombre = findViewById(R.id.txtNombreadd);
        txtTelefono = findViewById(R.id.txtTelefonoadd);
        txtDireccion = findViewById(R.id.txtDireccionadd);
        txtEmail = findViewById(R.id.txtEmailadd);
    }
    public void cmdCreate_onClick(View v)
    {
        Contacto p = contactos.Create(
                txtNombre.getText().toString(),
                txtTelefono.getText().toString(),
                txtDireccion.getText().toString(),
                txtEmail.getText().toString()
        );
        if (p != null)
            Toast.makeText(this, "El comntacto ha sido insertado", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "ERROR !! CONTACTO NO INSERTADO", Toast.LENGTH_SHORT).show();
    }
    public void addActivityMain_oneClick(View v){
        Intent i = new Intent( this, MainActivity.class);

        startActivity(i);
    }
}
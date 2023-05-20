package com.example.agenda_contactos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class ActivityI extends AppCompatActivity {

    EditText txtNombre, txtTelefono, txtDireccion, txtEmail;
    Button btnGuarda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_contacto);

        txtNombre = findViewById(R.id.txtNombre);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtDireccion= findViewById(R.id.txtDirecc);
        txtEmail = findViewById(R.id.txtCorreoElectronico);
        btnGuarda = findViewById(R.id.btnGuard);

        btnGuarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!txtNombre.getText().toString().equals("") && !txtTelefono.getText().toString().equals("")) {

                    Contactos Contactos1 = new Contactos(ActivityI.this);
                    long id = Contactos1.Create(txtNombre.getText().toString(), txtTelefono.getText().toString(), txtEamail.getText().toString(), txtDireccion.getText().toString());

                    if (id > 0) {
                        Toast.makeText(ActivityI.this, "Contacto registrado correctamente", Toast.LENGTH_LONG).show();
                        limpiar();
                    } else {
                        Toast.makeText(ActivityI.this, "No se pudo guardar", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    private void limpiar() {
        txtNombre.setText("");
        txtTelefono.setText("");
        txtEmail.setText("");
        txtDireccion.setText("");
    }
}
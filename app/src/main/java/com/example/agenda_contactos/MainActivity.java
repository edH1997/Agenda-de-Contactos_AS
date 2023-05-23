package com.example.agenda_contactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    RecyclerView listaContactos;
    ArrayList<Contactos> listaArrayContactos;
    FloatingActionButton fabNuevo;
    ListaContactosAdapter adapter;
   Contactos contactos;
    EditText txtNombre, txtTelefono, txtDireccion, txtEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void addActivity2_oneClick(View v){
        Intent i = new Intent( this, Activity2.class);

        startActivity(i);
    }
    public void cmdReadOne_onClick(View v)
    {
        Contacto p = contactos.Read_One( txtNombre.getText().toString());
        if (p != null)
        {
            txtNombre.setText( p.Nombre);
            txtTelefono.setText( p.Telefono);
            txtDireccion.setText( p.Direccion);
            txtEmail.setText( p.Email);
        }
        else
        {
            Toast.makeText(this, "CONTACTO NO ENCONTRADO !!!", Toast.LENGTH_SHORT).show();
        }
    }

    public void cmdUpdate_onClick(View v)
    {
        boolean resultado = contactos.Update(
                txtNombre.getText().toString(),
                txtTelefono.getText().toString(),
                txtNombre.getText().toString(),
                txtTelefono.getText().toString()
        );
        if (resultado == true)
            Toast.makeText(this, "CONTACTO ACTUALZIADO ", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "ERROR!! CONTACTO NO ACTUALIZADO", Toast.LENGTH_SHORT).show();
    }

    public void cmdDelete_onClick(View v)
    {
        boolean resultado = contactos.Delete( txtNombre.getText().toString());
        if (resultado == true)
        {
            Toast.makeText(this, "REGISTRO BORRADO OK ", Toast.LENGTH_SHORT).show();
            txtNombre.setText( "");
            txtTelefono.setText( "");
            txtDireccion.setText( "" );
            txtEmail.setText( "" );
        }
        else
            Toast.makeText(this, "ERROR: CONTACTO NO ENCONTRADO !!!", Toast.LENGTH_SHORT).show();
    }

}
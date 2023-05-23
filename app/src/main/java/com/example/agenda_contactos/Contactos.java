package com.example.agenda_contactos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Contactos  {

    private DBHellper dbHelper;
    private SQLiteDatabase db;

    Context context;


   // public Contactos(Context contexto, String dbName, int version) {
     //  dbHelper = new DBHellper(contexto, dbName, null, version);
    //}

    public Contacto Create( String nombre, String telefono,  String direccion,String email)
    {
        db = dbHelper.getWritableDatabase();

        ContentValues row = new ContentValues();
        row.put("nombre", nombre);
        row.put("telefono", telefono);
        row.put("direccion", direccion);
        row.put("email", email);

        long qty = db.insert("contactos", null, row);
        if (qty > 0)
        {
            Contacto data = new Contacto();
            data.setNombre(nombre);
            data.setTelefono(telefono);
            data.setDireccion(direccion);
            data.setEmail(email);
            return data;
        }
        else
        {
            return  null;
        }
    }
    public  Contacto Read_One( String nombre)
    {
        db = dbHelper.getReadableDatabase();
        Cursor cr = db.rawQuery("SELECT nombre, telefono, direccion, email FROM contactos WHERE nombre = '" + nombre + "' ", null);
        if (cr.getCount()>0)
        {
            Contacto prod = new Contacto();
            cr.moveToNext();
            prod.setNombre(cr.getString(0));
            prod.setTelefono(cr.getString(1));
            prod.setDireccion(cr.getString(2));
            prod.setEmail(cr.getString(3));
            return prod;
        }
        else {
            return  null;
        }
    }
    public  Contacto[] Read_All()
    {
        db = dbHelper.getReadableDatabase();
        Cursor cr = db.rawQuery("SELECT nombre, telefono, direccion, email FROM contactos ORDER BY nombre", null);
        if (cr.getCount()>0)
        {
            Contacto[] datos = new Contacto[cr.getCount()];
            Contacto prod;
            int i = 0;

            while (cr.moveToNext())
            {
                prod = new Contacto();
                prod.setNombre(cr.getString(0));
                prod.setTelefono(cr.getString(1));
                prod.setDireccion(cr.getString(2));
                prod.setEmail(cr.getString(3));
                datos[i++]= prod;
            }
            return  datos;
        }
        else {
            return  null;
        }
    }
    public  Contacto[] Read_ByNombre(String find)
    {
        db = dbHelper.getReadableDatabase();
        Cursor cr = db.rawQuery("SELECT nombre, telefono, direccion, email FROM contactos WHERE nombre LIKE '%" + find + "%' ORDER BY nombre", null);
        if (cr.getCount()>0)
        {
            Contacto[] datos = new Contacto[cr.getCount()];
            Contacto prod;
            int i = 0;

            while (cr.moveToNext())
            {
                prod = new Contacto();
                prod.setNombre(cr.getString(0));
                prod.setTelefono(cr.getString(1));
                prod.setDireccion(cr.getString(2));
                prod.setEmail(cr.getString(3));
                datos[i++]= prod;
            }
            return  datos;
        }
        else {
            return  null;
        }
    }

    public boolean Update( String nombre, String telefono, String direccion, String email)
    {
        db = dbHelper.getWritableDatabase();

        ContentValues row = new ContentValues();
        row.put("nombre", nombre);
        row.put("telefono", telefono);
        row.put("direccion", direccion);
        row.put("email", email);

        int qty = db.update("contactos", row,"nombre='"+nombre+"'", null);
        return qty>0;
    }
    public boolean Delete( String nombre)
    {
        db = dbHelper.getWritableDatabase();
        int qty = db.delete("contactos", "nombre='"+nombre+"'", null);
        return qty>0;
    }
    public ArrayList<Contacto> Listadesplegable() {

        DBHellper dbHelper = new DBHellper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Contacto> listaContactos = new ArrayList<>();
        Contacto contacto;
        Cursor cr;

        cr = db.rawQuery("SELECT nombre, telefono, direccion, email FROM contactos ORDER BY nombre", null);

        if (cr.moveToFirst()) {
            do {
                contacto = new Contacto();
                contacto.setNombre(cr.getString(0));
                contacto.setTelefono(cr.getString(1));
                contacto.setDireccion(cr.getString(2));
                contacto.setEmail(cr.getString(3));
                listaContactos.add(contacto);
            } while (cr.moveToNext());
        }

        cr.close();

        return listaContactos;
    }





}


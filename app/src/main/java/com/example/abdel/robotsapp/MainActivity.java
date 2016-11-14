package com.example.abdel.robotsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //// Constants

    public final static String ROBOTS_APP_TAG="robots_app";
    public final static String EXTRA_ROBOTS_LIST="com.example.abdel.robotsapp.ROBOTS_LIST";

    /**
     * Lista de robots.
     */
    protected List<String> robotList;
    /**
     * Caja de texto para mostrar la lista en la Activity principal
     */
    protected TextView textView_visor;
    /**
     * Cuadro de texto para insertar el nombre del robot nuevo
     */
    protected EditText editText_robotName;
    /**
     * Etiqueta para los mensajes de debug.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(ROBOTS_APP_TAG,"oncreate()");
        textView_visor= (TextView) findViewById(R.id.textView_visor);
        editText_robotName= (EditText) findViewById(R.id.editText_robotName);

        if(savedInstanceState==null)
        {
            // es la ptimera vez que se crea la activity
            // creamos la lista de robots, para ello usamos la clase ArrayList que implementa la interfaz
            // List a traves de un Array.
            robotList=new ArrayList<String>();
            // Añadimos 3 robots para probar que va bien
            robotList.add("Robot 1");
            robotList.add("Robot 2");
            robotList.add("Robot 3");
        }else{
            // la activity existía se quitó de primer plano y se ha vuelto a abrir
            //existe un estado anterior-> lo recuperamos
            Log.d(ROBOTS_APP_TAG,"Recuperando estado anterior");
            robotList=(ArrayList<String>)savedInstanceState.getSerializable(EXTRA_ROBOTS_LIST);
        }

        // Actualizamos el texto de la MainActivity
        textView_visor.setText(""+robotList.size());
    }

    /**
     *
     */
    public  void addRobot(View view)
    {
        // leemos el texto de la caja de texto y lo convertimos a string
        String robotName=editText_robotName.getText().toString();

        // añadimos el nuevo robot a la lista
        robotList.add(robotName);
        Log.d( ROBOTS_APP_TAG,"Añadiendo nuevo elemento:"+robotName+"...\n"+Arrays.toString(robotList.toArray()));
        // Actualizamos el texto de la MainActivity
        textView_visor.setText(""+robotList.size());

        Toast.makeText(this,R.string.robot_added_succesfully,Toast.LENGTH_SHORT).show();
    }

    /**
     * Callback del botón de borrado. Borra elk ultimo robot de la lista.
     * @param view
     */
    public void removeRobot(View view)
    {

        if(robotList.size()>0) {
            robotList.remove(robotList.size()-1);
            Log.d( ROBOTS_APP_TAG,"Borrado un elemento");
        }else{
            Log.d( ROBOTS_APP_TAG,"La lista está vacia");
            // Creamos un toast y lo mostramos
            Toast.makeText(this,R.string.list_is_empty,Toast.LENGTH_SHORT).show();
        }


        // Actualizamos el texto de la MainActivity
        textView_visor.setText(""+robotList.size());

    }

    /**
     *
     * Muestra Los Robots Contenidos en la lista en otra activity.
     */
    public  void showRobots(View view)
    {
        Log.d( ROBOTS_APP_TAG,"Mostrando lista de bots...\n"+Arrays.toString(robotList.toArray()));

        //lanzamos RobotsShowActivity

        Intent intent = new Intent(this, RobotsShowActivity.class);
        intent.putExtra(EXTRA_ROBOTS_LIST, (Serializable) robotList);
        startActivity(intent);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(EXTRA_ROBOTS_LIST,(Serializable)robotList);
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();

    }
}

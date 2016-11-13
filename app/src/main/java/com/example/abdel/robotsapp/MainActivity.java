package com.example.abdel.robotsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
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
    protected static String ROBOTS_APP_TAG="robots_app";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView_visor= (TextView) findViewById(R.id.textView_visor);
        editText_robotName= (EditText) findViewById(R.id.editText_robotName);

        // initialize robots ArrayList with some sample names
        robotList=new ArrayList<String>();
        robotList.add("Robot 1");
        robotList.add("Robot 2");
        robotList.add("Robot 3");
        // refresh the view with the names
        textView_visor.setText(Arrays.toString(robotList.toArray()));
    }

    /**
     *
     */
    public  void addRobot(View view)
    {
        robotList.add(editText_robotName.getText().toString());
        textView_visor.setText(Arrays.toString(robotList.toArray()));
    }

    /**
     * Callback del botón de borrado. Borra elk último robot de la lista.
     * @param view
     */
    public void removeRobot(View view)
    {

        if(robotList.size()>0) {
            robotList.remove(robotList.size()-1);
        }else{
            Log.d( ROBOTS_APP_TAG,"List is empty");
            // Creamos un toas y lo mostramos
            Toast.makeText(this,R.string.list_is_empty,Toast.LENGTH_SHORT).show();
        }


        textView_visor.setText(Arrays.toString(robotList.toArray()));

    }

    /**
     * TODO
     * Muestra Los Robots Contenidos en la lista en otra activity.
     */
    public  void showRobots(View view)
    {

    }

}

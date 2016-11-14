package com.example.abdel.robotsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

/**
 * Activity que muestra una lista de los robots que se le pasen a traves del parámetro extra :
 */
public class RobotsShowActivity extends AppCompatActivity {
    /**
     * Lista de robots.
     */
    protected List<String> robotList;

    ListView robotsListView;
    ArrayAdapter<String> robotsListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_robots_show);
        //obtenemos el Intent
        Intent intent = getIntent();

        //obtenemos la lista de robots

        robotList=(List<String>) intent.getSerializableExtra(MainActivity.EXTRA_ROBOTS_LIST);

        Log.d( MainActivity.ROBOTS_APP_TAG,"Lista Recibida:\n"+ Arrays.toString(robotList.toArray()));

        robotsListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,robotList);
        ListView listView = (ListView) findViewById(R.id.robots_list_view);
        listView.setAdapter(robotsListAdapter);
    }
}

package com.example.gridviewbuttonadd;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the widgets reference from XML layout
        GridView gv = (GridView) findViewById(R.id.gv);
        Button btn = (Button) findViewById(R.id.btn);
        final EditText editText=(EditText) findViewById(R.id.EditTextInput) ;

        // Initializing a new String Array
        String[] plants = new String[]{
                "Mr.HEAN"
        };

        // Populate a List from Array elements
        final List<String> plantsList = new ArrayList<String>(Arrays.asList(plants));

        // Create a new ArrayAdapter
        final ArrayAdapter<String> gridViewArrayAdapter = new ArrayAdapter<String>
                (this,android.R.layout.simple_list_item_1, plantsList);

        // Data bind GridView with ArrayAdapter (String Array elements)
        gv.setAdapter(gridViewArrayAdapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add/insert item to ArrayAdapter
                // Insert at the end of ArrayAdapter
                // ArrayAdapter is zero based index
                plantsList.add(plantsList.size(),editText.getText().toString());

                // Update the GridView
                gridViewArrayAdapter.notifyDataSetChanged();

                // Get the newly added item from ArrayAdapter
                String addedItemText = plantsList.get(plantsList.size()-1);

                // Confirm the addition
                Toast.makeText(getApplicationContext(),
                        "Item added : " + addedItemText, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

package com.example.applicationandroide5;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;



public class MainActivity2 extends AppCompatActivity {
    JSONArray jArray;
    JSONObject json_data;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        jArray=null;
        EditText rech = (findViewById(R.id.rech));
        findViewById(R.id.button).setOnClickListener(view -> {
            try {
                String adresse = "http://10.0.2.2/test.php?rech="+rech.getText().toString();
                String wololo;
                wololo = new HTTPRequest.HTTPSELECTRequest().execute(adresse).get();
                jArray = new JSONArray(wololo);
                i=0;
                json_data = jArray.getJSONObject(i);
                ((TextView) findViewById(R.id.name)).setText(json_data.getString("name"));
                ((TextView) findViewById(R.id.street)).setText(json_data.getString("street"));
                ((TextView) findViewById(R.id.mail)).setText(json_data.getString("email"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        findViewById(R.id.button2).setOnClickListener(view -> {
            try {
                if(i>0) {
                    i--;
                    json_data = jArray.getJSONObject(i);
                    ((TextView) findViewById(R.id.name)).setText(json_data.getString("name"));
                    ((TextView) findViewById(R.id.street)).setText(json_data.getString("street"));
                    ((TextView) findViewById(R.id.mail)).setText(json_data.getString("email"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        findViewById(R.id.button3).setOnClickListener(view -> {
            try {
                if(i<jArray.length()-1) {
                    i++;
                    json_data = jArray.getJSONObject(i);
                    ((TextView) findViewById(R.id.name)).setText(json_data.getString("name"));
                    ((TextView) findViewById(R.id.street)).setText(json_data.getString("street"));
                    ((TextView) findViewById(R.id.mail)).setText(json_data.getString("email"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
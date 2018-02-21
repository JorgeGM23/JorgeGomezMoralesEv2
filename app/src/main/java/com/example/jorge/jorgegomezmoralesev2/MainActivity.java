package com.example.jorge.jorgegomezmoralesev2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //private static final String URL = "https://restcountries.eu/rest/v2/all";
    private static final String URL = "http://192.168.31.44/Paises/paises.json";

    ArrayList<Pais> paises;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView);
        paises = new ArrayList<>();

        // cojo los datos del servidor...
        RequestQueue request = Volley.newRequestQueue(getApplicationContext());
        final JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0; i < response.length(); i++) {
                        Pais pais = new Pais();
                        JSONObject jsonObject = response.getJSONObject(i);
                        String nombreIngles = jsonObject.getString("name");
                        pais.setNombreIngles(nombreIngles);
                        //Toast.makeText(getApplicationContext(), "nombre " + nombreIngles, Toast.LENGTH_SHORT).show();
                        String cod2Letras = jsonObject.getString("alpha2Code");
                        pais.setCod2Letras(cod2Letras);
                        String cod3Letras = jsonObject.getString("alpha3Code");
                        pais.setCod3Letras(cod3Letras);
                        String capital = jsonObject.getString("capital");
                        pais.setCapital(capital);
                        String continente = jsonObject.getString("region");
                        pais.setContinente(continente);
                        String poblacion = jsonObject.getString("population");
                        //Toast.makeText(getApplicationContext(), "poblaacion " + poblacion, Toast.LENGTH_SHORT).show();
                        pais.setPoblacion(poblacion);
                        String latitud = "";
                        String longitud = "";
                        JSONArray latlng = jsonObject.getJSONArray("latlng");
                        if (latlng.length() != 0) {
                            latitud = latlng.getString(0);
                            longitud = latlng.getString(1);
                            //Toast.makeText(getApplicationContext(), "LAt " + latitud + " long: " + longitud, Toast.LENGTH_SHORT).show();
                        }
                        pais.setLatitud(latitud);
                        pais.setLongitud(longitud);
                        JSONArray jsonFronteras = jsonObject.getJSONArray("borders");
                        ArrayList<String> fronteras = new ArrayList<>();
                        for (int j = 0; j < jsonFronteras.length(); j++) {
                            //Toast.makeText(getApplicationContext(), "pais fronterizo: " + jsonFronteras.getString(j), Toast.LENGTH_SHORT).show();
                            fronteras.add(jsonFronteras.getString(j));
                        }
                        pais.setPaisesFronterizos(fronteras);
                        String nombreCastellano = jsonObject.getJSONObject("translations").getString("es");
                        pais.setNombreCastellano(nombreCastellano);
                        //Toast.makeText(getApplicationContext(), "nombre español: " + nombreCastellano, Toast.LENGTH_SHORT).show();
                        paises.add(pais);
                    }
                    Adaptador miAdaptador = new Adaptador(getApplicationContext(), paises);
                    listView.setAdapter(miAdaptador);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            Pais obj = (Pais) adapterView.getItemAtPosition(i);

                            Intent paso = new Intent(getApplicationContext(), MapsActivity.class);
                            paso.putExtra("pais", (Serializable)obj);
                            startActivity(paso);
                        }
                    });

                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        request.add(jsonArrayRequest);
    }
}

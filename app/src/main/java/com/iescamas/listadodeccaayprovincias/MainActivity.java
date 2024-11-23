package com.iescamas.listadodeccaayprovincias;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.net.URLEncoder;
import java.util.ArrayList;

import kotlin.text.Charsets;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter adapterCCAA;
    ArrayAdapter adapterProv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapterCCAA = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line,loadCCAA());
        ((ListView)findViewById(R.id.lvCCAA)).setAdapter(adapterCCAA);
        ((ListView)findViewById(R.id.lvCCAA)).setOnItemClickListener((adapterView, view, i, l) -> {
           adapterProv = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line,loadProv(i));
            ((ListView)findViewById(R.id.lv_Prov)).setAdapter(adapterProv);
        });

        ((ListView)findViewById(R.id.lv_Prov)).setOnItemClickListener((adapterView, view, i, l) -> {
            String prov =((TextView)view).getText().toString();
            searchWiki(prov);
        });

    }

    private ArrayList loadCCAA(){

        ArrayList<String> list = new ArrayList();

        list.add("Andalucía");
        list.add("Aragón");
        list.add("Asturias");
        list.add("Cantábria");
        list.add("Castilla y León");
        list.add("Castilla-La Mancha");
        list.add("Cataluña");
        list.add("Ceuta");
        list.add("Extremadura");
        list.add("Galicia");
        list.add("Islas Baleares");
        list.add("Islas Canarias");
        list.add("La Rioja");
        list.add("Madrid");
        list.add("Melilla");
        list.add("Murcia");
        list.add("Navarra");
        list.add("País Vasco");
        list.add("Valencia");

        return list;
    }

    private ArrayList<String> loadProv(int pos) {

        ArrayList<String> listProv = new ArrayList<>();

        switch (pos) {
            case 0:
                listProv.add("Almería");
                listProv.add("Cádiz");
                listProv.add("Córdoba");
                listProv.add("Granada");
                listProv.add("Huelva");
                listProv.add("Jaén");
                listProv.add("Málaga");
                listProv.add("Sevilla");
                ((TextView) findViewById(R.id.lyProvincias)).setText("Provincias de Andalucía:");
                break;
            case 1:
                listProv.add("Huesca");
                listProv.add("Teruel");
                listProv.add("Zaragoza");
                ((TextView) findViewById(R.id.lyProvincias)).setText("Provincias de Aragón:");
                break;
            case 2:
                listProv.add("Asturias");
                ((TextView) findViewById(R.id.lyProvincias)).setText("Provincias de Asturias:");
                break;
            case 3:
                listProv.add("Cantabria");
                ((TextView) findViewById(R.id.lyProvincias)).setText("Provincias de Cantabria:");
                break;
            case 4:
                listProv.add("Ávila");
                listProv.add("Burgos");
                listProv.add("León");
                listProv.add("Palencia");
                listProv.add("Salamanca");
                listProv.add("Segovia");
                listProv.add("Soria");
                listProv.add("Valladolid");
                listProv.add("Zamora");
                ((TextView) findViewById(R.id.lyProvincias)).setText("Provincias de Castilla y León:");
                break;
            case 5:
                listProv.add("Albacete");
                listProv.add("Ciudad Real");
                listProv.add("Cuenca");
                listProv.add("Guadalajara");
                listProv.add("Toledo");
                ((TextView) findViewById(R.id.lyProvincias)).setText("Provincias de Castilla-La Mancha:");
                break;
            case 6:
                listProv.add("Barcelona");
                listProv.add("Girona");
                listProv.add("Lleida");
                listProv.add("Tarragona");
                ((TextView) findViewById(R.id.lyProvincias)).setText("Provincias de Cataluña:");
                break;
            case 7:
                listProv.add("Ceuta");
                ((TextView) findViewById(R.id.lyProvincias)).setText("Provincias de Ceuta:");
                break;
            case 8:
                listProv.add("Badajoz");
                listProv.add("Cáceres");
                ((TextView) findViewById(R.id.lyProvincias)).setText("Provincias de Extremadura:");
                break;
            case 9:
                listProv.add("A Coruña");
                listProv.add("Lugo");
                listProv.add("Ourense");
                listProv.add("Pontevedra");
                ((TextView) findViewById(R.id.lyProvincias)).setText("Provincias de Galicia:");
                break;
            case 10:
                listProv.add("Islas Baleares");
                ((TextView) findViewById(R.id.lyProvincias)).setText("Provincias de Islas Baleares:");
                break;
            case 11:
                listProv.add("Las Palmas");
                listProv.add("Santa Cruz de Tenerife");
                ((TextView) findViewById(R.id.lyProvincias)).setText("Provincias de Islas Canarias:");
                break;
            case 12:
                listProv.add("La Rioja");
                ((TextView) findViewById(R.id.lyProvincias)).setText("Provincias de La Rioja:");
                break;
            case 13:
                listProv.add("Madrid");
                ((TextView) findViewById(R.id.lyProvincias)).setText("Provincias de Madrid:");
                break;
            case 14:
                listProv.add("Melilla");
                ((TextView) findViewById(R.id.lyProvincias)).setText("Provincias de Melilla:");
                break;
            case 15:
                listProv.add("Murcia");
                ((TextView) findViewById(R.id.lyProvincias)).setText("Provincias de Murcia:");
                break;
            case 16:
                listProv.add("Navarra");
                ((TextView) findViewById(R.id.lyProvincias)).setText("Provincias de Navarra:");
                break;
            case 17:
                listProv.add("Álava");
                listProv.add("Bizkaia");
                listProv.add("Gipuzkoa");
                ((TextView) findViewById(R.id.lyProvincias)).setText("Provincias de País Vasco:");
                break;
            case 18:
                listProv.add("Alicante");
                listProv.add("Castellón");
                listProv.add("Valencia");
                ((TextView) findViewById(R.id.lyProvincias)).setText("Provincias de Valencia:");
                break;
        }

        return listProv;
    }

    private void searchWiki(String Prov){
        try {
            String query = URLEncoder.encode(Prov, Charsets.UTF_8.name());
            String url = "https://es.wikipedia.org/wiki/" + query;

            Intent intent = new Intent(getApplicationContext(), WebActivity.class);
            intent.putExtra("web", url);
            startActivity(intent);
        } catch (Exception ignored) {

        }
    }



}
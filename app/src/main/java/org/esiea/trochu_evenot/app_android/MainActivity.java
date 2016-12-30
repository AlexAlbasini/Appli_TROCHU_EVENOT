package org.esiea.trochu_evenot.app_android;

import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;
import android.view.Menu;
import android.view.MenuItem;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText et;
    TextView bt;
    TextView bt2;
    LinearLayout main;
    RecyclerView recyclerView2;
    RecyclerSimpleViewAdapter adapter2;
    int compteur =0;
    String str;
    Toast mytoast2;
    Toast mytoast3;
    List<String> items2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = (TextView) findViewById(R.id.id_button);
        bt2=(TextView) findViewById(R.id.button2);
        main = (LinearLayout)findViewById(R.id.activity_main);
        et = (EditText) findViewById(R.id.editText3);
        recyclerView2 = (RecyclerView) findViewById(R.id.myListSimple2);

        bt2.setTextColor(Color.BLUE);
        bt2.setBackgroundColor(Color.YELLOW);


        items2 = new ArrayList<String>();
        items2.add("Nom Joueur");

        adapter2 = new RecyclerSimpleViewAdapter(items2, android.R.layout.simple_list_item_1);
        recyclerView2.setAdapter(adapter2);

        recyclerView2.setLayoutManager(new LinearLayoutManager(this));


    }

     // Action dans l'ActionBar
    @Override

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_test, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_biere:
                Intent myIntent2= new Intent(MainActivity.this,SimpleListItem1.class);
                startActivity(myIntent2);
                return true;
            case R.id.action_mail:
                Intent mail = new Intent(Intent.ACTION_SEND);
                mail.setType("message/rfc822");
                mail.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"alex.jeux.tel@gmail.com"});
                mail.putExtra(Intent.EXTRA_SUBJECT, "Requête aux développeurs");
                startActivity(Intent.createChooser(mail, ""));

                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Fin Action dans l'ActionBar


    public void Bouton_change(View v){
        if (compteur==0){
            mytoast3.makeText(this,"Il n'y a pas de Joueur enregistré", Toast.LENGTH_LONG).show();
        }
        else {
            Intent i = new Intent(MainActivity.this, Activity2.class);
            for(int z=1;z<=compteur;z++) {
                i.putExtra("stridx"+z, items2.get(z));
            }
            i.putExtra("taille",(items2.size()-1));
            startActivity(i);
        }
    }
    public void Bouton (View v) {
        str=  et.getText().toString();
        if (str.equalsIgnoreCase("")) {
            mytoast2.makeText(this,"Il n'y a pas de Nom", Toast.LENGTH_LONG).show();
        }
        else {
            compteur=compteur+1;
            items2.add(str);
            recyclerView2.setVisibility(RecyclerView.VISIBLE);
            adapter2 = new RecyclerSimpleViewAdapter(items2, android.R.layout.simple_list_item_1);
            recyclerView2.setAdapter(adapter2);
            et.setText(null);
        }

    }

}
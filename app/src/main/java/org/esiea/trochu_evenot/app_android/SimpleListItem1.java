package org.esiea.trochu_evenot.app_android;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import java.util.List;

import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.EditText;
import android.widget.Toast;



public class SimpleListItem1 extends AppCompatActivity {

    List<String> items;
    RecyclerSimpleViewAdapter adapter;
    RecyclerView recyclerView;
    ArrayList<Biere> ls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list_item1);
        recyclerView = (RecyclerView) findViewById(R.id.myListSimple);


        items = new ArrayList<String>();
        items.add("Nom Bière");

         adapter = new RecyclerSimpleViewAdapter(items, android.R.layout.simple_list_item_1);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
    public void Affiche (View v){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void charge_liste (View v){

        RequeteHttp.startActionRequete(this);
        IntentFilter intentFilter = new IntentFilter(BiERS_UPDATE);
        LocalBroadcastManager.getInstance(this).registerReceiver(new SimpleListItem1.MybroadcastReceiver(),intentFilter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    public static final String BiERS_UPDATE="Evenot";
    public class MybroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            ls= (ArrayList<Biere>) intent.getSerializableExtra("BiereList");
            Log.i("Remi", "retour" + ls.size());
            for(int compt=0;compt<ls.size();compt++) {
                items.add(ls.get(compt).getName());
            }
            recyclerView.setVisibility(RecyclerView.VISIBLE);
        }
    }

}

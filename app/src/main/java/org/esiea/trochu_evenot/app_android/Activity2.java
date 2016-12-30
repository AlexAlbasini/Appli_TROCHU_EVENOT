package org.esiea.trochu_evenot.app_android;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.w3c.dom.Text;


public class Activity2 extends AppCompatActivity {

    int compteur;
    int comptNom;
    int comptSens;
    int nbrJoueur;
    TextView tv2;
    TextView button_page;
    TextView NomTour;
    Bundle b;
    Intent ii;
    String str2;





    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        tv2 = (TextView) findViewById(R.id.textView2);
        NomTour=(TextView) findViewById(R.id.textViewTour);
        button_page=(TextView) findViewById(R.id.bout_page);
        button_page.setText("retour");
        button_page.setTextSize(15);
        tv2.setTextSize(25);
        tv2.setText("Pret à jouer au Pintos ? :)");
        compteur=0;
        comptNom=1;
        comptSens=1;

        ii=getIntent();
        b = ii.getExtras();

        nbrJoueur=(int) b.get("taille");

        str2 = (String) b.get("stridx1");
        tv2.setText("C'est à "+str2+" de commencer ");



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
                Intent myIntent2= new Intent(Activity2.this,SimpleListItem1.class);
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


    public void Bouton_compter(View v) {

     compteur=compteur+1;
        if (compteur%5==0 || compteur%7==0) {
            tv2.setText("Perdu - Tu dois boire");
            tv2.setTextColor(Color.RED);
            tv2.setTextSize(35);
            tv2.setTypeface(null, Typeface.BOLD);
            compteur = 0;
            comptSens=1;
        }
        else {
            if(comptSens%2==0){
                if(comptNom==1){
                    comptNom=nbrJoueur+1;
                }
                comptNom=comptNom-1;
            }
            else {
                if(comptNom==nbrJoueur){
                    comptNom=0;
                }
                comptNom = comptNom + 1;
            }
            tv2.setText(Integer.toString(compteur));
            tv2.setTextColor(Color.BLACK);
            tv2.setTextSize(25);
            tv2.setTypeface(null, Typeface.NORMAL);

            str2 = (String) b.get("stridx"+(comptNom));
            NomTour.setText("C'est à "+str2+" de jouer ");

        }

    }

    public void Bouton_pintos(View v) {
        comptSens=comptSens+1;

        compteur=compteur+1;
        if (compteur%5==0 || compteur%7==0) {

            if(comptSens%2==0){
                if(comptNom==1){
                    comptNom=nbrJoueur+1;
                }
                comptNom=comptNom-1;
            }
            else {
                if(comptNom==nbrJoueur){
                    comptNom=0;
                }
                comptNom = comptNom + 1;
            }
            tv2.setText("Pintos !!!   " +compteur);
            tv2.setTextColor(Color.BLUE);
            tv2.setTextSize(35);
            tv2.setTypeface(null, Typeface.BOLD);

            str2 = (String) b.get("stridx"+(comptNom));
            NomTour.setText("C'est à "+str2+" de jouer ");

        }
        else {
            tv2.setText("Perdu - Tu dois boire");
            tv2.setTextColor(Color.RED);
            tv2.setTextSize(35);
            tv2.setTypeface(null, Typeface.BOLD);
            compteur = 0;
            comptSens=1;
        }
    }

    public void Page_preced(View v){
        AlertDialog show = new AlertDialog.Builder(this).setTitle("REQUEST").setMessage("ETES VOUS SUR DE VOULOIR QUITTER ?")
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent myIntent4= new Intent(Activity2.this,MainActivity.class);
                        startActivity(myIntent4);
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                })
                .show();
    }



    }


package org.esiea.trochu_evenot.app_android;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.ArrayList;


import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class RequeteHttp extends IntentService {

    public static final String URL= "http://binouze.fabrigli.fr/bieres.json";




    public RequeteHttp() {
        super("RequeteHttp");
    }

    protected void onHandleIntent(Intent intent) {

        ArrayList<Biere> BiereList=new ArrayList<Biere>();

        String urlpath = intent.getStringExtra(URL);
        InputStream is = null;
        BufferedReader r = null;
        StringBuilder result = null;
        //on récupère les données depuis l'URL
        try {
            URL aURL = new URL("http://binouze.fabrigli.fr/bieres.json");
            URLConnection conn = aURL.openConnection();
            conn.connect();
            is = conn.getInputStream();
            r = new BufferedReader(new InputStreamReader(is));
            result = new StringBuilder();
            String line;
            while ((line = r.readLine()) != null) {
                result.append(line);
            }

            JSONArray biere = new JSONArray(result.toString());
            for(int i = 0; i<biere.length() ; i++){
                JSONObject c = biere.getJSONObject(i);

                String category_id=c.getString("category_id");
                String country=c.getString("country_id");
                String created_at=c.getString("created_at");
                String description=c.getString("description");
                String id=c.getString("id");
                String name = c.getString("name");
                String note=c.getString("note");

                Log.i("name: ", name);

                Biere b = new Biere(category_id,country,created_at, description,id,name,note);
                BiereList.add(b);


            }

        } catch (Exception e) {
            Log.e("erreur",e.getMessage());

        } finally {
            if (r != null) try {
                r.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        Log.i("Remi", result.toString());

        Intent i = new Intent(SimpleListItem1.BiERS_UPDATE);
        i.putExtra("BiereList", BiereList);
        LocalBroadcastManager.getInstance(this).sendBroadcast(i);


    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionRequete(Context context) {
        Intent intent= new Intent (context, RequeteHttp.class);
        intent.setAction("");
        context.startService(intent);

    }


}
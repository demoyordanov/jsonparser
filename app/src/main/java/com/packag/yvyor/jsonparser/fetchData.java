package com.packag.yvyor.jsonparser;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by yvyor on 4/14/2018.
 */

public class fetchData extends AsyncTask<Void,Void,Void> {
    String data ="";
    String dataParsed = "";
    String singleParsed ="";

    @Override
    protected Void doInBackground(Void... voids) {
        try {
//          URL url = new URL("https://api.myjson.com/bins/j5f6b");
            URL url = new URL("https://exchangeratesapi.io/api/latest?base="+MainActivity.dropdown.getSelectedItem().toString());

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            InputStream inputStream = httpURLConnection.getInputStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line = "";
            String line2 = "";
            while(line != null){
                line = bufferedReader.readLine();
                data = data + line;
            }

                JSONObject JO = new JSONObject(data);//(JSONObject) JA.get(0);
                JSONObject RT = (JSONObject) JO.getJSONObject("rates");
                singleParsed =  "FROM " + JO.get("base") + " AT " + RT.get(MainActivity.dropdown2.getSelectedItem().toString()) + "\n";//"\n"+
                        //"date:" + JO.get("date") + "\n"+
                        // + RT.get("CAD") + "\n";

                dataParsed = dataParsed + singleParsed +"\n" ;


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        MainActivity.data.setText(this.dataParsed);
    }
}

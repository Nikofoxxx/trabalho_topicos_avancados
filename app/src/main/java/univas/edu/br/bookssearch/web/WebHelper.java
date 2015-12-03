package univas.edu.br.bookssearch.web;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


public class WebHelper {

    private static final String TAG = WebHelper.class.getSimpleName();

    private static final String URL_BASE = "https://www.googleapis.com/books/v1/volumes?q=";

    private Context context;

    public WebHelper(Context ctx) {
        context = ctx;
    }

    public String getBooksContent(String query) {

        if(!isNetworkAvaliable(context)) {
            return null;
        }
        String response = null;

        HttpURLConnection conn = null;
        try {

            URL url = new URL(URL_BASE + query);
            conn = (HttpURLConnection) url.openConnection();
            response = readContent(conn.getInputStream());
        } catch(IOException e) {
            if(conn != null) {
                conn.disconnect();
            }
        }
        return response;
    }

    private String readContent(InputStream in) {
        String resp = "";
        Scanner sc = new Scanner(in);
        while(sc.hasNextLine()) {
            resp += sc.nextLine();
        }
        return resp;
    }

    public boolean isNetworkAvaliable(Context ctx) {
        ConnectivityManager cm = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo ni = cm.getActiveNetworkInfo();

        Log.d(TAG, "ni: " + ni);
        if(ni != null && ni.isConnected()) {
            if(ni.getType() == ConnectivityManager.TYPE_WIFI) {
                Log.d(TAG, "Conectado via Wifi");
            } else if(ni.getType() == ConnectivityManager.TYPE_MOBILE){
                Log.d(TAG, "Conectado via mobile");
            }
            return true;
        }
        return false;
    }
}

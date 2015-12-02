package univas.edu.br.bookssearch.web;

import android.content.Context;
import android.os.AsyncTask;


/**
 * Created by nicolas on 01/12/15.
 */
public class WebTask extends AsyncTask<Integer, Integer, String> {

    private Context context;
    //private TextView widgetTexto;


    public WebTask(Context ctx/*, TextView text*/) {
        this.context = ctx;
       // this.widgetTexto = text;
    }
    
    @Override
    protected String doInBackground(Integer... params) {
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}

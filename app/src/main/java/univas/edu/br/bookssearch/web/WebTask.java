package univas.edu.br.bookssearch.web;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import univas.edu.br.bookssearch.model.Book;


/**
 * Created by nicolas on 01/12/15.
 */
public class WebTask extends AsyncTask<Integer, Integer, String> {

    private static final String TAG = WebTask.class.getSimpleName();
    private Context context;
    private ViewPager fetchedBooksViewPager;
    private String booksQuery;


    public WebTask(Context ctx, ViewPager fetchedBooksViewPager, String booksQuery) {
        this.context = ctx;
        this.fetchedBooksViewPager = fetchedBooksViewPager;
        this.booksQuery = booksQuery;
    }
    
    @Override
    protected String doInBackground(Integer... params) {
        Log.d(TAG, "Início de doInBackground: " + params);

        WebHelper helper = new WebHelper(context);

        String content = helper.getBooksContent(booksQuery);

        Log.d(TAG, "Fim de doInBackground: " + content);
        return content;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        Log.d(TAG, "Valores de onProgressUpdate: " + values);
    }

    @Override
    protected void onPostExecute(String result) {
        Log.d(TAG, "Valores de onPostExecute: " + result);
        if(result == null) {
            Toast.makeText(context, "Ligue sua internet.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Finalizado!", Toast.LENGTH_SHORT).show();

            JsonHelper jsonHelper = new JsonHelper();

            ArrayList<Book> books = jsonHelper.extractBooks(result);

            //widgetTexto.setText(cidade.getIbge() + " " + cidade.getLocalidade());
        }
    }
}

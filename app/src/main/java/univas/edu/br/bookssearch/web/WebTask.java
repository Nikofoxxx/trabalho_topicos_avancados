package univas.edu.br.bookssearch.web;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import univas.edu.br.bookssearch.model.Book;

/**
 * Created by nicolas on 01/12/15.
 */
public class WebTask extends AsyncTask<Integer, Integer, String> {

    private static final String TAG = WebTask.class.getSimpleName();
    private Context context;
    private Button listFetchedBooksBtn;
    private String booksQuery;
    private ArrayList<Book> books;

    public WebTask(Context ctx, Button listFetchedBooksBtn, String booksQuery) {
        this.context = ctx;
        this.listFetchedBooksBtn = listFetchedBooksBtn;
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

            listFetchedBooksBtn.setEnabled(false);

            Toast.makeText(context, "Ligue sua internet.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Finalizado!", Toast.LENGTH_SHORT).show();

            JsonHelper jsonHelper = new JsonHelper();

            books = jsonHelper.extractBooks(result);

            listFetchedBooksBtn.setEnabled(true);
        }
    }

    public ArrayList<Book> getBooks(){ return books; }
}

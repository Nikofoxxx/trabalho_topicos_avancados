package univas.edu.br.bookssearch.web;

import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import univas.edu.br.bookssearch.model.Book;

public class JsonHelper {

    public ArrayList<Book> extractBooks(String jsonStr){
        try{
            Gson parser = new Gson();
            JSONObject booksJSON = new JSONObject(jsonStr);
            JSONArray booksJSONArray = booksJSON.getJSONArray("items");
            ArrayList<Book> booksList = new ArrayList<Book>();

            for(int i=0; i < booksJSONArray.length(); i++) {
                JSONObject jsonData = booksJSONArray.getJSONObject(i);
                JSONObject jsonVolumeInfo = jsonData.getJSONObject("volumeInfo");
                Book book = parser.fromJson(String.valueOf(jsonVolumeInfo), Book.class);
                booksList.add(book);
            }

            return booksList;

        } catch (Throwable t) {
            Log.d("My App", "Could not parse malformed JSON: \"" + jsonStr + "\"");
        }

        return null;
    }
}

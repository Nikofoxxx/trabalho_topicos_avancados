package univas.edu.br.bookssearch.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by nicolas on 03/12/15.
 */
public class BookDAO extends BookDBHelper {

    public static final String TAG = BookDAO.class.getSimpleName();

    public BookDAO(Context context) {
        super(context);
    }

    public void saveApprovedBook(Book book) {
        try {
            Log.d(TAG, "Salvando livro aprovado: " + book);

            ContentValues values = new ContentValues();
            values.put(BookContract.Column.TITLE, book.getTitle());
            values.put(BookContract.Column.PAGE_COUNT, book.getPageCount());
            values.put(BookContract.Column.PUBLISHER, book.getPublisher());
            values.put(BookContract.Column.INFO_LINK, book.getInfoLink());

            SQLiteDatabase db = super.getWritableDatabase();
            db.insert(BookContract.APPROVEDBOOKS_TABLE, null, values);
        }catch (Exception ex){
            Log.d(TAG, "Problemas ao tentar salvar livro aprovado: " + ex.getMessage());
        }
    }

    public void saveRerovedBook(Book book) {
        try {
            Log.d(TAG, "Salvando livro reprovado: " + book);

            ContentValues values = new ContentValues();
            values.put(BookContract.Column.TITLE, book.getTitle());
            values.put(BookContract.Column.PAGE_COUNT, book.getPageCount());
            values.put(BookContract.Column.PUBLISHER, book.getPublisher());
            values.put(BookContract.Column.INFO_LINK, book.getInfoLink());

            SQLiteDatabase db = super.getWritableDatabase();
            db.insert(BookContract.REPROVEDBOOKS_TABLE, null, values);
        }catch (Exception ex){
            Log.d(TAG, "Problemas ao tentar salvar livro reprovado: " + ex.getMessage());
        }
    }

    public List<Book> getAllApprovedBooks() {

        Cursor cursor = getAllApprovedBooksAsCursor();
        List<Book> list = new ArrayList<>();

        if(cursor.moveToFirst()) {
            do {
                Book book = new Book();
                //book.setId(cursor.getInt(0));
                book.setTitle(cursor.getString(1));
                book.setPageCount(cursor.getInt(2));
                book.setPublisher(cursor.getString(3));
                book.setInfoLink(cursor.getString(4));
                list.add(book);

            } while(cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    public Cursor getAllApprovedBooksAsCursor() {
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables(BookContract.APPROVEDBOOKS_TABLE);

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = qb.query(db, BookContract.COLUMN_NAMES,
                null, null, null, null, null);

        return cursor;
    }

    public List<Book> getAllReprovedBooks() {

        Cursor cursor = getAllReprovedBooksAsCursor();
        List<Book> list = new ArrayList<>();

        if(cursor.moveToFirst()) {
            do {
                Book book = new Book();
                //book.setId(cursor.getInt(0));
                book.setTitle(cursor.getString(1));
                book.setPageCount(cursor.getInt(2));
                book.setPublisher(cursor.getString(3));
                book.setInfoLink(cursor.getString(4));
                list.add(book);

            } while(cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    public Cursor getAllReprovedBooksAsCursor() {
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables(BookContract.REPROVEDBOOKS_TABLE);

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = qb.query(db, BookContract.COLUMN_NAMES,
                null, null, null, null, null);

        return cursor;
    }
}

package univas.edu.br.bookssearch.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by nicolas on 03/12/15.
 */
public class BookDBHelper extends SQLiteOpenHelper {

    private static final String TAG = BookDBHelper.class.getSimpleName();

    public BookDBHelper(Context context) {
        super(context, BookContract.DB_NAME, null, BookContract.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createApprovedBooksTable(db);
        createReprovedBooksTable(db);
    }

    public void createApprovedBooksTable(SQLiteDatabase db){
        Log.d(TAG, "Criando a Livros aprovados...");
        String CREATE_APPROVED_BOOKS_TABLE =
                "CREATE TABLE " + BookContract.APPROVEDBOOKS_TABLE + " ("
                        + BookContract.Column.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + BookContract.Column.TITLE + " TEXT NOT NULL, "
                        + BookContract.Column.PAGE_COUNT + " TEXT, "
                        + BookContract.Column.PUBLISHER + " TEXT, "
                        + BookContract.Column.INFO_LINK + " TEXT NOT NULL"
                        + " )";

        db.execSQL(CREATE_APPROVED_BOOKS_TABLE);
    }

    public void createReprovedBooksTable(SQLiteDatabase db){
        Log.d(TAG, "Criando a Livros reprovados...");
        String CREATE_REPROVED_BOOKS_TABLE =
                "CREATE TABLE " + BookContract.REPROVEDBOOKS_TABLE + " ("
                        + BookContract.Column.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + BookContract.Column.TITLE + " TEXT NOT NULL, "
                        + BookContract.Column.PAGE_COUNT + " TEXT, "
                        + BookContract.Column.PUBLISHER + " TEXT, "
                        + BookContract.Column.INFO_LINK + " TEXT NOT NULL"
                        + " )";

        db.execSQL(CREATE_REPROVED_BOOKS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "Executou onUpgrade: " + " oldVersion: " + oldVersion + " newVersion: " + newVersion);
    }
}

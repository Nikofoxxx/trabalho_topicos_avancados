package univas.edu.br.bookssearch.model;

import android.provider.BaseColumns;

/**
 * Created by nicolas on 03/12/15.
 */
public class BookContract {

    public static final String DB_NAME = "book.db";
    public static final int DB_VERSION = 2;

    public static final String APPROVEDBOOKS_TABLE = "APPROVED_BOOKS";
    public static final String REPROVEDBOOKS_TABLE = "REPROVED_BOOKS";

    public static final String [] COLUMN_NAMES = {
            Column.ID, Column.TITLE, Column.PAGE_COUNT, Column.PUBLISHER, Column.INFO_LINK
    };

    public class Column {
        public static final String ID = BaseColumns._ID;
        public static final String TITLE = "TITLE";
        public static final String PAGE_COUNT = "PAGE_COUNT";
        public static final String PUBLISHER = "PUBLISHER";
        public static final String INFO_LINK = "INFO_LINK";
    }
}

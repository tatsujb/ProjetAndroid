import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.Override;

public class DBInteraction extends SQLiteOpenHelper {

    public static final String DB_NAME;
    public static final int DB_VERSION;

    static {
        DB_NAME = "scores.db";
        DB_VERSION = 1;
    }

    public DBInteraction(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String creatingQuery = "CREATE TABLE scores("
                + "id INTEGER PRIMARY KEY,"
                + "pseudo TEXT,"
                + "score INTEGER)";
        db.execSQL(creatingQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addScore(SQLiteDatabase db, String pseudo, int score) {
        String addingQuery = "INSERT INTO scores(pseudo, score) "
                + "VALUES('" + pseudo + "', " + score + ")";
        db.execSQL(addingQuery);
    }

    public void remScore(SQLiteDatabase db, int id) {
        db.execSQL("DELETE FROM scores WHERE id = " + id);
    }

    public void clearTable(SQLiteDatabase db) {
        db.execSQL("DELETE FROM scores");
    }
}

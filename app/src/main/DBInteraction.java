import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.Override;

/**
 * DBInteraction est la classe gérant toutes les intéractions
 * avec la base de données. Elle hérite de la class SQLiteOpenHelper.
 *
 * @see {@link android.database.sqlite.SQLiteOpenHelper}
 */
public class DBInteraction extends SQLiteOpenHelper {
    /**
     * Nom de la base de données.
     */
    public static final String DB_NAME;
    
    /**
     *  Version de la base de données.
     */
    public static final int DB_VERSION;

    /**
     *  Bloc initialisant tous les attributs de classe.
     */
    static {
        DB_NAME = "scores.db";
        DB_VERSION = 1;
    }

    /**
     * Constructeur par défaut.
     *
     * @param context
     *          À utiliser pour ouvrir ou créer la base de données.
     */
    public DBInteraction(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    /**
     * Appelée lors de la création de la base de donnée.
     *
     * @param db
     *          La base de données.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String creatingQuery = "CREATE TABLE scores("
                + "id INTEGER PRIMARY KEY,"
                + "pseudo TEXT,"
                + "score INTEGER)";
        db.execSQL(creatingQuery);
    }

    /**
     * Ajoute un score dans la base de données.
     *
     * @param db
     *          La base de données.
     * @param pseudo
     *          Le pseudo du joueur ayant atteint le score.
     * @param score
     *          Score atteint par le joueur.
     */
    public void addScore(SQLiteDatabase db, String pseudo, int score) {
        String addingQuery = "INSERT INTO scores(pseudo, score) "
                + "VALUES('" + pseudo + "', " + score + ")";
        db.execSQL(addingQuery);
    }

    /**
     * Supprime le score passé de la base de donnée.
     *
     * @param db
     *          La base de données.
     * @param id
     *          Identifiant du score dans la base de données.
     */
    public void remScore(SQLiteDatabase db, int id) {
        db.execSQL();
    }

    /**
     * Supprime toutes les données de la base de données.
     *
     * @param db
     *          La base de données.
     */
    public void clearTable(SQLiteDatabase db) {
        db.execSQL("DELETE FROM scores");
    }
}

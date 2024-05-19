package pnj.uts.ti.nama_mahasiswa;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class OpenHelper extends SQLiteOpenHelper {
    public static String _NAMA_DATABASE = "dbalumni";
    public static int _VERSION = 1;
    public static String _TABLE_ALUMNI = "tb_alumni";
    public static String _COLUMN_ID = "id";
    public static String _COLUMN_NIM = "nim";
    public static String _COLUMN_NAMA = "nama";
    public static String _COLUMN_TEMPAT = "tempat_lahir";
    public static String _COLUMN_AGAMA = "agama";
    public static String _COLUMN_ALAMAT = "alamat";
    public static String _COLUMN_TANGGAL = "tanggal_lahir";
    public static String _COLUMN_TLP = "tlp";
    public static String _COLUMN_MASUK = "tahun_masuk";
    public static String _COLUMN_LULUS = "tahun_lulus";
    public static String _COLUMN_PEKERJAAN = "pekerjaan";
    public static String _COLUMN_JABATAN = "jabatan";

    public OpenHelper(@Nullable Context context){
        super(context, _NAMA_DATABASE, null, _VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+_TABLE_ALUMNI+" ("+_COLUMN_ID+ "INTEGER PRIMARY KEY AUTOINCREMENT, "+
                _COLUMN_NIM+ "TEXT, "+ _COLUMN_NAMA+" TEXT," +_COLUMN_TEMPAT+" TEXT," + _COLUMN_TANGGAL+" TEXT," +
                        _COLUMN_ALAMAT+" TEXT," + _COLUMN_AGAMA+" TEXT," +_COLUMN_TLP+" TEXT," + _COLUMN_MASUK+" TEXT," +
                        _COLUMN_LULUS+" TEXT," + _COLUMN_PEKERJAAN+" TEXT," + _COLUMN_JABATAN+" TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void deleteRow(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(_TABLE_ALUMNI, _COLUMN_NIM + " = ?", new String[]{String.valueOf(id)});
        db.close();
    }

}

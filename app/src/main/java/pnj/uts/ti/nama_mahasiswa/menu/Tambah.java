package pnj.uts.ti.nama_mahasiswa.menu;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import pnj.uts.ti.nama_mahasiswa.MainActivity3;
import pnj.uts.ti.nama_mahasiswa.OpenHelper;
import pnj.uts.ti.nama_mahasiswa.R;

public class Tambah extends AppCompatActivity {
    EditText nim, nama, tempat, tanggal, alamat, agama, tlp, masuk, lulus, pekerjaan, jabatan;
    Button save, etgl;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tambah);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        nim = findViewById(R.id.nimt);
        nama = findViewById(R.id.namat);
        tempat = findViewById(R.id.tempatt);
        tanggal = findViewById(R.id.tanggalt);
        alamat = findViewById(R.id.alamatt);
        agama = findViewById(R.id.agamat);
        tlp = findViewById(R.id.tlpt);
        masuk = findViewById(R.id.tmt);
        lulus = findViewById(R.id.tlt);
        pekerjaan = findViewById(R.id.pt);
        jabatan = findViewById(R.id.jabt);
        etgl = findViewById(R.id.btntg);
        etgl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTanggal();
            }
        });
        save = findViewById(R.id.btn);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpan();
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.top_menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.option_1) {
            Toast t = Toast.makeText(this, "Sudah Disini", Toast.LENGTH_SHORT);t.show();
            return true;
        } else if (id == R.id.option_2) {
            topmenu(2);
            return true;
        } else if (id == R.id.option_3) {
            logout();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
    public void logout(){
        finish();
    }
    public void topmenu(int p){
        Intent intentl;
        if (p == 1){
            intentl = new Intent(Tambah.this, Tambah.class);
        } else {
            intentl = new Intent(Tambah.this, MainActivity3.class);
        }
        startActivity(intentl);
    }
    void showTanggal() {
        Calendar calendar = Calendar.getInstance();
        new DatePickerDialog(this, listenerDate, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
    }
    DatePickerDialog.OnDateSetListener listenerDate = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
            tanggal.setText(dateFormat.format(calendar.getTime()));
        }

    };
    void simpan() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(OpenHelper._COLUMN_NIM, nim.getText().toString());
        contentValues.put(OpenHelper._COLUMN_NAMA, nama.getText().toString());
        contentValues.put(OpenHelper._COLUMN_TEMPAT, tempat.getText().toString());
        contentValues.put(OpenHelper._COLUMN_TANGGAL, tanggal.getText().toString());
        contentValues.put(OpenHelper._COLUMN_AGAMA, agama.getText().toString());
        contentValues.put(OpenHelper._COLUMN_ALAMAT, alamat.getText().toString());
        contentValues.put(OpenHelper._COLUMN_TLP, tlp.getText().toString());
        contentValues.put(OpenHelper._COLUMN_MASUK, masuk.getText().toString());
        contentValues.put(OpenHelper._COLUMN_LULUS, lulus.getText().toString());
        contentValues.put(OpenHelper._COLUMN_PEKERJAAN, pekerjaan.getText().toString());
        contentValues.put(OpenHelper._COLUMN_JABATAN, jabatan.getText().toString());

        SQLiteDatabase db = new OpenHelper(this).getWritableDatabase();

        long insert = db.insert(OpenHelper._TABLE_ALUMNI, null, contentValues);

        if(insert != -1) {
            Toast.makeText(this, "Simpan Data Berhasil", Toast.LENGTH_SHORT).show();
            finish();
        }


    }

}
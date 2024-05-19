package pnj.uts.ti.nama_mahasiswa.fragment;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import pnj.uts.ti.nama_mahasiswa.R;

public class DetailNews extends AppCompatActivity {
    ImageView imgBerita;
    TextView txtJudul, txtIsi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailberita);
        imgBerita = findViewById(R.id.imgBerita);
        txtJudul = findViewById(R.id.txtJudul);
        txtIsi = findViewById(R.id.txtIsiBerita);

        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            Picasso.get().load(extras.getString("image","")).into(imgBerita);
            txtIsi.setText(extras.getString("isi",""));
            txtJudul.setText(extras.getString("judul",""));
        }
    }
}

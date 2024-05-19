package pnj.uts.ti.nama_mahasiswa;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    private static final String HCE = "0";
    private static final String HCP = "0";
    EditText txtemail;
    EditText txtpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtemail = findViewById(R.id.emailtxt);
        txtpassword = findViewById(R.id.pwtxt);

    }
    public void login(View v){
        String email = txtemail.getText().toString();
        String password = txtpassword.getText().toString();
        if (email.equals(HCE) && password.equals(HCP)){
            SharedPreferences sharedPref = getSharedPreferences("user", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("email", email);
            editor.putString("nim", "2207411040");
            editor.putString("Nama", "Juan Graciano");
            editor.putString("Kelas", "TI-4B");
            editor.apply();

            Intent masuk = new Intent(this, MainActivity.class);

            startActivity(masuk);

        } else {
            Toast.makeText(MainActivity2.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
        }
//        Intent masuk = new Intent(this, MainActivity.class);
//        EditText em = findViewById(R.id.emailtxt);
//        String ep = em.getText().toString();
//        masuk.putExtra("email", ep);
//        startActivity(masuk);
    }
}
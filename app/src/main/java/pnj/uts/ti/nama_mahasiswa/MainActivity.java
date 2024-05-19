package pnj.uts.ti.nama_mahasiswa;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import pnj.uts.ti.nama_mahasiswa.fragment.HomeFragment;
import pnj.uts.ti.nama_mahasiswa.fragment.NewsFragment;
import pnj.uts.ti.nama_mahasiswa.fragment.ProfileFragment;
import pnj.uts.ti.nama_mahasiswa.menu.Tambah;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        // Load the default fragment
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
        }
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    if (item.getItemId() == R.id.nav_home) {
                        selectedFragment = new HomeFragment();
                    } else if (item.getItemId() == R.id.nav_news) {
                        selectedFragment = new NewsFragment();
                    } else if (item.getItemId() == R.id.nav_profile) {
                        selectedFragment = new ProfileFragment();
                    }

                    if (selectedFragment != null) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                    }

                    return true;
                }
            };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.top_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.option_1) {
            topmenu(1);
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
            intentl = new Intent(MainActivity.this, Tambah.class);
            startActivity(intentl);
        } else {
            intentl = new Intent(MainActivity.this, MainActivity3.class);
            startActivity(intentl);
        }

    }
}

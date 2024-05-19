package pnj.uts.ti.nama_mahasiswa.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import pnj.uts.ti.nama_mahasiswa.R;

public class ProfileFragment extends Fragment {
    private TextView textViewEmail;
    private TextView textViewNim;
    private TextView textViewNama;
    private TextView textViewKelas;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        textViewEmail = view.findViewById(R.id.textViewEmail);
        textViewNim = view.findViewById(R.id.textViewNim);
        textViewNama = view.findViewById(R.id.textViewNama);
        textViewKelas = view.findViewById(R.id.textViewKelas);

        SharedPreferences sharedPref = getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);
        String email = sharedPref.getString("email", "Email not found");
        String nim = sharedPref.getString("nim", "NIM not found");
        String nama = sharedPref.getString("Nama", "Nama not found");
        String kelas = sharedPref.getString("Kelas", "Kelas not found");

        textViewEmail.setText(email);
        textViewNim.setText(nim);
        textViewNama.setText(nama);
        textViewKelas.setText(kelas);

        return view;
    }
}

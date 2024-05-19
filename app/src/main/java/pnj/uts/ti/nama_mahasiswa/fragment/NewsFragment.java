package pnj.uts.ti.nama_mahasiswa.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import pnj.uts.ti.nama_mahasiswa.R;
import pnj.uts.ti.nama_mahasiswa.fragment.adapter.Adapterberita;
import pnj.uts.ti.nama_mahasiswa.fragment.adapter.BeritaModel;

public class NewsFragment extends Fragment {
    ListView listView;
    Adapterberita adapterBerita;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        listView = view.findViewById(R.id.lv);

        adapterBerita = new Adapterberita(requireContext(), R.layout.item_layber);
        listView.setAdapter(adapterBerita);
        loadDataList();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                BeritaModel model = (BeritaModel) parent.getAdapter().getItem(position);

                Intent intent =new Intent(requireContext(), DetailNews.class);
                intent.putExtra("image", model.getImage());
                intent.putExtra("judul", model.getJudulBerita());
                intent.putExtra("isi",model.getIsiBerita());
                Log.d("NewsFragment", "Intent created");
                startActivity(intent);
            }
        });
        return view;
    }
    void loadDataList() {
        String[] image = new String[]{"https://akcdn.detik.net.id/community/media/visual/2020/10/26/adv-transpark.jpeg?w=700&q=90",
                "https://akcdn.detik.net.id/community/media/visual/2020/10/27/kapolsek-mampang-prapatan-kompol-sujarwo-didampingi-kanit-reskrim-iptu-sigit-dan-kasubag-humas-akprita-1_169.jpeg?w=700&q=90",
                "https://akcdn.detik.net.id/community/media/visual/2020/10/27/temuan-indikasi-kehidupan-di-venus-sebuah-kesalahan-pengukuran.jpeg?w=700&q=90",
                "https://akcdn.detik.net.id/community/media/visual/2024/05/19/juergen-klopp-1_169.jpeg?w=700&q=90",
                "https://akcdn.detik.net.id/community/media/visual/2020/05/12/ee98c2ea-74db-4a7e-8d29-0bd0c2ec9126_169.jpeg?w=700&q=90",
                "https://asset.kompas.com/crops/8kYAA-iPkewcr2OFA3uFCsOVexA=/212x0:935x482/750x500/data/photo/2024/05/19/664915317bf6e.jpg",
                "https://asset.kompas.com/crops/LJqJxFH4SVsISf2Y5GE04P4eoI8=/0x0:750x500/750x500/data/photo/2023/08/18/64def15305429.jpg",
                "https://asset.kompas.com/crops/9eqOVP1bDUB7jkJO8HtzHaZQgIc=/0x0:0x0/750x500/data/photo/2023/10/18/652f1015bdc48.jpeg",
                "https://asset.kompas.com/crops/CWRb0IEx_2Z_5xhxD16puNiVRXA=/0x0:0x0/1200x800/data/photo/2024/03/15/65f4519e52bca.jpg",
                "https://asset.kompas.com/crops/2erojhtOyyOj_Yvxdb-xfAGOVjg=/191x0:1836x1097/750x500/data/photo/2023/03/06/64059d5baa0f2.jpg"};

        String[] judul = new String[]{"Vaksin COVID-19 Ditemukan, Saatnya Berburu Investasi Properti",
                "Alarm Berbunyi, 2 Pria Ini Gagal Curi Motor di Mampang Jaksel",
                "Temuan Indikasi Kehidupan di Venus, Sebuah Kesalahan Pengukuran?",
                "Klopp: Liverpool Akan Baik-baik Saja Tanpa Saya",
                "Jadwal Liga Inggris Nanti Malam, Manchester City atau Arsenal yang Juara?",
                "Atalanta Lolos ke Liga Champions, De Ketelaere Minta Maaf ke AC Milan",
                "Prabowo Kasih Jatah Duit Negara untuk IKN Rp 16 Triliun Per Tahun",
                "Yusril Bakal Mundur dari Ketum PBB demi Regenerasi",
                "Luhut Tolak Tawaran Jadi Menteri, tapi Minat Jadi Penasihat Prabowo",
                "Exco Diduga Jadi Pemilik Tiga Klub Liga 3, PSSI Diminta Tegas"};

        String[] isiBerita = new String[]{"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."};

        for(int i=0; i< image.length;i++){
            BeritaModel model = new BeritaModel();
            model.setImage(image[i]);
            model.setJudulBerita(judul[i]);
            model.setIsiBerita(isiBerita[i]);
            adapterBerita.add(model);
        }
        adapterBerita.notifyDataSetChanged();
    }
}

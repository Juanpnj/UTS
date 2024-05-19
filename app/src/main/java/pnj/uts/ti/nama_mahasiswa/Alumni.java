package pnj.uts.ti.nama_mahasiswa;

public class Alumni {
    private String nim;
    private String nama;

    public Alumni(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
    }

    // Getter dan Setter
    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
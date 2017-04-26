package id.ac.unila.galih.kupukupu.model;

import org.parceler.Parcel;

import java.util.Comparator;

/**
 * Created by japra_awok on 30/09/2016.
 */

@Parcel
public class KupuKupuOld {
    public String family, sub_family, genus, spesies, sub_spesies, nama_ilmiah, nama_umum, lebar_sayap, deskripsi, habitat, tanaman_nektar, tanaman_inang, warna, corak, gambar;

    public KupuKupuOld() {
    }

    public KupuKupuOld(String family, String sub_family, String genus, String spesies, String sub_spesies, String nama_ilmiah, String nama_umum, String lebar_sayap, String deskripsi, String habitat, String tanaman_nektar, String tanaman_inang, String warna, String corak, String gambar) {
        this.family = family;
        this.sub_family = sub_family;
        this.genus = genus;
        this.spesies = spesies;
        this.sub_spesies = sub_spesies;
        this.nama_ilmiah = nama_ilmiah;
        this.nama_umum = nama_umum;
        this.lebar_sayap = lebar_sayap;
        this.deskripsi = deskripsi;
        this.habitat = habitat;
        this.tanaman_nektar = tanaman_nektar;
        this.tanaman_inang = tanaman_inang;
        this.warna = warna;
        this.corak = corak;
        this.gambar = gambar;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getSub_family() {
        return sub_family;
    }

    public void setSub_family(String sub_family) {
        this.sub_family = sub_family;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    public String getSpesies() {
        return spesies;
    }

    public void setSpesies(String spesies) {
        this.spesies = spesies;
    }

    public String getSub_spesies() {
        return sub_spesies;
    }

    public void setSub_spesies(String sub_spesies) {
        this.sub_spesies = sub_spesies;
    }

    public String getNama_ilmiah() {
        return nama_ilmiah;
    }

    public void setNama_ilmiah(String nama_ilmiah) {
        this.nama_ilmiah = nama_ilmiah;
    }

    public String getNama_umum() {
        return nama_umum;
    }

    public void setNama_umum(String nama_umum) {
        this.nama_umum = nama_umum;
    }

    public String getLebar_sayap() {
        return lebar_sayap;
    }

    public void setLebar_sayap(String lebar_sayap) {
        this.lebar_sayap = lebar_sayap;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getTanaman_nektar() {
        return tanaman_nektar;
    }

    public void setTanaman_nektar(String tanaman_nektar) {
        this.tanaman_nektar = tanaman_nektar;
    }

    public String getTanaman_inang() {
        return tanaman_inang;
    }

    public void setTanaman_inang(String tanaman_inang) {
        this.tanaman_inang = tanaman_inang;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public String getCorak() {
        return corak;
    }

    public void setCorak(String corak) {
        this.corak = corak;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    @Override
    public String toString() {
        return "KupuKupu{" +
                "family='" + family + '\'' +
                ", sub_family='" + sub_family + '\'' +
                ", genus='" + genus + '\'' +
                ", spesies='" + spesies + '\'' +
                ", sub_spesies='" + sub_spesies + '\'' +
                ", nama_ilmiah='" + nama_ilmiah + '\'' +
                ", nama_umum='" + nama_umum + '\'' +
                ", lebar_sayap='" + lebar_sayap + '\'' +
                ", deskripsi='" + deskripsi + '\'' +
                ", habitat='" + habitat + '\'' +
                ", tanaman_nektar='" + tanaman_nektar + '\'' +
                ", tanaman_inang='" + tanaman_inang + '\'' +
                ", warna='" + warna + '\'' +
                ", corak='" + corak + '\'' +
                ", gambar='" + gambar + '\'' +
                '}';
    }

    public static Comparator<KupuKupuOld> KupuKupuNameComparatorNamaIlmiah = new Comparator<KupuKupuOld>() {

        public int compare(KupuKupuOld kp1, KupuKupuOld kp2) {
            String KupuName1 = kp1.getNama_ilmiah().toUpperCase();
            String KupuName2 = kp2.getNama_ilmiah().toUpperCase();

            //ascending order
            return KupuName1.compareTo(KupuName2);
        }};

    public static Comparator<KupuKupuOld> KupuKupuNameComparatorNamaUmum = new Comparator<KupuKupuOld>() {

        public int compare(KupuKupuOld kp1, KupuKupuOld kp2) {
            String KupuName1 = kp1.getNama_umum().toUpperCase();
            String KupuName2 = kp2.getNama_umum().toUpperCase();

            //ascending order
            return KupuName1.compareTo(KupuName2);
        }};
}

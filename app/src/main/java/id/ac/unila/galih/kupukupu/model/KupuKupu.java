package id.ac.unila.galih.kupukupu.model;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.parceler.Parcel;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by japra_awok on 12/04/2017.
 */

@Parcel
public class KupuKupu {

    public String famili, sub_famili, genus, spesies, nama_lokal, lebar_sayap, kecapatan_terbang,
            deskripsi, pakan, warna_dominan;
    public String[] warna, gambar;

    public KupuKupu() {
    }

    public KupuKupu(String famili, String sub_famili, String genus, String spesies, String nama_lokal,
                    String lebar_sayap, String kecapatan_terbang, String deskripsi, String pakan, String warna_dominan, String[] warna, String[] gambar) {
        this.famili = famili;
        this.sub_famili = sub_famili;
        this.genus = genus;
        this.spesies = spesies;
        this.nama_lokal = nama_lokal;
        this.lebar_sayap = lebar_sayap;
        this.kecapatan_terbang = kecapatan_terbang;
        this.deskripsi = deskripsi;
        this.pakan = pakan;
        this.warna_dominan = warna_dominan;
        this.warna = warna;
        this.gambar = gambar;
    }

    public String getFamili() {
        return famili;
    }

    public void setFamili(String famili) {
        this.famili = famili;
    }

    public String getSub_famili() {
        return sub_famili;
    }

    public void setSub_famili(String sub_famili) {
        this.sub_famili = sub_famili;
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

    public String getNama_lokal() {
        return nama_lokal;
    }

    public void setNama_lokal(String nama_lokal) {
        this.nama_lokal = nama_lokal;
    }

    public String getLebar_sayap() {
        return lebar_sayap;
    }

    public void setLebar_sayap(String lebar_sayap) {
        this.lebar_sayap = lebar_sayap;
    }

    public String getKecapatan_terbang() {
        return kecapatan_terbang;
    }

    public void setKecapatan_terbang(String kecapatan_terbang) {
        this.kecapatan_terbang = kecapatan_terbang;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getPakan() {
        return pakan;
    }

    public void setPakan(String pakan) {
        this.pakan = pakan;
    }

    public String getWarna_dominan() {
        return warna_dominan;
    }

    public void setWarna_dominan(String warna_dominan) {
        this.warna_dominan = warna_dominan;
    }

    public String[] getWarna() {
        return warna;
    }

    public void setWarna(String[] warna) {
        this.warna = warna;
    }

    public String[] getGambar() {
        return gambar;
    }

    public void setGambar(String[] gambar) {
        this.gambar = gambar;
    }
}

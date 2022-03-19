package com.example;

public class pegawai {
    String nip;
    String nama;
    String divisi;

    public pegawai(String nip, String nama, String divisi) {
        this.nip = nip;
        this.nama = nama;
        this.divisi = divisi;
    }

    @Override
    public String toString() {
        return "pegawai{" +
                "nip='" + nip + '\'' +
                ", nama='" + nama + '\'' +
                ", divisi='" + divisi + '\'' +
                '}';
    }
}

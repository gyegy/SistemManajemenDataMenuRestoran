package com.mycompany.sistemmanajemendatamenurestoran.model;

import java.util.ArrayList;

public class Restoran {

    private String namaRestoran;
    private String alamat;
    private String noTelepon;
    private ArrayList<Menu> daftarMenu;
    private ArrayList<Kategori> daftarKategori;

    public Restoran(
            String namaRestoran,
            String alamat,
            String noTelepon) {

        this.namaRestoran = namaRestoran;
        this.alamat = alamat;
        this.noTelepon = noTelepon;
        this.daftarMenu = new ArrayList<>();
        this.daftarKategori = new ArrayList<>();
    }

    public String getNamaRestoran() {
        return namaRestoran;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public ArrayList<Menu> getDaftarMenu() {
        return daftarMenu;
    }

    public ArrayList<Kategori> getDaftarKategori() {
        return daftarKategori;
    }

    public void setNamaRestoran(String namaRestoran) {
        this.namaRestoran = namaRestoran;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }

    public void tambahKategori(Kategori kategori) {
        daftarKategori.add(kategori);
    }

    public Kategori cariKategori(String idKategori) {

        for (Kategori kategori : daftarKategori) {

            if (kategori.getIdKategori().equals(idKategori)) {
                return kategori;
            }
        }

        return null;
    }

    public boolean tambahMenu(Menu menu) {

        if (cariMenu(menu.getIdMenu()) != null) {
            return false;
        }

        daftarMenu.add(menu);
        return true;
    }

    public Menu cariMenu(String idMenu) {

        for (Menu menu : daftarMenu) {

            if (menu.getIdMenu().equals(idMenu)) {
                return menu;
            }
        }

        return null;
    }

    public boolean updateMenu(
            String idMenu,
            String namaBaru,
            double hargaBaru) {

        Menu menu = cariMenu(idMenu);

        if (menu == null) {
            return false;
        }

        menu.setNamaMenu(namaBaru);
        menu.setHarga(hargaBaru);

        return true;
    }

    public boolean hapusMenu(String idMenu) {

        Menu menu = cariMenu(idMenu);

        if (menu == null) {
            return false;
        }

        daftarMenu.remove(menu);
        return true;
    }
}
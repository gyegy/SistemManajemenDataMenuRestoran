package com.mycompany.sistemmanajemendatamenurestoran.model;

public class Menu {

    private String idMenu;
    private String namaMenu;
    private Kategori kategori;
    private double harga;

    public Menu(
            String idMenu,
            String namaMenu,
            Kategori kategori,
            double harga) {

        this.idMenu = idMenu;
        this.namaMenu = namaMenu;
        this.kategori = kategori;
        this.harga = harga;
    }

    public String getIdMenu() {
        return idMenu;
    }

    public String getNamaMenu() {
        return namaMenu;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public double getHarga() {
        return harga;
    }

    public void setNamaMenu(String namaMenu) {
        this.namaMenu = namaMenu;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public void tampilkanInfo() {

        System.out.println(
                "ID Menu   : " + idMenu
        );

        System.out.println(
                "Nama Menu : " + namaMenu
        );

        System.out.println(
                "Kategori  : "
                + kategori.getNamaKategori()
        );

        System.out.println(
                "Harga     : Rp" + harga
        );
    }
}
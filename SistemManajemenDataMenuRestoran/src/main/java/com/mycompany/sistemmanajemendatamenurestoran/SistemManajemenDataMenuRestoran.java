package com.mycompany.sistemmanajemendatamenurestoran;

import com.mycompany.sistemmanajemendatamenurestoran.model.Kategori;
import com.mycompany.sistemmanajemendatamenurestoran.model.Menu;
import com.mycompany.sistemmanajemendatamenurestoran.model.MenuMakanan;
import com.mycompany.sistemmanajemendatamenurestoran.model.MenuMinuman;
import com.mycompany.sistemmanajemendatamenurestoran.model.Restoran;
import java.util.Scanner;

public class SistemManajemenDataMenuRestoran {

    public static void main(String[] args) {

        Restoran restoran = new Restoran(
                "Restoran Egiluy Sukses Dunia Akhirat Aamiin",
                "Jl. Alip Gelap Karena Lagi Malam",
                "081234567890"
        );

        Kategori kategoriMakanan = new Kategori(
                "K001",
                "Makanan",
                "Kategori makanan restoran"
        );

        Kategori kategoriMinuman = new Kategori(
                "K002",
                "Minuman",
                "Kategori minuman restoran"
        );

        restoran.tambahKategori(kategoriMakanan);
        restoran.tambahKategori(kategoriMinuman);

        Menu makananAwal = new MenuMakanan(
                "M001",
                "Nasi Goreng",
                kategoriMakanan,
                25000,
                "Makanan Utama"
        );

        Menu minumanAwal = new MenuMinuman(
                "M002",
                "Es Teh",
                kategoriMinuman,
                8000,
                "Minuman Dingin"
        );

        restoran.tambahMenu(makananAwal);
        restoran.tambahMenu(minumanAwal);

        Scanner scanner = new Scanner(System.in);
        boolean berjalan = true;

        while (berjalan) {

            tampilkanMenuUtama();

            int pilihan = inputPilihan(
                    scanner,
                    "Pilih menu (1-7): ",
                    1,
                    7
            );

            switch (pilihan) {

                case 1 -> {

                    System.out.println("\n=== TAMBAH KATEGORI ===");

                    String idKategori = inputString(
                            scanner,
                            "ID Kategori: "
                    );

                    String namaKategori = inputString(
                            scanner,
                            "Nama Kategori: "
                    );

                    String deskripsi = inputString(
                            scanner,
                            "Deskripsi: "
                    );

                    Kategori kategoriBaru = new Kategori(
                            idKategori,
                            namaKategori,
                            deskripsi
                    );

                    restoran.tambahKategori(kategoriBaru);

                    System.out.println(
                            ">> Kategori berhasil ditambahkan"
                    );
                }

                case 2 -> {

                    System.out.println("\n=== DAFTAR KATEGORI ===");

                    if (restoran.getDaftarKategori().isEmpty()) {
                        System.out.println(
                                ">> Belum ada data kategori"
                        );
                        break;
                    }

                    for (Kategori kategori
                            : restoran.getDaftarKategori()) {

                        System.out.println(
                                "ID Kategori : "
                                + kategori.getIdKategori()
                        );

                        System.out.println(
                                "Nama        : "
                                + kategori.getNamaKategori()
                        );

                        System.out.println(
                                "Deskripsi   : "
                                + kategori.getDeskripsi()
                        );

                        System.out.println();
                    }
                }

                case 3 -> {

                    System.out.println("\n=== TAMBAH MENU ===");

                    String idMenu = inputString(
                            scanner,
                            "ID Menu: "
                    );

                    String namaMenu = inputString(
                            scanner,
                            "Nama Menu: "
                    );

                    Kategori kategoriDipilih =
                            pilihKategori(scanner, restoran);

                    if (kategoriDipilih == null) {
                        break;
                    }

                    double harga = inputHarga(
                            scanner,
                            "Harga Menu: "
                    );

                    System.out.println("\n=== PILIH JENIS MENU ===");
                    System.out.println("1. Makanan");
                    System.out.println("2. Minuman");

                    int jenisMenu = inputPilihan(
                            scanner,
                            "Pilih jenis menu (1-2): ",
                            1,
                            2
                    );

                    Menu menuBaru;

                    if (jenisMenu == 1) {

                        String jenisMakanan = inputString(
                                scanner,
                                "Jenis Makanan: "
                        );

                        menuBaru = new MenuMakanan(
                                idMenu,
                                namaMenu,
                                kategoriDipilih,
                                harga,
                                jenisMakanan
                        );

                    } else {

                        String jenisMinuman = inputString(
                                scanner,
                                "Jenis Minuman: "
                        );

                        menuBaru = new MenuMinuman(
                                idMenu,
                                namaMenu,
                                kategoriDipilih,
                                harga,
                                jenisMinuman
                        );
                    }

                    if (restoran.tambahMenu(menuBaru)) {

                        System.out.println(
                                ">> Menu berhasil ditambahkan"
                        );

                    } else {

                        System.out.println(
                                ">> ID Menu sudah digunakan"
                        );
                    }
                }

                case 4 -> {

                    System.out.println("\n=== DAFTAR MENU ===");

                    if (restoran.getDaftarMenu().isEmpty()) {
                        System.out.println(
                                ">> Belum ada data menu"
                        );
                        break;
                    }

                    for (Menu menu : restoran.getDaftarMenu()) {
                        menu.tampilkanInfo();
                        System.out.println();
                    }
                }

                case 5 -> {

                    System.out.println("\n=== UPDATE MENU ===");

                    String idTarget = inputString(
                            scanner,
                            "Masukkan ID Menu: "
                    );

                    Menu menu = restoran.cariMenu(idTarget);

                    if (menu == null) {
                        System.out.println(
                                ">> Menu tidak ditemukan"
                        );
                        break;
                    }

                    String namaBaru = inputString(
                            scanner,
                            "Nama Menu Baru: "
                    );

                    double hargaBaru = inputHarga(
                            scanner,
                            "Harga Baru: "
                    );

                    if (restoran.updateMenu(
                            idTarget,
                            namaBaru,
                            hargaBaru)) {

                        System.out.println(
                                ">> Menu berhasil diperbarui"
                        );

                    } else {

                        System.out.println(
                                ">> Menu gagal diperbarui"
                        );
                    }
                }

                case 6 -> {

                    System.out.println("\n=== HAPUS MENU ===");

                    String idTarget = inputString(
                            scanner,
                            "Masukkan ID Menu: "
                    );

                    if (restoran.hapusMenu(idTarget)) {

                        System.out.println(
                                ">> Menu berhasil dihapus"
                        );

                    } else {

                        System.out.println(
                                ">> Menu tidak ditemukan"
                        );
                    }
                }

                case 7 -> {

                    berjalan = false;

                    System.out.println(
                            "\n>> Program selesai. Terima kasih!"
                    );
                }
            }
        }

        scanner.close();
    }

    private static void tampilkanMenuUtama() {

        System.out.println(
                "\n=== SISTEM MANAJEMEN MENU RESTORAN ==="
        );

        System.out.println("1. Tambah Kategori");
        System.out.println("2. Tampilkan Kategori");
        System.out.println("3. Tambah Menu");
        System.out.println("4. Tampilkan Menu");
        System.out.println("5. Update Menu");
        System.out.println("6. Hapus Menu");
        System.out.println("7. Keluar");
    }

    private static Kategori pilihKategori(
            Scanner scanner,
            Restoran restoran) {

        if (restoran.getDaftarKategori().isEmpty()) {

            System.out.println(
                    ">> Belum ada kategori. "
                    + "Tambahkan kategori terlebih dahulu."
            );

            return null;
        }

        System.out.println("\n=== PILIH KATEGORI ===");

        for (Kategori kategori : restoran.getDaftarKategori()) {

            System.out.println(
                    kategori.getIdKategori()
                    + " - "
                    + kategori.getNamaKategori()
            );
        }

        String idKategori = inputString(
                scanner,
                "ID Kategori: "
        );

        Kategori kategori =
                restoran.cariKategori(idKategori);

        if (kategori == null) {

            System.out.println(
                    ">> Kategori tidak ditemukan"
            );
        }

        return kategori;
    }

    private static String inputString(
            Scanner scanner,
            String pesan) {

        while (true) {

            System.out.print(pesan);

            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println(
                    ">> Input tidak boleh kosong"
            );
        }
    }

    private static int inputPilihan(
            Scanner scanner,
            String pesan,
            int minimum,
            int maksimum) {

        while (true) {

            System.out.print(pesan);

            String input = scanner.nextLine().trim();

            try {

                int pilihan = Integer.parseInt(input);

                if (pilihan >= minimum
                        && pilihan <= maksimum) {

                    return pilihan;
                }

                System.out.println(
                        ">> Pilihan harus antara "
                        + minimum
                        + " dan "
                        + maksimum
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        ">> Input harus berupa angka"
                );
            }
        }
    }

    private static double inputHarga(
            Scanner scanner,
            String pesan) {

        while (true) {

            System.out.print(pesan);

            String input = scanner.nextLine().trim();

            try {

                double harga = Double.parseDouble(input);

                if (harga >= 0) {
                    return harga;
                }

                System.out.println(
                        ">> Harga tidak boleh negatif"
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        ">> Harga harus berupa angka"
                );
            }
        }
    }
}
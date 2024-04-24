import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue queue = new Queue(10);

        while (true) {
            System.out.println("\nMenu Antrian Klinik:");
            System.out.println("1. Tambah Pasien ke Antrian");
            System.out.println("2. Hapus Pasien dari Antrian");
            System.out.println("3. Lihat Pasien Pertama");
            System.out.println("4. Lihat Pasien Terakhir");
            System.out.println("5. Cetak Semua Pasien");
            System.out.println("6. Cari Posisi Pasien");
            System.out.println("7. Keluar");
            System.out.print("Pilih opsi: ");
            int pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama: ");
                    String nama = sc.nextLine();
                    System.out.print("Masukkan no ID: ");
                    int noID = sc.nextInt();
                    System.out.print("Masukkan jenis kelamin (P/L): ");
                    char jenisKelamin = sc.next().charAt(0);
                    System.out.print("Masukkan umur: ");
                    int umur = sc.nextInt();
                    Pasien pasien = new Pasien(nama, noID, jenisKelamin, umur);
                    queue.enqueue(pasien);
                    break;
                case 2:
                    Pasien removedPasien = queue.dequeue();
                    if (removedPasien != null) {
                        System.out.println("Pasien " + removedPasien.getNama() + " telah dihapus dari antrian.");
                    }
                    break;
                case 3:
                    Pasien firstPatient = queue.peek();
                    if (firstPatient != null) {
                        System.out.println("Pasien Pertama: " + firstPatient);
                    }
                    break;
                case 4:
                    Pasien lastPatient = queue.peekRear();
                    if (lastPatient != null) {
                        System.out.println("Pasien Terakhir: " + lastPatient);
                    }
                    break;
                case 5:
                    queue.print();
                    break;
                case 6:
                    System.out.print("Masukkan nama pasien yang dicari: ");
                    String namaCari = sc.nextLine();
                    queue.peekPosition(namaCari);
                    break;
                case 7:
                    System.out.println("Keluar dari program.");
                    sc.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}
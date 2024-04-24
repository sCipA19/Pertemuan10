public class Pasien {
    String nama;
    int noID;
    char jenisKelamin;
    int umur;

    public Pasien(String nama, int noID, char jenisKelamin, int umur) {
        this.nama = nama;
        this.noID = noID;
        this.jenisKelamin = jenisKelamin;
        this.umur = umur;
    }

    public String getNama() {
        return nama;
    }

    public int getNoID() {
        return noID;
    }

    public char getJenisKelamin() {
        return jenisKelamin;
    }

    public int getUmur() {
        return umur;
    }

    public String toString() {
        return "Nama: " + nama + ", No. ID: " + noID + ", Jenis Kelamin: " + jenisKelamin + ", Umur: " + umur;
    }
}

class Queue {
    Pasien[] antrian;
    int front, rear, size, max;

    public Queue(int n) {
        max = n;
        size = 0;
        front = 0;
        rear = -1;
        antrian = new Pasien[max];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == max;
    }

    public void enqueue(Pasien antri) {
        if (!isFull()) {
            rear = (rear + 1) % max;
            antrian[rear] = antri;
            size++;
        } else {
            System.out.println("Antrian sudah penuh!");
        }
    }

    public Pasien dequeue() {
        if (!isEmpty()) {
            Pasien temp = antrian[front];
            front = (front + 1) % max;
            size--;
            return temp;
        } else {
            System.out.println("Antrian kosong!");
            return null;
        }
    }

    public void print() {
        if (!isEmpty()) {
            int i = front;
            while (i != rear) {
                System.out.println(antrian[i]);
                i = (i + 1) % max;
            }
            System.out.println(antrian[rear]);
        } else {
            System.out.println("Antrian kosong!");
        }
    }

    public Pasien peek() {
        if (!isEmpty()) {
            return antrian[front];
        } else {
            System.out.println("Antrian kosong!");
            return null;
        }
    }

    public Pasien peekRear() {
        if (!isEmpty()) {
            return antrian[rear];
        } else {
            System.out.println("Antrian kosong!");
            return null;
        }
    }

    public void peekPosition(String nama) {
        if (!isEmpty()) {
            for (int i = 0; i < size; i++) {
                if (antrian[i].nama.equals(nama)) {
                    System.out.println("Posisi antrian " + nama + " adalah " + (i + 1));
                    return;
                }
            }
            System.out.println(nama + " tidak ditemukan dalam antrian.");
        } else {
            System.out.println("Antrian kosong!");
        }
    }
}
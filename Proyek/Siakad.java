import java.util.*;

import javax.lang.model.element.QualifiedNameable;

public class Siakad {
    static int jumlahData = 0;
    static Mahasiswa[] mahasiswa = new Mahasiswa[1000];

    public static void tambahData() {
        System.out.println("Silahkan tambah data");
        Scanner input = new Scanner(System.in);
        System.out.print("NIM = ");
        long nim = input.nextLong();
        input.nextLine();
        System.out.print("Nama = ");
        String nama = input.nextLine();
        mahasiswa[jumlahData] = new Mahasiswa();
        mahasiswa[jumlahData].setNim(nim);
        mahasiswa[jumlahData].setNama(nama);
        jumlahData++;
    }

    public static void tampilData() {
        System.out.println("Berikut data Anda");
        System.out.println("====================");
        System.out.println("NIM" + "\t" + "\t|| " + "NAMA");
        System.out.println("----------------------------------------");
        int i = 0;
        while (i < jumlahData) {
            System.out.println(mahasiswa[i].getNim() + "\t|| " + mahasiswa[i].getNama());
            System.out.println("----------------------------------------");
            i++;
        }
    }

    public static void cariData() {
        Scanner input = new Scanner(System.in);
        System.out.println("Pilih Algoritma Pencarian : ");
        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search");
        System.out.print("Pilihan : ");
        int cariD = input.nextInt();
        switch (cariD) {
            case 1: {
                System.out.print("Ketik NIM yang ingin anda cari : ");
                long ls = input.nextLong();
                linearSearch(ls);
                break;
            }
            case 2: {
                System.out.print("Ketik NIM yang ingin anda cari : ");
                long bs = input.nextLong();
                binarySearch(bs);
                break;
            }
        }
    }

    public static void linearSearch(long ls) {
        int n = jumlahData;
        for (int i = 0; i < n; i++) {
            if (mahasiswa[i].getNim() == ls) {
                System.out.println("NIM yang anda cari terdapat pada indeks ke-" + (i + 1));
            }
        }
    }

    public static void binarySearch(long bs) {
        int l = 0, r = jumlahData - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            if (mahasiswa[m].getNim() == bs) {
                System.out.println("NIM yang anda cari terdapat pada indeks ke-" + (m + 1));
            }

            if (mahasiswa[m].getNim() < bs) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
    }

    public static void urutkanData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pilih Algoritma Pengurutan : ");
        System.out.println("1. EXCHANGE SORT");
        System.out.println("2. SELECTION SORT");
        System.out.println("3. BUBBLE SORT");
        System.out.println("4. QUICK SORT");
        System.out.println("5. SHELL SORT");
        System.out.print("Pilihan : ");
        int algo = scanner.nextInt();
        switch (algo) {
            case 1: {
                exchangeSort();
                break;
            }
            case 2: {
                selectionSort();
                break;
            }
            case 3: {
                bubbleSort();
                break;
            }
            case 4: {
                quickSort(mahasiswa, 0, jumlahData - 1);
                break;
            }
            case 6: {
                shellSort();
                break;
            }
        }
    }

    public static void exchangeSort() {
        for (int x = 0; x < jumlahData; x++) {
            for (int y = x + 1; y < jumlahData; y++) {
                if (mahasiswa[x].getNim() > mahasiswa[y].getNim()) {
                    Mahasiswa temp = mahasiswa[x];
                    mahasiswa[x] = mahasiswa[y];
                    mahasiswa[y] = temp;
                }
            }
        }
    }

    public static void selectionSort() {
        for (int i = 0; i < jumlahData - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < jumlahData; j++) {
                if (mahasiswa[j].getNim() < mahasiswa[min_index].getNim()) {
                    min_index = j;
                }
                Mahasiswa temp = mahasiswa[min_index];
                mahasiswa[min_index] = mahasiswa[i];
                mahasiswa[i] = temp;
            }
        }
    }

    public static void bubbleSort() {
        for (int i = 0; i < jumlahData - 1; i++) {
            for (int j = 0; j < jumlahData - i - 1; j++) {
                if (mahasiswa[j].getNim() > mahasiswa[j + 1].getNim()) {
                    Mahasiswa temp = mahasiswa[j];
                    mahasiswa[j] = mahasiswa[j + 1];
                    mahasiswa[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(Mahasiswa[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    static int partition(Mahasiswa[] arr, int low, int high) {
        int p = low, j;
        for (j = low + 1; j <= high; j++) {
            if (arr[j].getNim() < arr[low].getNim()) {
                swap(arr, ++p, j);
            }
        }
        swap(arr, low, p);
        return p;
    }

    static void swap(Mahasiswa[] arr, int low, int pivot) {
        Mahasiswa tmp = arr[low];
        arr[low] = arr[pivot];
        arr[pivot] = tmp;
    }

    public static void shellSort() {
        for (int bagi = jumlahData / 2; bagi > 0; bagi /= 2) {
            for (int i = bagi; i < jumlahData; i += 1) {
                Mahasiswa temp = mahasiswa[i];
                int j;
                for (j = i; (j >= bagi) && (mahasiswa[j - bagi].getNim() > temp.getNim()); j -= bagi) {
                    mahasiswa[j] = mahasiswa[j - bagi];
                }
                mahasiswa[j] = temp;
            }
        }
    }

    public static void editData() {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan NIM dari data yang ingin anda edit : ");
        long edit = input.nextLong();
        System.out.println("---------------------------------------------------------------------------");
        for (int i = 0; i < jumlahData; i++) {
            if (mahasiswa[i].getNim() == edit) {
                System.out.print("NIM = ");
                long Enim = input.nextLong();
                input.nextLine();
                System.out.print("Nama = ");
                String Enama = input.nextLine();
                mahasiswa[i].setNim(Enim);
                mahasiswa[i].setNama(Enama);
            }
        }
    }

    public static void hapusData() {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan NIM dari data yang ingin anda hapus : ");
        long del = input.nextLong();
        for (int i = 0; i < jumlahData; i++) {
            if (mahasiswa[i].getNim() == del) {
                System.out.println("---------------------------------------------------------------------------");
                System.out.println("Mahasiswa yang anda hapus adalah " + mahasiswa[i].getNama() + "\ndengan nim "
                        + mahasiswa[i].getNim());
                mahasiswa[i] = mahasiswa[i + 1];
            }
        }
        jumlahData--;
    }

    public static void UAS() {
        if (jumlahData == 0) {
            System.out.println("Tidak ada data");
        } else {
            int jarak = jumlahData;
            int susut = 13;
            int urut = 0;

            while (urut == 0) {
                jarak = (jarak * 10) / susut;
                if (jarak <= 1) {
                    jarak = 1;
                    urut = 1;
                }
                for (int i = 0; (i + jarak) < jumlahData; i++) {
                    if (mahasiswa[i].getNim() > mahasiswa[i + jarak].getNim()) {
                        Mahasiswa temp = mahasiswa[i];
                        mahasiswa[i] = mahasiswa[i + jarak];
                        mahasiswa[i + jarak] = temp;
                        urut = 0;
                    }
                }
            }
            System.out.println("Data telah diurutkan. Silahkan tampilkan data");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int menu;
        do {
            System.out.println("====================");
            System.out.println("Menu Siakad");
            System.out.println("====================");
            System.out.println("1. Tambah Data");
            System.out.println("2. Lihat Data");
            System.out.println("3. Urutkan Data");
            System.out.println("4. Cari Data");
            System.out.println("5. Edit Data");
            System.out.println("6. Hapus Data");
            System.out.println("7. UAS");
            System.out.println("8. Keluar");
            System.out.println("====================");
            System.out.print("Pilih menu = ");
            menu = input.nextInt();
            System.out.println("====================");
            if (menu == 1) {
                tambahData();
            } else if (menu == 2) {
                tampilData();
            } else if (menu == 3) {
                urutkanData();
            } else if (menu == 4) {
                cariData();
            } else if (menu == 5) {
                editData();
            } else if (menu == 6) {
                hapusData();
            } else if (menu == 7) {
                UAS();
            }
        } while (menu != 8);
    }
}

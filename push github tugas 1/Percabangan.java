import java.util.Scanner;
    public class Percabangan {
        public static void main (String[] args) {
            Scanner masukkan = new Scanner(System.in);
            String nama,keterangan;
            int nilai;

            System.out.println("Masukkan Nama : ");
            nama = masukkan.next();
            System.out.println("Masukkan Nilai : ");
            nilai = masukkan.nextInt();

            if (nilai >= 60){
                keterangan ="Lulus";
            } else {
                keterangan = "Tidak lulus";
            }
            System.out.println(nama + " " + keterangan);
        }
        }
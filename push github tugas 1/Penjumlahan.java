import java.util.Scanner;
    public class Penjumlahan {
        public static void main (String[] args) {
            Scanner masukkan = new Scanner(System.in);
            int x;
			int y;

            Scanner scan = new Scanner(System.in);
			System.out.print("Masukkan nilai x = ");
			x = scan.nextInt();
			System.out.print("Masukkan nilai y = ");
			y = scan.nextInt();
			int hasil = x + y;
			System.out.println("Hasil penjumlahan x + y ="+hasil);
		
			
        }
        }
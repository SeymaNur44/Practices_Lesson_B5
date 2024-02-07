package Gun_10;

import java.util.ArrayList;
import java.util.Scanner;

public class _2D_ArrayList_Soru {
    public static void main(String[] args) {
/*
        - Sinema Salonu Oluşturma:
        Kullanıcıdan sinema salonundaki satır ve koltuk sayılarını alın.
        İki boyutlu bir ArrayList kullanarak sinema salonunu temsil edin.
        İlk başta tüm koltukları boş (rezerve edilmemiş) olarak ayarlayın.

        - Ana Menü ve Kullanıcı İşlemleri:
        Kullanıcıya gösterilecek bir ana menü oluşturun.
        Kullanıcı, sinema salonunu görmek, koltuk rezervasyonu yapmak veya programdan çıkmak gibi seçenekleri seçebilmelidir.

        - Sinema Salonunu Gösterme:
        Sinema salonunu ekrana yazdırmak için bir fonksiyon oluşturun.
        Her satır ve koltuğu döngüler kullanarak gezin ve rezerve edilmiş koltukları "X" ile, boş koltukları "O" ile gösterin.

        - Koltuk Rezervasyonu Yapma:
        Kullanıcıdan rezervasyon yapmak istediği koltuğun satır ve sütun bilgilerini alın.
        Girilen satır ve sütun bilgilerini kontrol ederek geçerli bir koltuk olup olmadığını kontrol edin.
        Eğer koltuk geçerliyse, bu koltuğun rezerve edilip edilmediğini kontrol edin.
        Koltuk rezerve edilmemişse, rezervasyonu tamamlayın ve kullanıcıya başarılı bir rezervasyon yapıldığını bildirin.
        Koltuk zaten rezerve edilmişse, kullanıcıya hata mesajı gösterin.
        Geçersiz bir satır veya sütun numarası girilirse, kullanıcıya hata mesajı gösterin.

        - Program Kontrolü:
        Kullanıcı çıkış yapana kadar programın çalışmasını sağlayan bir kontrol mekanizması ekleyin.*/

        Scanner scanner = new Scanner(System.in);
        ArrayList<ArrayList<Boolean>> cinemaHall = creatCinemeHall(5, 7);
        boolean continueReservations = true;
        while (continueReservations) {
            printMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    prtintCinemeHall(cinemaHall);
                    break;
                case 2:
                    rezerveSeat(cinemaHall);
                    break;
                case 3:
                    continueReservations = false;
                    break;
                default:
                    System.out.println(" Geçersiz Seçim yaptınız. Lütfen tekrar deneyiniz.");
            }
        }
        System.out.println("Programdan çıkılıyor. İyi seyirler.");
    }

    public static void printMenu() {
        System.out.println("\n---- Ana Menü ---");
        System.out.println("1. Sinama Salonunu Göster");
        System.out.println("2. Koltuk rezarvasyonu yap");
        System.out.println("3. Çıkış");
        System.out.print("Bir işlem seçin : ");
    }

    public static void rezerveSeat(ArrayList<ArrayList<Boolean>> cinemaHall) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("\n Rezervasyon yapmak istediğiniz koltuğun satırını girin : ");
        int row = scanner.nextInt() - 1;
        System.out.print("\n Rezervasyon yapmak istediğiniz koltuğun sütünunu girin : ");
        int column = scanner.nextInt() - 1;

        if (isValidSeat(cinemaHall, row, column)) {
            if (!cinemaHall.get(row).get(column)) {
                cinemaHall.get(row).set(column, true);
                System.out.println("Rezarvasyonunuz başarıyla tamamlandı!");
            } else {
                System.out.println("Bu koltuk zaten rezerve dilmiş. Lütfen başka bir koltuk seçiniz.");
            }

        } else {
            System.out.println("Geçersiz satır veya sütün numarası. Lütfen geçerli bir koltuk seçin.");
        }
    }

    public static boolean isValidSeat(ArrayList<ArrayList<Boolean>> cinemaHall, int row, int column) {

        return row >= 0 && row < cinemaHall.size() && column >= 0 && column < cinemaHall.get(0).size();
    }

    public static ArrayList<ArrayList<Boolean>> creatCinemeHall(int rows, int columns) {

        ArrayList<ArrayList<Boolean>> cinemeHall = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            ArrayList<Boolean> row = new ArrayList<>();
            for (int j = 0; j < columns; j++) {
                row.add(false);
            }
            cinemeHall.add(row);

        }
        return cinemeHall;
    }

    public static void prtintCinemeHall(ArrayList<ArrayList<Boolean>> cinemeHall) {

        System.out.println("\nCinema Hall");

        for (ArrayList<Boolean> row : cinemeHall) {
            for (boolean isReverved : row) {
                if (isReverved) {
                    System.out.print("X ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
}

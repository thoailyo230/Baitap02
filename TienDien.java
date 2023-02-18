package lab2;

import java.util.Scanner;

public class TienDien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so dien su dung trong thang: ");
        int soDien = sc.nextInt();
        int tien;
        if (soDien <= 50) {
            tien = soDien * 1000;
        } else {
            tien = 50 * 1000 + (soDien - 50) * 1200;
        }
        System.out.println("So tien phai tra: " + tien + " VND");
    }
}

package lab2;

import java.util.Scanner;

public class PhuongTrinhBacHai {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap vao so a: ");
        double a = input.nextDouble();

        System.out.println("Nhap vao so b: ");
        double b = input.nextDouble();

        System.out.println("Nhap vao so c: ");
        double c = input.nextDouble();

        double delta = Math.pow(b, 2) - 4 * a * c;
        double x1, x2;

        if (delta > 0) {
            x1 = (-b + Math.sqrt(delta)) / (2 * a);
            x2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("Phuong trinh co hai nghiem la  " + x1 + " và " + x2);
        } else if (delta == 0) {
            x1 = (-b) / (2 * a);
            System.out.println("Phuong trinh co mot nghiem kep la " + x1);
        } else {
            System.out.println("Phuong trinh vo nghiem");
        }
    }
}

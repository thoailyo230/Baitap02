package lab2;

import java.util.Scanner;

public class BaiTapGiaiPhuongTrinhBacHai {
   public static void main(String[] args) {
       try (Scanner scanner = new Scanner(System.in)) {
           System.out.print("nhap so a: ");
           double a = scanner.nextDouble();
           System.out.print("nhap so b: ");
           double b = scanner.nextDouble();
           
           System.out.print("nhap so  c: ");
           double c = scanner.nextDouble();
           
           if (a == 0) {
               // Giải phương trình bậc nhất
               if (b == 0) {
                   if (c == 0) {
                       System.out.println("phuong trinh vo so nghiem");
                   } else {
                       System.out.println("phuong trinh vo nghiem.");
                   }
               } else {
                   double x = -c / b;
                   System.out.println("Nghiem cua phuong trinh la  x = " + x);
               }
           } else {
               double delta = b * b - 4 * a * c;
               
               if (delta < 0) {
                   System.out.println("Phuong trinh vo nghiem.");
               } else if (delta == 0) {
                   double x = -b / (2 * a);
                   System.out.println("Phuong trinh co nghiem kep x = " + x);
               } else {
                   double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                   double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                   System.out.println("Phuong trinh co hai nghiem phan biet:");
                   System.out.println("x1 = " + x1);
                   System.out.println("x2 = " + x2);
               }
           }}
   }
}

package lab2;

import java.util.Scanner;

public class KTSoChinhPhuong {

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap 1 so can kiem tra: ");
        int n = scanner.nextInt();
        if (check(n) == true ){
            System.out.println("day la so chinh phuong ");
        }
        else {
            System.out.println("day khong phai la so chinh phuong ");
        }
    
    }

    private static boolean check(int n) {
        int m = (int)Math.sqrt(n);
        return m*m == n;
    }

}

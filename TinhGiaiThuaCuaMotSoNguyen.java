package lab2;

import java.util.Scanner;

public class TinhGiaiThuaCuaMotSoNguyen {
    public static void main(String[] args) {
        // Nhập số nguyên dương n
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap vao mot so nguyen duong: ");
        int n = scanner.nextInt();

        // Tính giai thừa của n
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }

        // In kết quả
        System.out.println(n + "! = " + factorial);
    }
}

package lab2;

import java.util.Scanner;

public class MaTran {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Nhập số đỉnh của đồ thị
        System.out.print("Nhap so dinh cua do thi: ");
        int n = scanner.nextInt();
        
        // Nhập ma trận đối xứng
        int[][] a = new int[n][n];
        System.out.println("Nhap ma tran doi xung: ");
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                System.out.print("a[" + i + "][" + j + "] = ");
                a[i][j] = scanner.nextInt();
                a[j][i] = a[i][j];
            }
        }
        
        // Xuất ma trận đối xứng
        System.out.println("Ma tran doi xung: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}

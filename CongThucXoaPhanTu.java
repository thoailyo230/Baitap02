package lab2;

import java.util.Arrays;

public class CongThucXoaPhanTu {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int x = 5;
        int n = a.length;
        
        // Duyệt qua mảng và xóa các phần tử có giá trị bằng x
        for (int i = 0; i < n; i++) {
            if (a[i] == x) {
                for (int j = i; j < n - 1; j++) {
                    a[j] = a[j + 1];
                }
                n--;
                i--;
            }
        }
        
        // Sắp xếp mảng tăng dần
        Arrays.sort(a, 0, n);
        
        // Xuất mảng sau khi xóa phần tử có giá trị x và sắp xếp tăng dần
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }
}

package lab2;

import java.util.Scanner;

public class XepLoaiHocTap {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Nhap diem cua hoc sinh: ");
        double diem = input.nextDouble();

        String xepLoai = "";
        if (diem < 5.0) {
            xepLoai = "Kem";
        } else if (diem < 7.0) {
            xepLoai = "Trung binh";
        } else if (diem < 8.0) {
            xepLoai = "Kha";
        } else {
            xepLoai = "Gioi";
        }

        System.out.println("Hoc sinh duoc xep loai: " + xepLoai);
    }
}

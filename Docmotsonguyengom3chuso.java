package lab2;

import java.util.Scanner;

public class doc1songuyengom3chuso {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Nhap so nguyen gom ba chu so: ");
        int number = input.nextInt();

        int firstDigit = number / 100;
        int secondDigit = (number % 100) / 10;
        int thirdDigit = number % 10;

        String[] digitNames = {"khong", "mot", "hai", "ba", "bon", "nam", "sau", "bay", "tam", "chin"};

        System.out.println(digitNames[firstDigit] + " tram " + digitNames[secondDigit] + " muoi " + digitNames[thirdDigit]);
    }
}

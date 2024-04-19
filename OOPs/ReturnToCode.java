package OOPs;

import java.util.Scanner;

public class ReturnToCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Input 1 interger: " + n);
        if (n == 1) {
            System.out.println("Happy New Year");
            return;
        }
        else {
            System.out.println("Best wishes for you");
            return;
        }
    }
}

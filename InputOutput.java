import java.util.Scanner;

public class InputOutput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời nhập một số nguyên!");
        int x = scanner.nextInt();
        System.out.println("Số nguyên vừa nhập là: " + x);
    }
}

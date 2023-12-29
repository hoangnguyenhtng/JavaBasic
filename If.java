import java.util.Scanner;

public class If {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = Integer.parseInt(scanner.nextLine());
        if (x == 0) {
            System.out.println("x không âm cũng không dương");
        } else if (x > 0) {
            System.out.println("x là số dương");
        } else {
            System.out.println("x là số âm");
        }
    }
}

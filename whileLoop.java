import java.util.Scanner;

public class whileLoop {
    //while(condition){ ...}
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while(n < 10){
            System.out.println(n);
            n++;
        }
    }
}

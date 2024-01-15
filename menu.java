import java.util.Scanner;

/**
 * menu
 */
public class menu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Menu các món trong nhà hàng!");
        System.out.println("1. Phở");
        System.out.println("2. Cá kho");
        System.out.println("3. Cá chiên");
        System.out.println("4. Hoa quả");
        int x = Integer.parseInt(sc.nextLine());
        double n = Double.parseDouble(sc.nextLine()) ;
        double m = x;
        switch (x) {
            case 1:
                System.out.println("Phục vụ Phở");
                break;
            case 2:
                System.out.println("Phục vụ cá kho");
                break;
            case 3:
                System.out.println("Phục vụ cá chiên");
                break;
            case 4:
                System.out.println("Phục vụ hoa quả");
                break;
            default:
                System.err.println("Mời chọn các món có trong menu");
                break;
        }
    }
}
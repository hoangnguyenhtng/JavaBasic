public class checkNguyenTo {
    // So nguyen to la so lon hon 1 va chi chia het cho 1 va chinh no
    public static void main(String[] args) {
        System.out.println("Các số nguyên tố nhỏ hơn 100 là:");
        for (int i = 0; i < 100 ; i++) {
            if(isPrimeNumber(i)){
                System.out.print(i + " ");
            }
        }
    }

    public static boolean isPrimeNumber(int n){
        //so nguyen n < 2 khong phai la so nguyen to
        if(n < 2){
            return false;
        }

        //check so nguyen to khi n >= 2
        int canBac = (int)Math.sqrt(n);
        for (int i = 2; i <= canBac; i++) {
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }
}

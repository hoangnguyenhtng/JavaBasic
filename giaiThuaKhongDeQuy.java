public class giaiThuaKhongDeQuy {
    public static void main(String[] args) {
        int a = 5;
        int b = 0;
        int c = 10;

        System.out.println("Giai thừa của " + a + " là: "
                + giaiThuaKhongDeQuy.tinhGiaiThua(a));
    }

    public static long tinhGiaiThua(int n){
        long giaithua = 1;
        if(n == 0||n == 1){
            return giaithua;
        } else{
            for (int i = 2; i <= n; i++){
                giaithua *= i;
        }
        return giaithua;
    }
    }
}

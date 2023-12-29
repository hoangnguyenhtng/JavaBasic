public class giaiThuaDeQuy {
    public static void main(String[] args) {
        int a = 5;
        System.out.println("Giai thua cua " + a + " la " + giaiThuaDeQuy.tinhGiaiThua(a));
    }

    public static long tinhGiaiThua(int n){
        if(n > 0){
            return tinhGiaiThua(n-1) * n;
        }
        else{
            return 1;
        }
    }
}

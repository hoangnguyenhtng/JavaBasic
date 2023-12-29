public class continueFunc {
    public static void main(String[] args) {
        for(int i = 0; i <= 10; i++){
            if(i == 5){
                continue;
            }
            // Khi i = 5 thi khong in i = 5 ra man hinh
            System.out.println(i);
        }
    }
}

public class forWithLabel {
    public static void main(String[] args) {
        aa : for(int i = 0; i < 10; i++) {
            bb : for(int j = 0; j < 10; j++) {
                if(i == 2 && j == 2){
                    break aa;
                }
                System.out.println(i + " " + j);
            }
        }
    }
}

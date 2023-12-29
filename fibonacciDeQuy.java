public class fibonacciDeQuy {
    public static void main(String[] args) {
        System.out.println("10 so dau tien cua day fibonacci: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }

    public static int fibonacci(int n){
        if(n < 0){
            return -1;
        } else if(n == 0 || n == 1){
            return n;
        } else{
            return fibonacci(n-1) + fibonacci(n - 2);
        }
    }
}

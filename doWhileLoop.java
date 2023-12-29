public class doWhileLoop {
    // do
    // {
    //     // Khối lệnh được thực thi
    // }while(condition);

    public static void main(String[] args) {
        int a = 1, sum = 0;
        do{
            sum += a;
            a++; 
        } while(a <= 5 );
        System.out.println("Tong tu 1 den 5 la " + sum);
    }
}

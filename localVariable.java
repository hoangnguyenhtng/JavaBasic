public class localVariable {
    public void sayHello(){
        int n = 10; //Đây là biến local
        System.out.println("Giá trị của n là: " + n);

    }
    public static void main(String[] args) {
        localVariable bienLocal = new localVariable();
        bienLocal.sayHello();
    }
}

public class narrowing {
    public static void main(String[] args) {
        double d = 100.04;
        long l = (long)d;
        int i = (int)l;
        System.out.println(d);
        System.out.println(l);
        System.out.println(i);
    }
}

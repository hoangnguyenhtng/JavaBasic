public class classLoader {
    public static void main(String[] args) {
        // Let's print the classloader name of current class.
        // Application/System classloader will load this class
        Class c = ClassLoader.class;
        System.out.println(c.getClassLoader());
        System.out.println(String.class.getClassLoader());
    }
}

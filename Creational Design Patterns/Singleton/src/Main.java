public class Main {
    public static void main(String[] args) {
        SingleObject instance = SingleObject.getInstance();
        instance.showMessage();
        System.out.println("Hello world!");
    }
}
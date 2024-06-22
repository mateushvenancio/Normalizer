import Normalizer.Normalizer;

public class MainApp {
    public static void main(String[] args) {
        Normalizer normalizer = new Normalizer("Jaccard");

        String result = normalizer.normalize("Java engineer");

        System.out.println("Result: " + result);
    }
}

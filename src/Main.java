import frontend.HomeScreen;
import frontend.WindowFrame;

public class Main {
    public static void main(String[] args) throws Exception {
        WindowFrame window = new WindowFrame();
        HomeScreen home = new HomeScreen(window);
        home.DrawScreen();
    }
}

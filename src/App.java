import proccess.ProccessHelper;
import screen.main.MainScreen;

import java.util.ArrayList;
import java.util.List;

import model.Product;

public class App {
    public static void main(String[] args) throws Exception {
        List<Product> products = new ArrayList<Product>();
        MainScreen screen = new MainScreen();
        
        screen.showScreen(products);
        ProccessHelper.cls();
    }
}

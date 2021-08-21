package screen.product;

import java.util.List;

import model.Product;
import proccess.ProccessHelper;
import screen.Screen;

public class ProductReportScreen extends Screen {
    String repeat = "s";

    @Override
    public void showScreen(List<Product> products) {
        do {
            super.showScreen(products);

            for (Product product : products) {
                readProduct(product);
            }
            
            repeat = getYesNoOption("REPETIR OPERAÇÃO (S/N)?");
            ProccessHelper.cls();
        } while (repeat.toLowerCase().equals("s"));
    }

    private void readProduct(Product product) {
        ProccessHelper.write("NOME: " + product.getName());
        ProccessHelper.write("PREÇO: " + product.getPrice());
        ProccessHelper.write("UNIDADE: " + product.getUnit());
        ProccessHelper.write("QUANTIDADE: " + product.getQuantity() + "\n");
    }
}

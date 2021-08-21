package screen.product;

import java.util.List;

import model.Product;
import proccess.ProccessHelper;
import screen.Screen;

public class ProductPriceReadjustmentScreen extends Screen {
    String repeat = "s";
    String confirm = "n";

    Product product;

    double actualPrice;
    double newPrice;
    double pricePercentage;

    @Override
    public void showScreen(List<Product> products) {
        do {
            super.showScreen(products);

            product = getProduct(products);
            actualPrice = product.getPrice();

            ProccessHelper.write("PREÇO ATUAL: " + actualPrice);
            ProccessHelper.write("AUMENTO DE PREÇO (%):");
            pricePercentage = scanDouble();

            newPrice = actualPrice + (pricePercentage * actualPrice / 100);

            ProccessHelper.write("PREÇO FINAL: " + newPrice);

            confirm = getYesNoOption("CONFIRMA O REAJUSTE (S/N)?");

            if (confirm.toLowerCase().equals("s")) {
                product.setPrice(newPrice);
            }

            repeat = getYesNoOption("REPETIR OPERAÇÃO (S/N)?");
            ProccessHelper.cls();
        } while (repeat.toLowerCase().equals("s"));
    }
}
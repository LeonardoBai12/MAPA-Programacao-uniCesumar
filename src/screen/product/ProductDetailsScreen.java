package screen.product;

import constants.CrudConstants;
import java.util.List;

import model.Product;
import proccess.ProccessHelper;
import screen.Screen;

public class ProductDetailsScreen extends Screen {
    String repeat = "s";
    String confirm = "n";
    String type;

    Product product;
    
    String name;
    double price;
    String unit;
    double quantity;

    @Override
    public void showScreen(List<Product> products) {

        do {
            super.showScreen(products);

            if (!type.equals(CrudConstants.CREATE)) {
                product = getProduct(products);
                name = product.getName();
                price = product.getPrice();
                unit = product.getUnit();
                quantity = product.getQuantity();
            } else {
                product = new Product();
            }

            ProccessHelper.write(type + " DE PRODUTO ");

            if (type.equals(CrudConstants.READ) || type.equals(CrudConstants.DELETE)) {
                readProduct();
            } else {
                scanProduct();
            }

            if (!type.equals(CrudConstants.READ)) {
                confirm = getYesNoOption("CONFIRMA A " + type + " (S/N)?");
            }

            if (confirm.toLowerCase().equals("s")) {
                crudProduct(products, product);
            }

            if (type.equals(CrudConstants.DELETE) && products.isEmpty()) {
                repeat = "n";
            } else {
                repeat = getYesNoOption("REPETIR OPERAÇÃO (S/N)?");
            }

            ProccessHelper.cls();
        } while (repeat.toLowerCase().equals("s"));

    }

    private void scanProduct() {

        if (type.equals(CrudConstants.CREATE)) {
            ProccessHelper.write("NOME:");
            name = scan.next();
        } else {
            ProccessHelper.write("NOME: " + name);
        }

        ProccessHelper.write("PREÇO:");
        price = scanDouble();
        ProccessHelper.write("UNIDADE:");
        unit = scan.next();
        ProccessHelper.write("QUANTIDADE:");
        quantity = scanDouble();
    }

    private void readProduct() {
        ProccessHelper.write("NOME: " + name);
        ProccessHelper.write("PREÇO: " + price);
        ProccessHelper.write("UNIDADE: " + unit);
        ProccessHelper.write("QUANTIDADE: " + quantity);
    }

    private void crudProduct(List<Product> products, Product product) {
        product.setName(name);
        product.setPrice(price);
        product.setUnit(unit);
        product.setQuantity(quantity);

        if (type.equals(CrudConstants.CREATE)) {
            products.add(product);
        } else if (type.equals(CrudConstants.DELETE)) {
            products.remove(product);
        }
    }
}

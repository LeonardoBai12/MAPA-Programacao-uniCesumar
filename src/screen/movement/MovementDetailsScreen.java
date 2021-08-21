package screen.movement;

import java.util.List;

import constants.EntryConstants;
import model.Product;
import proccess.ProccessHelper;
import screen.Screen;

public class MovementDetailsScreen extends Screen {
    String repeat = "s";
    String confirm = "n";
    String type;

    Product product;

    double actualQuantity;
    double newQuantity;
    double entryOrExit;

    @Override
    public void showScreen(List<Product> products) {
        
        do {
            super.showScreen(products);
            
            ProccessHelper.write("MOVIMENTAÇÃO - " + type + " DE PRODUTO");
            product = getProduct(products);

            actualQuantity = product.getQuantity();

            ProccessHelper.write("QTDE ATUAL:" + actualQuantity);
            ProccessHelper.write("QTDE " + type + ":");
            entryOrExit = scanDouble();

            if (type.equals(EntryConstants.ENTRY)) {
                newQuantity = actualQuantity + entryOrExit;
            } else {
                newQuantity = actualQuantity - entryOrExit;
            }

            ProccessHelper.write("QTDE FINAL: " + newQuantity);

            confirm = getYesNoOption("CONFIRMA ENTRADA (S/N)?");

            if (confirm.toLowerCase().equals("s")) {
                product.setQuantity(newQuantity);
            }

            repeat = getYesNoOption("REPETIR OPERAÇÃO (S/N)?");
            ProccessHelper.cls();
        } while (repeat.toLowerCase().equals("s"));

    }
}

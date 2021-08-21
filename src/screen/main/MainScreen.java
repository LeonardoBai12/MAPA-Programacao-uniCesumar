package screen.main;

import java.util.List;

import model.Product;
import proccess.ProccessHelper;
import screen.Screen;
import screen.movement.MovementScreen;
import screen.product.ProductCrudScreen;
import screen.product.ProductPriceReadjustmentScreen;
import screen.product.ProductReportScreen;

public class MainScreen extends Screen {
    int max = 4;
    int i;

    @Override
    public void showScreen(List<Product> products) {

        do {
            super.showScreen(products);
            ProccessHelper.write("MENU PRINCIPAL");
            ProccessHelper.write("1 - CADASTRO DE PRODUTOS");
            ProccessHelper.write("2 - MOVIMENTAÇÃO");
            ProccessHelper.write("3 - REAJUSTE DE PREÇOS");
            ProccessHelper.write("4 - RELATÓRIOS");
            ProccessHelper.write("0 - FINALIZAR");

            if (products.isEmpty()) {
                max = 1;
            } else {
                max = 4;
            }

            i = getNumericalOption(max, "\nOpção inexistente ou inacessível por não existirem produtos!");
            ProccessHelper.cls();

            if (i == 1) {
                ProductCrudScreen productScreen = new ProductCrudScreen();
                productScreen.showScreen(products);
            } else if (i == 2) {
                MovementScreen movementScreen = new MovementScreen();
                movementScreen.showScreen(products);
            } else if (i == 3) {
                ProductPriceReadjustmentScreen productPriceReadjustmentScreen = new ProductPriceReadjustmentScreen();
                productPriceReadjustmentScreen.showScreen(products);
            } else if (i == 4) {
                ProductReportScreen productReportScreen = new ProductReportScreen();
                productReportScreen.showScreen(products);
            }
        } while (i != 0);

    }
}

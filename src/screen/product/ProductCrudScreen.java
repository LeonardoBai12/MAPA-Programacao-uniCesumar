package screen.product;

import java.util.List;

import constants.CrudConstants;
import model.Product;
import proccess.ProccessHelper;
import screen.Screen;

public class ProductCrudScreen extends Screen {
    int max = 4;
    int i;

    @Override
    public void showScreen(List<Product> products) {

        do {
            super.showScreen(products);
            ProccessHelper.write("CADASTRO DE PRODUTOS");
            ProccessHelper.write("1 - INCLUSÃO");
            ProccessHelper.write("2 - ALTERAÇÃO");
            ProccessHelper.write("3 - CONSULTA");
            ProccessHelper.write("4 - EXCLUSÃO");
            ProccessHelper.write("0 - RETORNAR");

            if (products.isEmpty()) {
                max = 1;
            } else {
                max = 4;
            }

            i = getNumericalOption(max, "Opção inexistente ou inacessível por não existirem produtos!");
            ProccessHelper.cls();

            ProductDetailsScreen productDetailsScreen = new ProductDetailsScreen();

            if (i == 1) {
                productDetailsScreen.type = CrudConstants.CREATE;
            } else if (i == 2) {
                productDetailsScreen.type = CrudConstants.UPDATE;
            } else if (i == 3) {
                productDetailsScreen.type = CrudConstants.READ;
            } else if (i == 4) {
                productDetailsScreen.type = CrudConstants.DELETE;
            } else {
                return;
            }

            productDetailsScreen.showScreen(products);
        } while (i != 0);
    }
}

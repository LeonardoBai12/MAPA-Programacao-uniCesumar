package screen.movement;

import java.util.List;

import constants.EntryConstants;
import model.Product;
import proccess.ProccessHelper;
import screen.Screen;

public class MovementScreen extends Screen {
    int max = 2;
    int i;

    @Override
    public void showScreen(List<Product> products) {
        do {
            super.showScreen(products);
            ProccessHelper.write("MOVIMENTAÇÃO");
            ProccessHelper.write("1 - ENTRADA");
            ProccessHelper.write("2 - SAÍDA");
            ProccessHelper.write("0 - RETORNAR");

            i = getNumericalOption(max, null);

            MovementDetailsScreen movementDetailsScreen = new MovementDetailsScreen();

            if (i == 1) {
                movementDetailsScreen.type = EntryConstants.ENTRY;
            } else if (i == 2) {
                movementDetailsScreen.type = EntryConstants.EXIT;
            } else {
                return;
            }

            movementDetailsScreen.showScreen(products);
            ProccessHelper.cls();
        } while (i != 0);
    }
}

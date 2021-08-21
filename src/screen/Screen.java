package screen;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List;

import model.Product;
import proccess.ProccessHelper;

public abstract class Screen {
    protected Scanner scan = new Scanner(System.in);

    public void showScreen(List<Product> products) {
        ProccessHelper.write("EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA.");
        ProccessHelper.write("SISTEMA DE CONTROLE DE ESTOQUE\n");
    }

    protected Product getProduct(List<Product> products) {
        boolean found = false;
        String productName;
        Product product;

        ProccessHelper.write("DIGITE O NOME DO PRODUTO: ");

        do {
            productName = scan.next();

            for (Product p : products) {
                if (p.getName().toLowerCase().contains(productName.toLowerCase())) {
                    product = p;
                    found = true;
                    return product;
                } 
                
                if (products.get(products.size() - 1) == p && !found){
                    ProccessHelper.write("PRODUTO INEXISTENTE!");
                    ProccessHelper.write("DIGITE O NOME DO PRODUTO: ");
                }
            }
        } while (!found);

        return null;
    }

    protected int getNumericalOption(int max, String error) {
        int i;

        do {
            i = scanInt();
        } while (!validateNumericalOption(i, max, error));

        return i;
    }

    protected String getYesNoOption(String text) {
        String s;

        do {
            ProccessHelper.write(text);
            s = scan.next();
            scan.nextLine();
        } while (!validateYesNoOption(s));

        return s;
    }

    protected int scanInt() {
        int value = -1;

        do {
            try {
                ProccessHelper.write("OPÇÃO:");
                value = scan.nextInt();

                if (value < 0) {
                    ProccessHelper.write("Não são permitidos valores negativos.");
                }
            } catch (InputMismatchException e) {
                ProccessHelper.write("Ops... você digitou caracteres. Digite apenas números inteiros.");
            }
            scan.nextLine();
        } while (value < 0);

        return value;
    }

    protected double scanDouble() {
        double value = -1;

        do {
            try {
                value = scan.nextDouble();

                if (value < 0) {
                    ProccessHelper.write("Não são permitidos valores negativos.");
                }
            } catch (InputMismatchException e) {
                ProccessHelper.write("Ops... você digitou caracteres. Digite apenas números.");
            }
            scan.nextLine();
        } while (value < 0);

        return value;
    }

    boolean validateNumericalOption(int i, int max, String error) {
        if (error == null) {
            error = "Opção inexistente!";
        }

        if (i > max || i < 0) {
            ProccessHelper.write(error);
            return false;
        }
        return i == 0 || i <= max;
    }

    boolean validateYesNoOption(String s) {
        return s.toLowerCase().equals("n") || s.toLowerCase().equals("s");
    }
}

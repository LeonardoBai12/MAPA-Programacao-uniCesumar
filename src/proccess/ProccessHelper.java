package proccess;

import java.io.IOException;

public class ProccessHelper {
    private static void clear() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    public static void cls() {
        try {
            clear();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void write(String text){
        System.out.println(text);
    }
}
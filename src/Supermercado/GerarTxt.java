package Supermercado;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GerarTxt {

    String path = "C:\\compra.txt";

    public GerarTxt(ArrayList<String> itemLista) {
        ProcessarTexto(itemLista);
    }

    public void ProcessarTexto(ArrayList<String> itemLista) {
        try (
                BufferedWriter buffer = new BufferedWriter(new FileWriter(path, true))) {
            for (String itemL : itemLista) {
                buffer.write(itemL);
                buffer.newLine();
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}

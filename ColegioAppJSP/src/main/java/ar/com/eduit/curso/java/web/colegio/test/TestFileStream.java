package ar.com.eduit.curso.java.web.colegio.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Comparator;

public class TestFileStream {
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new FileReader("colores.txt"))) {
            // Lectura del fichero
            // String linea;
            // while ((linea = in.readLine()) != null) {
            //     System.out.println(linea);
            // }

            //in.lines().forEach(System.out::println);
            //in.lines().sorted().forEach(System.out::println);
            //in.lines().sorted(Comparator.reverseOrder()).forEach(System.out::println);
            in.lines().filter(c->c.toLowerCase().startsWith("a")).forEach(System.out::println);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

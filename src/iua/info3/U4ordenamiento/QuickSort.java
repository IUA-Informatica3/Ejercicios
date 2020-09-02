package iua.info3.U4ordenamiento;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.util.*;
import java.util.zip.GZIPInputStream;

class Main {

    public static void main(String[] args) {
        List<String> result = new ArrayList();
        String file = "es.txt.gz";
        try {
            GZIPInputStream gzip = new GZIPInputStream(new FileInputStream(file));
            BufferedReader br = new BufferedReader(new InputStreamReader(gzip));
            String line;
            while ((line = br.readLine()) != null) {
                result.add(line);
            }
        } catch (Exception e) {
            System.out.println("NDeah");
        }

        long startTime = System.nanoTime();
        quicksort(result, 0, result.size() - 1);
        long stopTime = System.nanoTime();

        for (String item : result)
            System.out.println(item);
        System.out.println();

        System.out.println("Tiempo: " + (stopTime - startTime) / 1000000.0 + " ms");

    }

    static void quicksort(List<String> shaggy, int primero, int ultimo) {
        int i, j;
        String aux;
        i = primero;
        j = ultimo;

// Negativo si s1 > s2
// Positivo si s1 < s2
// Cero si s1 == s2
        do {
            while (shaggy.get(j).compareToIgnoreCase(shaggy.get(i)) < 0 && j > i) {
                j--;
            }
            if (j > i) {
                aux = shaggy.get(j);
                shaggy.set(j, shaggy.get(i));
                shaggy.set(i, aux);
                i++;
            }

            while (shaggy.get(i).compareToIgnoreCase(shaggy.get(j)) > 0 && j > i) {
                i++;
            }
            if (j > i) {
                aux = shaggy.get(j);
                shaggy.set(j, shaggy.get(i));
                shaggy.set(i, aux);
                j--;
            }

        } while (i < j);

        if (primero < j)
            quicksort(shaggy, primero, j - 1);

        if (ultimo > i)
            quicksort(shaggy, i + 1, ultimo);
    }

}
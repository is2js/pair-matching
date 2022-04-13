package pairmatching.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    public static List<String> readFrom(final String pathname) {
        final File file = new File(pathname);
        final List<String> crews = new ArrayList<>();
        try {
            final Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                crews.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }

        return crews;
    }
}

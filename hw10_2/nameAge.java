package hw10_2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NameAge {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("D:\\HomeWork\\HomeWork-10\\src\\main\\java\\hw10_2\\name.txt");
        FileInputStream fileInputStream = new FileInputStream(file);

        Scanner scanner = new Scanner(fileInputStream);

        String firstLine = scanner.nextLine();

        String[] head = firstLine.split(" ");

        List<Person> personList = new ArrayList<>();

        while (scanner.hasNextLine()) {

            String[] parts = scanner.nextLine().split(" ");
            Person person = new Person(parts[0], Integer.parseInt(parts[1]));

            if (parts.length == head.length) {
                    personList.add(person);
                }
            }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(personList);
        File user = new File("user.json");
        try (FileWriter writer = new FileWriter(user)) {
            writer.write(json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

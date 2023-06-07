package hw10_1;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidTelephoneNumber {
    public static void main(String[] args) throws IOException {
        //(xxx) xxx-xxxx valid
        //xxx-xxx-xxxx
        File file = new File("D:\\HomeWork\\HomeWork-10\\src\\main\\java\\hw10_1\\file.txt");

        FileInputStream fileInputStream = new FileInputStream(file);
//        System.out.println("file.exists() = " + file.exists());

        Scanner scanner = new Scanner(fileInputStream);

        String scan = "";
        while (scanner.hasNextLine()) {
            scan = scanner.nextLine();
            Pattern pattern = Pattern.compile("\\(\\d{3}\\) \\d{3}-\\d{4}|\\d{3}-\\d{3}-\\d{4}");
            Matcher matcher = pattern.matcher(scan);
            if (matcher.find()) {System.out.println("Valid TelephoneNumber " + scan);}
        }
        fileInputStream.close();
    }
}

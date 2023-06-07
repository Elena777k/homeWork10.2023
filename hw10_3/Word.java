package hw10_3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Word {
    public static void main(String[] args) throws IOException {


        File file = new File("D:\\HomeWork\\HomeWork-10\\src\\main\\java\\hw10_3\\word.txt");

        FileInputStream fileInputStream = new FileInputStream(file);
//      System.out.println("file.exists() = " + file.exists());

        Scanner scanner = new Scanner(fileInputStream);

        StringBuilder sbRes = new StringBuilder();
        while (scanner.hasNextLine()) {
            sbRes.append(scanner.nextLine()).append(" ");
        }
//      System.out.println("sbRes = " + sbRes);

        String[] res = String.valueOf(sbRes).split(" ");

        List<Sorted> list = new ArrayList<>();
        for (String s : res) {
            int count = 0;
            for (String re : res) {
                if (re.equals(s)) count++;
            }

            list.add(new Sorted(s, count));
        }
        list.sort((o2, o1) -> o1.getWordCount() - o2.getWordCount());

//        System.out.println("list = " + list);
        LinkedHashSet<String> words = new LinkedHashSet<>();
        for (Sorted sorted : list) {
            words.add(String.valueOf(sorted));
        }
        for (String word : words) {
            System.out.println(word);
        }
        fileInputStream.close();
    }
}



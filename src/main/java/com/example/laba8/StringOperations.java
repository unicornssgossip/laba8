package com.example.laba8;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Comparator;


public class StringOperations {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Hello");
        strings.add("World");
        strings.add("Java");
        strings.add("Programming");

        // 1. Добавление и удаление объектов
        strings.add("New String");
        strings.remove("Java");

        // 2. Поиск одинаковых элементов с подсчетом совпадений
        int count = Collections.frequency(strings, "World");
        System.out.println("Number of occurrences of 'World': " + count);

        // 3. Выгрузка в xml-файл
        exportToXml(strings, "output.xml");

        // 4. Реверс всех строк, входящих в коллекцию
        Collections.reverse(strings);
        System.out.println("Reversed strings: " + strings);

        // 5. Статистика по всем символам, содержащимся в строках коллекции
        Map<Character, Integer> characterCountMap = new HashMap<>();
        for (String str : strings) {
            for (char c : str.toCharArray()) {
                characterCountMap.put(c, characterCountMap.getOrDefault(c, 0) + 1);
            }
        }
        System.out.println("Character Statistics:");
        for (Map.Entry<Character, Integer> entry : characterCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
// 6. Поиск подстроки в строках коллекции
        String searchString = "o";
        ArrayList<String> matchingStrings = new ArrayList<>();
        for (String str : strings) {
            if (str.contains(searchString)) {
                matchingStrings.add(str);
            }
        }
        System.out.println("Strings containing the substring: " + matchingStrings);
        // 7. Инициализация листа по текстовому файлу и вывод содержимого коллекции на экран
        ArrayList<String> fileStrings = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNextLine()) {
                fileStrings.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Contents of the list initialized from file: " + fileStrings);

// 8. Расширить функциональность класса ArrayList методом compareInnerObjects (int firstIndex, int secondIndex)
        compareInnerObjects(strings, 0, 1);
        // 9. Посчитать длины строк входящих в коллекцию, и вывести результат в упорядоченном виде
        ArrayList<Integer> lengths = new ArrayList<>();
        for (String str : strings) {
            lengths.add(str.length());
        }
        Collections.sort(lengths);
        System.out.println("String lengths in ascending order: " + lengths);

        // 10. Реализовать возможность добавления в динамическую коллекцию с ограничениями
        ArrayList<String> staticStrings = new ArrayList<>();
        int maxSize = 5; // Задаем статическую размерность коллекции
        staticStrings.add("String1");
        staticStrings.add("String2");
        staticStrings.add("String3");
        staticStrings.add("String4");
        staticStrings.add("String5");
        // Добавляем новый элемент
        staticStrings.add("String6");
        // При добавлении нового элемента удаляем первый элемент
        if (staticStrings.size() > maxSize) {
            staticStrings.remove(0);
        }
        System.out.println("Dynamic Collection with limited size: " + staticStrings);
    }

    public class HelloWorld {
        public static void main(String[] args) {
            System.out.println("unicorn");
        }
    }

    // Метод compareInnerObjects
    public static void compareInnerObjects(ArrayList<String> strings, int firstIndex, int secondIndex) {
        String str1 = strings.get(firstIndex);
        String str2 = strings.get(secondIndex);
        if (str1.equals(str2)) {
            System.out.println("Strings are similar");
        } else {
            System.out.println("Strings aren't similar");
        }
    }

    private static void exportToXml(ArrayList<String> strings, String filename) {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<strings>\n");
        for (String str : strings) {
            xmlBuilder.append("\t<string>").append(str).append("</string>\n");
        }
        xmlBuilder.append("</strings>");

        try (FileOutputStream fos = new FileOutputStream(filename)) {
            fos.write(xmlBuilder.toString().getBytes());
            System.out.println("Exported strings to '" + filename + "'.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



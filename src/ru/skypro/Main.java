package ru.skypro;

import ru.skypro.service.StringList;
import ru.skypro.service.StringListImpl;

public class Main {

    public static void main(String[] args) {

        StringList stringList = new StringListImpl();

        System.out.println("stringList.isEmpty() = " + stringList.isEmpty());
        System.out.println("stringList.add(1) = " + stringList.add("1"));
        System.out.println("stringList.isEmpty() = " + stringList.isEmpty());
        stringList.add("2");
        stringList.add("3");
        stringList.add("4");
        stringList.add("5");
        stringList.add("6");
        stringList.add("7");
        stringList.add("8");
        stringList.add("9");
        stringList.add("10");
        String[] array = stringList.toArray();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        System.out.println("stringList.add(1, \"-1\") = " + stringList.add(1, "-1"));
        System.out.println("stringList.set(2, \"-2\") = " + stringList.set(2, "-2"));
        String[] newArray = stringList.toArray();
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i] + " ");
        }
        System.out.println();
        System.out.println("stringList.remove(\"4\") = " + stringList.remove("4"));
        System.out.println("stringList.remove(3) = " + stringList.remove(3));
        System.out.println("stringList.contains(\"5\") = " + stringList.contains("5"));
        System.out.println("stringList.indexOf(\"6\") = " + stringList.indexOf("6"));
        System.out.println("stringList.lastIndexOf(\"6\") = " + stringList.lastIndexOf("6"));
        System.out.println("stringList.get(7) = " + stringList.get(7));
        stringList.clear();
        System.out.println("stringList.isEmpty() = " + stringList.isEmpty());
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}

package ru.skypro.service;

import ru.skypro.exceptions.NotFoundException;

public class StringListImpl implements StringList {

    private String[] array = new String[10];

    private int size = 0;

    @Override
    public String add(String item) {
        if (size >= array.length) {
            String[] extended = new String[array.length + 1];
            System.arraycopy(array, 0, extended, 0, array.length);
            array = extended;
        }
        array[size] = item;
        size++;
        return item;
    }

    @Override
    public String add(int index, String item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        add(item);
        for (int i = size - 1; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = item;
        return item;
    }

    @Override
    public String set(int index, String item) {
        String old = get(index);
        array[index] = item;
        return old;
    }

    @Override
    public String remove(String item) {
        int a = -1;
        for (int i = 0; i < size; i++) {
            if (item.equals(array[i])) {
                a = i;
                break;
            }
        }
        if (a != -1) {
            remove(a);
        } else {
            throw new NotFoundException("Not found");
        }
        return item;
    }

    @Override
    public String remove(int index) {
        String element = get(index);
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return element;
    }

    @Override
    public boolean contains(String item) {
        boolean a = false;
        for (String element : array) {
            if (element.equals(item)) {
                a = true;
                break;
            }
        }
        return a;
    }

    @Override
    public int indexOf(String item) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (item.equals(array[i])) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public int lastIndexOf(String item) {
        int index = -1;
        for (int i = array.length-1; i >= 0; i--) {
            if (item.equals(array[i])) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        boolean listsEqual = true;
        for (int i = 0; i < array.length; i++) {
            if(!array[i].equals(otherList.get(i))){
               listsEqual = false;
               break;
            }
        }
        return listsEqual;
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public boolean isEmpty() {
        boolean a = true;
        for (String element : array){
            if(element != null){
                a = false;
                break;
            }
        }
        return a;
    }

    @Override
    public void clear() {
        array = new String[10];
    }

    @Override
    public String[] toArray() {
        return array;
    }
}

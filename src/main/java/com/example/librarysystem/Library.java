package com.example.librarysystem;

import java.io.*;
import java.util.HashMap;
import java.util.Objects;

public class Library {
    private HashMap<String, Book> library;
    private final File file = new File("data.ser");

    @SuppressWarnings("unchecked")
    public Library() {
        HashMap<String, Book> temp = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            temp = (HashMap<String, Book>) ois.readObject();
        } catch (ClassNotFoundException | IOException e) {
            System.err.println("There was an error loading the library");
        }
        library = Objects.requireNonNullElseGet(temp, HashMap::new);
    }

    public HashMap<String, Book> getLibrary() {
        return library;
    }

    public void saveLibrary() {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(library);
        } catch (IOException e) {
            System.err.println("There was an error saving the library");
        }
    }

    public void addBook(Book book) {
        library.put(book.getTitle(), book);
    }

    public Book getBook(String title) {
        return library.get(title);
    }

    public boolean removeBook(String title) {
        return library.remove(title) != null;
    }
}

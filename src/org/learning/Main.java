package org.learning;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Book[] books = null;
        try {
            File file= new File("./resources/data.txt");
            System.out.println(file.exists()); // Controllo di aver correttamente inizializzato il file

            System.out.print("Quanti libri vuoi inserire? ");
            int numBooks = Integer.parseInt(scanner.nextLine());
            if (numBooks <= 0){
                throw new IllegalArgumentException("Il numero di libri deve essere maggiore di 0");
            }
            books= new Book[numBooks];
            for (int i = 0; i < books.length; i++) {
                System.out.print("*************\nInserisci il titolo: ");
                String title= scanner.nextLine().trim();

                System.out.print("Inserisci l'autore: ");
                String author= scanner.nextLine().trim();

                System.out.print("Inserisci il numero di pagine: ");
                int pages= Integer.parseInt(scanner.nextLine());

                System.out.print("Inserisci l'editore: ");
                String editor= scanner.nextLine().trim();

                books[i]= new Book(title, author, pages, editor);

            }
              System.out.println("*********\n" + Arrays.toString(books));
            writeBooksOnFile(books, file);
            readBooksFromFile(file);

        } catch (NumberFormatException e) {
            System.out.println("Input non valido. Inserisci un numero intero");
        } catch ( IllegalArgumentException e){
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            scanner.close();
        }

    }

    public static void writeBooksOnFile(Book[] books, File file){ // Try with resource
           try(FileWriter fileWriter = new FileWriter(file)){
               for (Book book : books){
                   fileWriter.write(book.toString() + "\n");
               }
           }catch (IOException e){
               System.out.println("Impossibile scrivere sul file" + e.getMessage());
           }
    }

    public static void readBooksFromFile(File file) throws IOException {    // 58''
        Scanner scanner= null;
        try {
            scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String line= scanner.nextLine();
                System.out.println(line + "\n");
            }
        } catch (IOException e) {
            System.out.println("Impossibile leggere il file");
        } finally {
            if(scanner != null){
                scanner.close();
            }
        }
    }
}

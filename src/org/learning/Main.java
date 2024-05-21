package org.learning;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Book[] books = null;
        try {
            System.out.print("Quanti libri vuoi inserire? ");
            int numBooks = Integer.parseInt(scanner.nextLine());
            if (numBooks <= 0){
                throw new IllegalArgumentException("Il numero di libri deve essere maggiore di 0");
            }
            books= new Book[numBooks];
            for (int i = 0; i < books.length; i++) {
                System.out.print("Inserisci l titolo: ");
                String title= scanner.nextLine().trim();

                System.out.print("Inserisci l'autore: ");
                String author= scanner.nextLine().trim();

                System.out.print("Inserisci il numero di pagine: ");
                int pages= Integer.parseInt(scanner.nextLine());

                System.out.print("Inserisci l'editore: ");
                String editor= scanner.nextLine().trim();

                books[i]= new Book(title, author, pages, editor);

            }
              System.out.println(Arrays.toString(books));

        } catch (NumberFormatException e) {
            System.out.println("Input non valido. Inserisci un numero intero");
        } catch ( IllegalArgumentException e){
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }

    }
}

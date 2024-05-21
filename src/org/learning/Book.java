package org.learning;


public class Book {
    private String title;
    private String author;
    private int pages;
    private String editor;

    public Book(String title, String author, int pages, String editor){
        setTitle(title);
        setAuthor(author);
        setPages(pages);
        setEditor(editor);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws IllegalArgumentException {
        if (title == null || title.isEmpty()){
            throw new IllegalArgumentException("Devi inserire un titolo");
        }
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) throws IllegalArgumentException {
        if (author== null || author.isEmpty()){
            throw new IllegalArgumentException("Devi inserire un autore");
        }
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) throws IllegalArgumentException {
        if ( pages <= 0){
            throw new IllegalArgumentException("Devi inserire un numero positivo di pagine");
        }
        this.pages = pages;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) throws IllegalArgumentException {
        if(editor == null || editor.isEmpty()){
            throw new IllegalArgumentException("Devi inserire un editore");
        }
        this.editor = editor;
    }
}

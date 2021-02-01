package org.edu.cqu.learn.design.iterator;

public class BookShelf implements Aggregate {

    private Book[] books;

    private int last = 0;

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public BookShelf(int maxSize) {
        this.books = new Book[maxSize];
    }

    public void appendBook(Book book) {
        this.books[last] = book;
        last ++;
    }

    public int getLast() {
        return last;
    }

    @Override
    public Iterator iterator() {
        return new BookIterator(this);
    }
}

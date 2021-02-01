package org.edu.cqu.learn.design.iterator;

public class BookIterator implements Iterator {

    private BookShelf bookShelf;

    private int index;

    public BookIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < bookShelf.getBooks().length;
    }

    @Override
    public Object next() {
        if ( hasNext() ) {
            Object object = bookShelf.getBooks()[index];
            index ++;
            return object;
        } else {
            return null;
        }
    }
}

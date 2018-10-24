package com.library.dao;

import com.library.entity.Book;
import com.library.entity.BookDetail;

import java.util.List;

public interface BookDAO {

    public List<Book> getBooks();

    public void saveBook(Book book);

    public Book getBooks(int theId);

    public Book withdrawBook(int theId);

    public Book depositBook(int theId);

    public BookDetail saveDetail(BookDetail bookDetail);

    public List<Book> searchBook(String theSearchName);

    void deleteBook(int theId);
}

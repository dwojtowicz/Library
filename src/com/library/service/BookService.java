package com.library.service;

import com.library.entity.Book;
import com.library.entity.BookDetail;

import java.util.List;

public interface BookService {


    List<Book> getBooks();

    void saveBook(Book book);

    Book getBooks(int theId);

    Book withdrawBook(int theId);

    Book depositBook(int theId);

    List<Book> searchBook(String theSearchName);

    void deleteBook(int theId);

    BookDetail getDetail(int detailId);
}

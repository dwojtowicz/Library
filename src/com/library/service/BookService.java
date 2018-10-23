package com.library.service;

import com.library.entity.Book;
import com.library.entity.BookDetail;

import java.util.List;

public interface BookService {


    public List<Book> getBooks();

    public void saveBook(Book book);

    public Book getBooks(int theId);

    public void saveBookDetail(BookDetail bookDetail);
}

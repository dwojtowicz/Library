package com.library.service;

import com.library.entity.Book;

import java.util.List;

public interface BookService {


    public List<Book> getBooks();

    void saveBook(Book book);
}

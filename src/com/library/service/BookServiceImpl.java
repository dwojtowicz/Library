package com.library.service;

import com.library.dao.BookDAO;
import com.library.entity.Book;
import com.library.entity.BookDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Override
    @Transactional
    public List<Book> getBooks() {
       return bookDAO.getBooks();
    }

    @Override
    @Transactional
    public void saveBook(Book book) {
        bookDAO.saveBook(book);
    }

    @Override
    @Transactional
    public Book getBooks(int theId) {
        return bookDAO.getBooks(theId);
    }


    @Override
    @Transactional
    public Book withdrawBook(int theId) {

       return bookDAO.withdrawBook(theId);

    }

    @Override
    @Transactional
    public Book depositBook(int theId) {
        return bookDAO.depositBook(theId);
    }
}

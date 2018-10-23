package com.library.dao;

import com.library.entity.Book;
import com.library.entity.BookDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Book> getBooks() {

        Session currentSession = sessionFactory.getCurrentSession();

       Query<Book> theQuery = currentSession.createQuery("from Book order by title"
                , Book.class);

        List<Book> books = theQuery.getResultList();

        return books;
    }

    @Override
    public void saveBook(Book book) {

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.saveOrUpdate(book);
    }

    @Override
    public Book getBooks(int theId) {

        Session currentSession = sessionFactory.getCurrentSession();

        Book theBook = currentSession.get(Book.class, theId);

        BookDetail bookDetail = new BookDetail();

        return theBook;
    }

    @Override
    public void saveBookDetail(BookDetail bookDetail) {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.saveOrUpdate(bookDetail);

    }
}

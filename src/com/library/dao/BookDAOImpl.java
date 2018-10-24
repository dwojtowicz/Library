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

        return theBook;
    }


    @Override
    public Book withdrawBook(int theId) {

        Session currentSession = sessionFactory.getCurrentSession();

        Book theBook = currentSession.get(Book.class, theId);


        if(theBook.getQuantity() > 0){
        theBook.setQuantity(theBook.getQuantity()-1);
        } else theBook.setQuantity(0);

        return theBook;
    }

    @Override
    public Book depositBook(int theId) {

        Session currentSession = sessionFactory.getCurrentSession();

        Book theBook = currentSession.get(Book.class, theId);

        theBook.setQuantity(theBook.getQuantity()+1);

        return theBook;
    }

    @Override
    public BookDetail saveDetail(BookDetail bookDetail) {

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.saveOrUpdate(bookDetail);

        return null;
    }

    @Override
    public List<Book> searchBook(String theSearchName) {
      Session currentSession = sessionFactory.getCurrentSession();

      Query theQuery = null;

      if(theSearchName != null && theSearchName.trim().length() > 0){
          theQuery = currentSession.createQuery("from Book where lower(title) like :theName" , Book.class);
          theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
      } else
          theQuery = currentSession.createQuery("from Book", Book.class);

      List<Book> books = theQuery.getResultList();

        return books;
    }

    @Override
    public void deleteBook(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query theQuery = currentSession.createQuery("delete from Book where id=:bookId");
        theQuery.setParameter("bookId", theId);
        theQuery.executeUpdate();
    }
}

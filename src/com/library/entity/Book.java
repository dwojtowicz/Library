package com.library.entity;




import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="book")
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    @Column(name = "title")
    private String title;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    @Column(name = "book_author")
    private String bookAuthor;

    @Column(name = "quantity")
    private int quantity;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_detail_id")
    private BookDetail bookDetail;

    public Book(){
    }

    public Book(String title, String bookAuthor, int quantity, BookDetail bookDetail) {
        this.title = title;
        this.bookAuthor = bookAuthor;
        this.quantity = quantity;
        this.bookDetail = bookDetail;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BookDetail getBookDetail() {
        return bookDetail;
    }

    public void setBookDetail(BookDetail bookDetail) {
        this.bookDetail = bookDetail;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", quantity=" + quantity +
                ", bookDetail=" + bookDetail +
                '}';
    }
}

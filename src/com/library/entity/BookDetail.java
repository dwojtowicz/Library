package com.library.entity;


import javax.persistence.*;

@Entity
@Table(name="book_detail")
public class BookDetail {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "description")
    private String description;

    public BookDetail(){

    }

    public BookDetail(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "BookDetail{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}

package lk.ijse.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity     //  This annotation means this is an entity -->(Entity is related to database)
public class Author {

    @Id     //  This annotation means PRIMARY KEY of table
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // This annotation means id is auto-incremented
    private int id;
    private String name;

    @OneToMany(mappedBy = "author")     //  Pointing to author field in Book entity
    private List<Book> books;   // One author has many books

    public Author() {
    }

    public Author(int id, String name, List<Book> books) {
        this.id = id;
        this.name = name;
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}

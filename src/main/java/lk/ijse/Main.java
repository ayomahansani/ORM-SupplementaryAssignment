package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.entity.Author;
import lk.ijse.entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.Year;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();


        // -------- Question 01 --------

        String hql1 = " FROM Book WHERE publicationYear > :year ";
        Query query1 = session.createQuery(hql1);
        query1.setParameter("year", Year.of(2010));

        List<Book> books = query1.list();

        for(Book book : books){
            System.out.println(book);
        }


        // -------- Question 02 --------

        String hql2 = " UPDATE Book SET price = price * 1.1 WHERE author.id = :id ";
        Query query2 = session.createQuery(hql2);
        query2.setParameter("id", 1);

        int affectedRows = query2.executeUpdate();

        if(affectedRows > 0){
            System.out.println("A book is updated successfully...");
            System.out.println("Affected Rows : " + affectedRows);
        }


        // -------- Question 03 --------
        deleteAnAuthor(session);


        // -------- Question 04 --------




        transaction.commit();
        session.close();

    }

    private static void deleteAnAuthor(Session session) {

        Author author = session.get(Author.class, 3);

        if( author != null){
            session.delete(author);
            System.out.println("An author is deleted successfully...");
        }else {
            System.out.println("Can not find an author...");
        }

    }
}
package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class Main {

    public static void main(String[] args) {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();


        // -------- Question 01 --------

        String hql1 = "FROM Book WHERE publicationYear > ";
        Query query1 = session.createQuery(hql1);

        transaction.commit();
        session.close();

    }
}
Question 01:
String hql1 = " FROM Book WHERE publicationYear > :year ";

Question 02:
String hql2 = " UPDATE Book b SET b.price = b.price * 1.1 WHERE b.author.id = :id ";

Question 03:
deleteAnAuthor(session);

private static void deleteAnAuthor(Session session) {       // Creating deleteAnAuthor(Session session) method

        Author author = session.get(Author.class, 1);

        if(author != null){
            session.delete(author);
            System.out.println("An author is deleted successfully...");
        }else {
            System.out.println("Can not find an author...");
        }


        /*
        String hql3 = " DELETE FROM Author a WHERE a.id = :id ";
        Query query3 = session.createQuery(hql3);
        query3.setParameter("id", 3);
        int affectedRows = query3.executeUpdate();
        if(affectedRows > 0){
            System.out.println("Deleted...");
        }
        */

  }

  Question 04:
  String hql4 = " SELECT AVG(price) FROM Book ";

  Question 05:
  String hql5 = " SELECT a.id, COUNT(b.id) FROM Author a JOIN Book b ON a.id = b.author.id GROUP BY a.id ";

  Question 06:
  String hql6 = " SELECT b.title FROM Book b JOIN Author a ON b.author.id = a.id WHERE a.country = :country";

  Question 08:
  String hql8 = "SELECT a.name FROM Author a WHERE ( SELECT COUNT(b.id) FROM Book b WHERE a.id = b.author.id ) > ( SELECT AVG(countOfBook) FROM ( SELECT COUNT(b.id) AS countOfBook FROM Book b GROUP BY b.author.id ))";

    

------- ANSWERES TO HQL QUERIES -------


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



------- CASCADE OPERATIONS -------

CascadeType.REMOVE :
        CascadeType.REMOVE is a powerful tool in JPA (Java Persistence API) and Hibernate that automates the deletion of child entities when their parent entity is removed from the database.
  
        In our project, when we delete an author, all their associated books are also deleted.


------- EXPLAINATIONS FOR ANNOTATIONS -------

@JoinColumn Annotation :
        An author can write many books, and a book belongs to one author. This is a one-to-many relationship.The Join Column annotation helps map this relationship in this code. It tells to program which column in one table (e.g., author_id in Books) refers to the primary key (usually id) in the other table (Authors). This creates the link between them.

@GeneratedValue Annotation :
        When we create new entities, they need unique identifiers (IDs). The GenerateId annotation helps with this. It tells to program how to generate new IDs. IDENTITY: The database assigns a unique ID when the entity is inserted.

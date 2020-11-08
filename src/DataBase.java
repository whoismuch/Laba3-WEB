

import org.eclipse.persistence.internal.sessions.UnitOfWorkImpl;
import org.eclipse.persistence.jpa.JpaEntityManager;
import org.eclipse.persistence.sessions.Session;

import javax.persistence.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DataBase {

    EntityManagerFactory emf;

    public DataBase ( ) throws SQLException {
        emf = Persistence.createEntityManagerFactory("postgres");
    }

    public List<Point> getPointsFromDB ( ) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select p from Point p");
        return query.getResultList( );
    }

    public void addPointToDB (Point point) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction( ).begin( );
        em.persist(point);
        em.getTransaction( ).commit( );
        em.close();
    }


}

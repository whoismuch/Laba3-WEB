

import org.eclipse.persistence.internal.sessions.UnitOfWorkImpl;
import org.eclipse.persistence.jpa.JpaEntityManager;
import org.eclipse.persistence.sessions.Session;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.persistence.*;
import javax.transaction.*;
import javax.transaction.RollbackException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DataBase {


    @PersistenceContext(unitName = "postgres")
    private static EntityManager em;

    @Resource
    private static UserTransaction userTransaction;

    public static List<Point> getPointsFromDB ( ) {
        Query query = em.createQuery("select p from Point p");
        return query.getResultList( );
    }

    public static void addPointToDB (Point point) throws Exception{
        userTransaction.begin();
        em.persist(point);
        userTransaction.commit();
    }


}

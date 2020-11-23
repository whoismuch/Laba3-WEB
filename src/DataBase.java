

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
    private EntityManager em;

    @Resource
    private UserTransaction userTransaction;

    public List<Point> getPointsFromDB ( ) {
        Query query = em.createQuery("select p from Point p");
        return query.getResultList( );
    }

    public  void addPointToDB (Point point) throws Exception{
        userTransaction.begin();
        em.persist(point);
        userTransaction.commit();
//        help();
    }

    public void help() throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {
        userTransaction.begin();
        Point point = em.find(Point.class, 48);
        point.setX(173.0);
        em.persist(point);
        userTransaction.commit();
    }


}

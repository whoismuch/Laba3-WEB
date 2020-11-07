

import javax.mail.Session;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.sql.Connection;
import java.util.List;

public class DataBase {

    private EntityManager em;

    public DataBase () {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        em = emf.createEntityManager();


//        em.createNativeQuery("CREATE TABLE IF NOT EXISTS Points (id int not null" +
//                "          constraint Points_pk" +
//                "          primary key," +
//                "          x double precision not null," +
//                "          y double precision not null," +
//                "          r int not null," +
//                "          result bool not null)").executeUpdate();

//        List<Point> pointList = em.createQuery("SELECT * FROM Points").getResultList();

//        System.out.println(1);



//        List<Point> results = query.getResultList();



//        for (Point point : pointList)
//            System.out.println(point.getX() + " " + point.getY());
    }


}

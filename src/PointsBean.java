import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;


public class PointsBean implements Serializable {

    private Point point = new Point( );

    private DataBase dataBase;

    private List<Point> pointList = new ArrayList<Point>( );

    public PointsBean ( ) {

    }

    @PostConstruct
    public void postConstruct ( ) throws SQLException {
        pointList = dataBase.getPointsFromDB( );
    }

    public Boolean isThePointIn (Point point) {

        if (point.getX( ) >= 0 && point.getX( ) <= point.getR( ) && point.getY( ) >= 0 && point.getY( ) <= point.getR( )
                || point.getX( ) >= 0 && point.getY( ) <= 0 && (point.getX( ) * point.getX( ) + point.getY( ) * point.getY( ) <= (point.getR( ) * point.getR( )) / 4)
                || point.getX( ) <= 0 && point.getY( ) >= 0 && point.getY( ) <= point.getX( ) + point.getR( )) {
            point.setResult(true);
        } else point.setResult(false);

        return point.getResult( );
    }

    public void addPoint ( ) throws Exception {
        isThePointIn(point);
        pointList.add(point);
        dataBase.addPointToDB(point);
        point = new Point();
    }

    public Point getPoint ( ) {
        return point;
    }

    public void setPoint (Point point) {
        this.point = point;
    }

    public List<Point> getPointList ( ) {
        return pointList;
    }

    public void setPointList (List<Point> pointList) {
        this.pointList = pointList;
    }

    public DataBase getDataBase ( ) {
        return dataBase;
    }

    public void setDataBase (DataBase dataBase) {
        this.dataBase = dataBase;
    }



}

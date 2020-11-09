import javafx.beans.property.adapter.JavaBeanBooleanProperty;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PointsBean implements Serializable {

    private Point point = new Point( );

    private DataBase dataBase;

    private List<Point> pointList = new ArrayList<Point>( );

    public PointsBean ( ) {

    }

    public Boolean isThePointIn (Point point) {

        if (point.getX( ) >= 0 && point.getX( ) <= point.getR( ) && point.getY( ) >= 0 && point.getY( ) <= point.getR( )
                || point.getX( ) >= 0 && point.getY( ) <= 0 && (point.getX( ) * point.getX( ) + point.getY( ) * point.getY( ) <= (point.getR( ) * point.getR( )) / 4)
                || point.getX( ) <= 0 && point.getY( ) >= 0 && point.getY( ) <= point.getX( ) + point.getR( )) {
            point.setResult(true);
        } else point.setResult(false);

        return point.getResult( );
    }

    @PostConstruct
    public void postConstruct ( ) throws SQLException {
        dataBase = new DataBase( );
        pointList = dataBase.getPointsFromDB( );
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

    public void addPoint ( ) {
        isThePointIn(point);
        pointList.add(point);
        dataBase.addPointToDB(point);
        point = new Point();
    }

}

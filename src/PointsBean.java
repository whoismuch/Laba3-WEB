import javafx.beans.property.adapter.JavaBeanBooleanProperty;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PointsBean implements Serializable {

    private Point point = new Point( );

    private List<Point> pointList = new ArrayList<Point>( );

    public PointsBean ( ) {

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
        pointList.add(point);
        point = new Point( );
    }

}

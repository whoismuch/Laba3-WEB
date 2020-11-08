import javax.inject.Named;
import javax.persistence.*;

@Entity
@Table(name= "Points")
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "generator")
    @SequenceGenerator(name = "generator", sequenceName = "points_id_seq", initialValue = 1, allocationSize=1)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "x", nullable = false)
    private Double x;
    @Column(name = "y", nullable = false)
    private Double y;
    @Column(name = "r", nullable = false)
    private Integer r;
    @Column(name = "result", nullable = false)
    private Boolean result;

    public Boolean getResult ( ) {
        return result;
    }

    public void setResult (Boolean result) {
        this.result = result;
    }

    public Double getX ( ) {
        return x;
    }

    public void setX (Double x) {
        this.x = x;
    }

    public Double getY ( ) {
        return y;
    }

    public void setY (Double y) {
        this.y = y;
    }

    public Integer getR ( ) {
        return r;
    }

    public void setR (Integer r) {
        this.r = r;
    }
}

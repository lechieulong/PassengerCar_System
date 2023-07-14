package booking.beans;

import java.sql.Timestamp;
import java.util.StringJoiner;

public class Trips {
    private long id;
    private long routesId;

    public Trips() {
    }

    public Trips(long id, long routesId) {
        this.id = id;
        this.routesId = routesId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRoutesId() {
        return routesId;
    }

    public void setRoutesId(long routesId) {
        this.routesId = routesId;
    }



    @Override
    public String toString() {
        return "Trips{" +
                "id=" + id +
                ", routesId=" + routesId +
                '}';
    }

    public String toString2() {
        return new StringJoiner(",",Trips.class.getSimpleName()+"[","]")
                .toString();
    }
}

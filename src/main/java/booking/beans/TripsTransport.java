package booking.beans;

import java.sql.Timestamp;
import java.util.StringJoiner;

public class TripsTransport {
    private long id;
    private long tripsId;
    private long transportId;
    private Timestamp departTime;

    private int emptySeat;

    public TripsTransport() {
    }

    public TripsTransport(long id, long tripsId, long transportId, Timestamp departTime, int emptySeat) {
        this.id = id;
        this.tripsId = tripsId;
        this.transportId = transportId;
        this.departTime = departTime;
        this.emptySeat = emptySeat;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTripsId() {
        return tripsId;
    }

    public void setTripsId(long tripsId) {
        this.tripsId = tripsId;
    }

    public long getTransportId() {
        return transportId;
    }

    public void setTransportId(long transportId) {
        this.transportId = transportId;
    }

    public Timestamp getDepartTime() {
        return departTime;
    }

    public void setDepartTime(Timestamp departTime) {
        this.departTime = departTime;
    }

    public int getEmptySeat() {
        return emptySeat;
    }

    public void setEmptySeat(int emptySeat) {
        this.emptySeat = emptySeat;
    }

    public String toString2() {
        return new StringJoiner(",",Trips.class.getSimpleName()+"[","]")

                .toString();
    }
}

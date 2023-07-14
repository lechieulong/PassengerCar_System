package booking.beans;

import java.util.StringJoiner;

public class SeatType {
    private long id;
    private String name;

    public SeatType() {
    }

    public SeatType(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return new StringJoiner(",",SeatType.class.getSimpleName()+"[","]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .toString();
    }
}

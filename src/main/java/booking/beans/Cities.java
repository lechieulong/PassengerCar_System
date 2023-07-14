package booking.beans;

import java.util.StringJoiner;

public class Cities {
    private long id;
            private String name;
                    public Cities() {
    }
    public Cities(long id,
                  String name) {
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
        return new StringJoiner(",",Cities.class.getSimpleName()+"[","]")
                .add("id =" +id)
                .add("name =" +name)
                .toString();
    }
}

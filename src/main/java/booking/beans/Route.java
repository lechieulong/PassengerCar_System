    package booking.beans;

    import java.util.StringJoiner;

    public class Route {
        private long id;
            private String name;
                private long pickUpPoint;
                    private long dropOffPoint;


        public Route(long id,
                     String name,
                     long pickUpPoint,
                     long dropOffPoint
                     ) {
            this.id = id;
            this.name = name;
            this.pickUpPoint = pickUpPoint;
            this.dropOffPoint = dropOffPoint;
        }

        public Route() {
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

        public long getPickUpPoint() {
            return pickUpPoint;
        }

        public void setPickUpPoint(long pickUpPoint) {
            this.pickUpPoint = pickUpPoint;
        }

        public long getDropOffPoint() {
            return dropOffPoint;
        }

        public void setDropOffPoint(long dropOffPoint) {
            this.dropOffPoint = dropOffPoint;
        }



        @Override
        public String toString() {
            return new StringJoiner(",",Route.class.getSimpleName()+"[","]")
                    .add("id= "+ id)
                    .add("name= "+ name)
                    .add("pickUpPoint= " + pickUpPoint)
                    .add("dropOffPoint= " + dropOffPoint).toString();
        }
    }

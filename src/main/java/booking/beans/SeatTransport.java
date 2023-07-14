package booking.beans;

public class SeatTransport {
    private long id;
    private long transportId;
    private long typeOfSeatId;
    private int quantity ;
    private int price;

    public SeatTransport() {
    }

    public SeatTransport(long id, long transportId, long typeOfSeatId, int quantity, int price) {
        this.id = id;
        this.transportId = transportId;
        this.typeOfSeatId = typeOfSeatId;
        this.quantity = quantity;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTransportId() {
        return transportId;
    }

    public void setTransportId(long transportId) {
        this.transportId = transportId;
    }

    public long getTypeOfSeatId() {
        return typeOfSeatId;
    }

    public void setTypeOfSeatId(long typeOfSeatId) {
        this.typeOfSeatId = typeOfSeatId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "SeatTransport{" +
                "id=" + id +
                ", transportId=" + transportId +
                ", typeOfSeatId=" + typeOfSeatId +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}

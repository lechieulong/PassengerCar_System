package booking.beans;

import booking.dto.TripsTransportByPointAndDate;
import org.jetbrains.annotations.Nullable;


public class Ticket {
    private long id;
    private long userId;
    private long tripsTransportId;
    private long seatTransportId;
    private int quantity;
    private double totalPrice;
    private int status;
    @Nullable
    private User user;
    @Nullable
    private TripsTransportByPointAndDate tripsTransportByPointAndDate;


    public Ticket() {
    }

    public Ticket(long id, long userId, long tripsTransportId, long seatTransportId, int quantity, double totalPrice, int status) {
        this.id = id;
        this.userId = userId;
        this.tripsTransportId = tripsTransportId;
        this.seatTransportId = seatTransportId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getTripsTransportId() {
        return tripsTransportId;
    }

    public void setTripsTransportId(long tripsTransportId) {
        this.tripsTransportId = tripsTransportId;
    }

    public long getSeatTransportId() {
        return seatTransportId;
    }

    public void setSeatTransportId(long seatTransportId) {
        this.seatTransportId = seatTransportId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Nullable
    public User getUser() {
        return user;
    }

    public void setUser( @Nullable User user) {
        this.user = user;
    }
    @Nullable
    public TripsTransportByPointAndDate getTripsTransportByPointAndDate() {
        return tripsTransportByPointAndDate;
    }

    public void setTripsTransportByPointAndDate( @Nullable TripsTransportByPointAndDate tripsTransportByPointAndDate) {
        this.tripsTransportByPointAndDate = tripsTransportByPointAndDate;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", userId=" + userId +
                ", tripsTransportId=" + tripsTransportId +
                ", seatTransportId=" + seatTransportId +
                ", quantity=" + quantity +
                ", price=" + totalPrice +
                ", statusPayment=" + status +
                ", user=" + user +
                ", tripsTransportByPointAndDate=" + tripsTransportByPointAndDate +
                '}';
    }
}

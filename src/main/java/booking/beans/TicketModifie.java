package booking.beans;

import java.time.LocalDateTime;


public class TicketModifie {
    private long id;
    private long userId;
    private long tripsTransportId;
    private int quantity;
    private int totalPrice;
    private int status;

    private String nameOfPassenger;

    private String pickUpPoint;
    private String dropOffPoint;
    private String nameOfTransport;

    private String routeName;
    private LocalDateTime timeDepart;


    public TicketModifie() {
    }

    public TicketModifie(long id, long userId, long tripsTransportId,  int quantity, int totalPrice, int status, String nameOfPassenger, String pickUpPoint,
                         String dropOffPoint, String nameOfTransport, String routeName, LocalDateTime timeDepart) {
        this.id = id;
        this.userId = userId;
        this.tripsTransportId = tripsTransportId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.status = status;
        this.nameOfPassenger = nameOfPassenger;
        this.pickUpPoint = pickUpPoint;
        this.dropOffPoint = dropOffPoint;
        this.nameOfTransport = nameOfTransport;
        this.routeName = routeName;
        this.timeDepart = timeDepart;
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



    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getNameOfPassenger() {
        return nameOfPassenger;
    }

    public void setNameOfPassenger(String nameOfPassenger) {
        this.nameOfPassenger = nameOfPassenger;
    }

    public String getPickUpPoint() {
        return pickUpPoint;
    }

    public void setPickUpPoint(String pickUpPoint) {
        this.pickUpPoint = pickUpPoint;
    }

    public String getDropOffPoint() {
        return dropOffPoint;
    }

    public void setDropOffPoint(String dropOffPoint) {
        this.dropOffPoint = dropOffPoint;
    }

    public String getNameOfTransport() {
        return nameOfTransport;
    }

    public void setNameOfTransport(String nameOfTransport) {
        this.nameOfTransport = nameOfTransport;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public LocalDateTime getTimeDepart() {
        return timeDepart;
    }

    public void setTimeDepart(LocalDateTime timeDepart) {
        this.timeDepart = timeDepart;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", userId=" + userId +
                ", tripsTransportId=" + tripsTransportId +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                ", status=" + status +
                ", nameOfPassenger='" + nameOfPassenger + '\'' +
                ", pickUpPoint='" + pickUpPoint + '\'' +
                ", dropOffPoint='" + dropOffPoint + '\'' +
                ", nameOfTransport='" + nameOfTransport + '\'' +
                ", routeName='" + routeName + '\'' +
                ", timeDepart=" + timeDepart +
                '}';
    }
}

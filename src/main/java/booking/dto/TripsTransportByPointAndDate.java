package booking.dto;

import java.sql.Timestamp;

public class TripsTransportByPointAndDate {
    private long tripsTransportId;
    private long tripsId;
    private long transportId;
    private int emptySeat;
    private String departTime;
    private String nameOfTransport;
    private String imageName;
    private String licensePlate;
    private String description;
    private int totalSeat;
    private long seatTransportId;
    private long typeOfSeatId;
    private int quantity;
    private double price;
    private long seatTypeId;
    private String name;
    private long tripId;
    private long routesId;
    private String routeName;
    private int dropOffPoint;
    private int pickUpPoint;

    public TripsTransportByPointAndDate() {
    }

    public long getTripsTransportId() {
        return tripsTransportId;
    }

    public void setTripsTransportId(long tripsTransportId) {
        this.tripsTransportId = tripsTransportId;
    }

    public long getTripsId() {
        return tripsId;
    }

    public int getEmptySeat() {
        return emptySeat;
    }
    public void setEmptySeat(int emptySeat) {
        this.emptySeat = emptySeat;
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

    public String getDepartTime() {
        return departTime;
    }

    public void setDepartTime(String departTime) {
        this.departTime = departTime;
    }

    public String getNameOfTransport() {
        return nameOfTransport;
    }

    public void setNameOfTransport(String nameOfTransport) {
        this.nameOfTransport = nameOfTransport;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTotalSeat() {
        return totalSeat;
    }

    public void setTotalSeat(int totalSeat) {
        this.totalSeat = totalSeat;
    }

    public long getSeatTransportId() {
        return seatTransportId;
    }

    public void setSeatTransportId(long seatTransportId) {
        this.seatTransportId = seatTransportId;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getSeatTypeId() {
        return seatTypeId;
    }

    public void setSeatTypeId(long seatTypeId) {
        this.seatTypeId = seatTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTripId() {
        return tripId;
    }

    public void setTripId(long tripId) {
        this.tripId = tripId;
    }

    public long getRoutesId() {
        return routesId;
    }

    public void setRoutesId(long routesId) {
        this.routesId = routesId;
    }



    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public int getDropOffPoint() {
        return dropOffPoint;
    }

    public void setDropOffPoint(int dropOffPoint) {
        this.dropOffPoint = dropOffPoint;
    }

    public int getPickUpPoint() {
        return pickUpPoint;
    }

    public void setPickUpPoint(int pickUpPoint) {
        this.pickUpPoint = pickUpPoint;
    }

    @Override
    public String toString() {
        return "TripsTransport{" +
                "tripsTransportId=" + tripsTransportId +
                "emptySeat=" + emptySeat +
                ", tripsId=" + tripsId +
                ", transportId=" + transportId +
                ", departTime=" + departTime +
                ", nameOfTransport='" + nameOfTransport + '\'' +
                ", imageName='" + imageName + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", description='" + description + '\'' +
                ", totalSeat=" + totalSeat +
                ", seatTransportId=" + seatTransportId +
                ", typeOfSeatId=" + typeOfSeatId +
                ", quantity=" + quantity +
                ", price=" + price +
                ", seatTypeId=" + seatTypeId +
                ", seatTypeName='" + name + '\'' +
                ", tripId=" + tripId +
                ", routesId=" + routesId +
                ", routeName='" + routeName + '\'' +
                ", dropOffPoint=" + dropOffPoint +
                ", pickUpPoint=" + pickUpPoint +
                '}';
    }
}

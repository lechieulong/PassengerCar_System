package booking.dto;

import java.sql.Timestamp;

public class TripsTransportWithRoutes {
    private long id;
    private long tripsTransportId;
    private int emptySeat;
    private String name; //Cách lấy  : Join từ bảng tripsTransport theo tripId đã tồn tại trong bảng transportId
    private String tripsTransportDepartTime; // Cách lấy   : getAll() Lấy từ bảng tripsTransport

//    ----------------Thông tin của xe----------------
    private String nameOfTransport;
    private String imageName;
    private String licensePlate;
    private String description;
    private int totalSeat;

    public TripsTransportWithRoutes() {
    }

    public TripsTransportWithRoutes(long id, long tripsTransportId, int emptySeat,String name, String tripsTransportDepartTime, String nameOfTransport, String imageName, String licensePlate, String description, int totalSeat) {
        this.id = id;
        this.tripsTransportId = tripsTransportId;
        this.emptySeat = emptySeat;
        this.name = name;
        this.tripsTransportDepartTime = tripsTransportDepartTime;
        this.nameOfTransport = nameOfTransport;
        this.imageName = imageName;
        this.licensePlate = licensePlate;
        this.description = description;
        this.totalSeat = totalSeat;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTripsTransportId() {
        return tripsTransportId;
    }

    public void setTripsTransportId(long tripsTransportId) {
        this.tripsTransportId = tripsTransportId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmptySeat() {
        return emptySeat;
    }

    public void setEmptySeat(int emptySeat) {
        this.emptySeat = emptySeat;
    }

    public String getTripsTransportDepartTime() {
        return tripsTransportDepartTime;
    }

    public void setTripsTransportDepartTime(String tripsTransportDepartTime) {
        this.tripsTransportDepartTime = tripsTransportDepartTime;
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

    @Override
    public String toString() {
        return "TripsTransportWithRoutes{" +
                "id=" + id +
                ", tripsTransportId=" + tripsTransportId +
                ", name='" + name + '\'' +
                ", emptySeat='" + emptySeat + '\'' +
                ", tripsTransportDepartTime='" + tripsTransportDepartTime + '\'' +
                ", nameOfTransport='" + nameOfTransport + '\'' +
                ", imageName='" + imageName + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", description='" + description + '\'' +
                ", totalSeat=" + totalSeat +
                '}';
    }
}

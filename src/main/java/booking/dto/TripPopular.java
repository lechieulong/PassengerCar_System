package booking.dto;

public class TripPopular {
    private long tripsTransportId;
    private String nameOfTransport;
    private String imageName;
    private String tripName;
    private String timeOfTrips;
    private int totalSeat;

    public TripPopular() {
    }

    public TripPopular(long tripsTransportId, String nameOfTransport, String imageName, String tripName, String timeOfTrips, int totalSeat) {
        this.tripsTransportId = tripsTransportId;
        this.nameOfTransport = nameOfTransport;
        this.imageName = imageName;
        this.tripName = tripName;
        this.timeOfTrips = timeOfTrips;
        this.totalSeat = totalSeat;
    }

    public long getTripsTransportId() {
        return tripsTransportId;
    }

    public void setTripsTransportId(long tripsTransportId) {
        this.tripsTransportId = tripsTransportId;
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

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public String getTimeOfTrips() {
        return timeOfTrips;
    }

    public void setTimeOfTrips(String timeOfTrips) {
        this.timeOfTrips = timeOfTrips;
    }

    public int getTotalSeat() {
        return totalSeat;
    }

    public void setTotalSeat(int totalSeat) {
        this.totalSeat = totalSeat;
    }

    @Override
    public String toString() {
        return "TripPopular{" +
                "tripsTransportId=" + tripsTransportId +
                ", nameOfTransport='" + nameOfTransport + '\'' +
                ", imageName='" + imageName + '\'' +
                ", tripName='" + tripName + '\'' +
                ", timeOfTrips='" + timeOfTrips + '\'' +
                ", totalSeat=" + totalSeat +
                '}';
    }
}

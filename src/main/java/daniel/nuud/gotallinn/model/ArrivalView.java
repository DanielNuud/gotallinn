package daniel.nuud.gotallinn.model;

public interface ArrivalView {
    String getStopId();
    String getStopName();
    String getArrivalTime();
    String getDepartureTime();
    String getTripId();
    String getTripHeadsign();
    String getDirectionCode();
    String getRouteShortName();
}

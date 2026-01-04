package daniel.nuud.gotallinn.repository;

import daniel.nuud.gotallinn.model.ArrivalView;
import daniel.nuud.gotallinn.model.StopTime;
import daniel.nuud.gotallinn.model.StopTimeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StopTimeRepository extends JpaRepository<StopTime, StopTimeId> {
    @Query(value = """
        SELECT
            s.stop_id      AS stopId,
            s.stop_name    AS stopName,
            st.arrival_time   AS arrivalTime,
            st.departure_time AS departureTime,
            t.trip_id         AS tripId,
            t.trip_headsign   AS tripHeadsign,
            t.direction_code  AS directionCode,
            r.route_short_name AS routeShortName
        FROM stop_times st
        JOIN trips t   ON t.trip_id = st.trip_id
        JOIN routes r  ON r.route_id = t.route_id
        JOIN stops s   ON s.stop_id = st.stop_id
        WHERE st.stop_id = :stopId
        ORDER BY st.arrival_time, t.trip_id
        """,
            nativeQuery = true)
    List<ArrivalView> findArrivalsByStopId(@Param("stopId") String stopId);
}

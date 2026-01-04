package daniel.nuud.gotallinn.data;

import daniel.nuud.gotallinn.model.*;
import daniel.nuud.gotallinn.repository.RouteRepository;
import daniel.nuud.gotallinn.repository.StopRepository;
import daniel.nuud.gotallinn.repository.StopTimeRepository;
import daniel.nuud.gotallinn.repository.TripRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
@RequiredArgsConstructor
public class DataImport {

    private final StopRepository stopRepository;
    private final RouteRepository routeRepository;
    private final TripRepository tripRepository;
    private final StopTimeRepository stopTimeRepository;

    public void saveDataStops(Path path) {

        CSVFormat format = CSVFormat.DEFAULT
                .builder()
                .setHeader()
                .setSkipHeaderRecord(true)
                .setDelimiter(',')
                .build();

        try (Reader reader = Files.newBufferedReader(path);
             CSVParser parser = new CSVParser(reader, format)) {

            for (CSVRecord record : parser) {
                String stopId      = record.get("stop_id");
                String stopCode    = record.get("stop_code");
                String stopName    = record.get("stop_name");
                String latStr      = record.get("stop_lat");
                String lonStr      = record.get("stop_lon");
                String zoneId      = record.get("zone_id");
                String alias       = record.get("alias");
                String stopArea    = record.get("stop_area");
                String stopDesc    = record.get("stop_desc");
                String lestXStr    = record.get("lest_x");
                String lestYStr    = record.get("lest_y");
                String zoneName    = record.get("zone_name");
                String authority   = record.get("authority");

                Double lat   = parseDoubleOrNull(latStr);
                Double lon   = parseDoubleOrNull(lonStr);
                Double lestX = parseDoubleOrNull(lestXStr);
                Double lestY = parseDoubleOrNull(lestYStr);

                Stop stop = new Stop();
                stop.setStopId(stopId);
                stop.setStopCode(stopCode);
                stop.setStopName(stopName);
                stop.setStopLat(lat);
                stop.setStopLon(lon);
                stop.setZoneId(zoneId);
                stop.setAlias(alias);
                stop.setStopArea(stopArea);
                stop.setStopDesc(stopDesc);
                stop.setLestX(lestX);
                stop.setLestY(lestY);
                stop.setZoneName(zoneName);
                stop.setAuthority(authority);

                stopRepository.save(stop);
            }
        } catch (IOException e) {

        }

    }

    public void saveDataRoutes(Path path) {

        CSVFormat format = CSVFormat.DEFAULT
                .builder()
                .setHeader()
                .setSkipHeaderRecord(true)
                .setDelimiter(',')
                .build();

        try (Reader reader = Files.newBufferedReader(path);
             CSVParser parser = new CSVParser(reader, format)) {

            for (CSVRecord record : parser) {
                Route route = new Route();
                route.setRouteId(record.get("route_id"));
                route.setRouteColor(record.get("route_color"));
                route.setRouteDesc(record.get("route_desc"));
                route.setRouteType(Integer.parseInt(record.get("route_type")));
                route.setRouteLongName(record.get("route_long_name"));
                route.setRouteShortName(record.get("route_short_name"));
                route.setAgencyId(record.get("agency_id"));
                route.setCompetentAuthority(record.get("competent_authority"));
                routeRepository.save(route);
            }
        } catch (IOException e) {

        }

    }

    public void saveDataTrips(Path path) {

        CSVFormat format = CSVFormat.DEFAULT
                .builder()
                .setHeader()
                .setSkipHeaderRecord(true)
                .setDelimiter(',')
                .build();

        try (Reader reader = Files.newBufferedReader(path);
             CSVParser parser = new CSVParser(reader, format)) {

            for (CSVRecord record : parser) {
                Trip trip = new Trip();
                trip.setRouteId(record.get("route_id"));
                trip.setServiceId(record.get("service_id"));
                trip.setTripId(record.get("trip_id"));
                trip.setTripHeadsign(record.get("trip_headsign"));
                trip.setTripLongName(record.get("trip_long_name"));
                trip.setDirectionCode(record.get("direction_code"));
                trip.setShapeId(record.get("shape_id"));
                trip.setWheelchairAccessible(Integer.parseInt(record.get("wheelchair_accessible")));

                tripRepository.save(trip);
            }
        } catch (IOException e) {

        }

    }


    public void saveDataStopTimes(Path path) {

        CSVFormat format = CSVFormat.DEFAULT
                .builder()
                .setHeader()
                .setSkipHeaderRecord(true)
                .setDelimiter(',')
                .build();

        try (Reader reader = Files.newBufferedReader(path);
             CSVParser parser = new CSVParser(reader, format)) {

            for (CSVRecord record : parser) {


                StopTimeId stopTimeId = new StopTimeId();
                stopTimeId.setTripId(record.get("trip_id"));
                stopTimeId.setStopSequence(Integer.parseInt(record.get("stop_sequence")));

                StopTime stopTime = new StopTime();
                stopTime.setId(stopTimeId);
                stopTime.setArrivalTime(record.get("arrival_time"));
                stopTime.setDepartureTime(record.get("departure_time"));
                stopTime.setStopId(record.get("stop_id"));
                stopTime.setPickupType(Integer.parseInt(record.get("pickup_type")));
                stopTime.setDropOffType(Integer.parseInt(record.get("drop_off_type")));

                stopTimeRepository.save(stopTime);
            }
        } catch (IOException e) {

        }

    }



    private Double parseDoubleOrNull(String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        return Double.parseDouble(value);
    }
}

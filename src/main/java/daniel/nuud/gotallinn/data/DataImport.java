package daniel.nuud.gotallinn.data;

import daniel.nuud.gotallinn.model.*;
import daniel.nuud.gotallinn.repository.*;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class DataImport implements CommandLineRunner {

    Path pathOfStops = Paths.get("src/main/resources/files/stops.txt");
    Path pathOfRoutes = Paths.get("src/main/resources/files/routes.txt");
    Path pathOfTrips = Paths.get("src/main/resources/files/trips.txt");
    Path pathOfStoptimes = Paths.get("src/main/resources/files/stop_times.txt");
    Path pathOfCalendar = Paths.get("src/main/resources/files/calendar.txt");
    Path pathOfCalendarDates = Paths.get("src/main/resources/files/calendar_dates.txt");
    Path pathOfAgency = Paths.get("src/main/resources/files/agency.txt");

    private final StopRepository stopRepository;
    private final RouteRepository routeRepository;
    private final TripRepository tripRepository;
    private final StopTimeRepository stopTimeRepository;
    private final CalendarDateRepository calendarDateRepository;
    private final CalendarRepository calendarRepository;
    private final AgencyRepository agencyRepository;

    @Override
    public void run(String... args) throws Exception {

//        saveDataAgency(pathOfAgency);
//        saveDataCalendar(pathOfCalendar);
//        saveDataStops(pathOfStops);
//
//        saveDataRoutes(pathOfRoutes);
//
//        saveDataTrips(pathOfTrips);
//
//        saveDataStopTimes(pathOfStoptimes);
//        saveDataCalendarDate(pathOfCalendarDates);
    }

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

    public void saveDataAgency(Path path) {
        CSVFormat format = CSVFormat.DEFAULT
                .builder()
                .setHeader()
                .setSkipHeaderRecord(true)
                .setDelimiter(',')
                .build();

        try (Reader reader = Files.newBufferedReader(path);
             CSVParser parser = new CSVParser(reader, format)) {

            for (CSVRecord record : parser) {
                Agency agency = new Agency();
                agency.setAgencyId(record.get("agency_id"));
                agency.setAgencyName(record.get("agency_name"));
                agency.setAgencyUrl(record.get("agency_url"));
                agency.setAgencyTimezone(record.get("agency_timezone"));
                agency.setAgencyPhone(record.get("agency_phone"));
                agency.setAgencyLang(record.get("agency_lang"));

                agencyRepository.save(agency);
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
                String agencyId = record.get("agency_id");
                Agency agency = agencyRepository.findById(agencyId)
                        .orElseThrow(() -> new RuntimeException("agency not found" + agencyId));

                route.setAgency(agency);
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
                String routeId = record.get("route_id");

                Route route = routeRepository.findById(routeId)
                        .orElseThrow(() -> new RuntimeException("route not found" + routeId));
                trip.setRoute(route);

                String calendarId = record.get("service_id");
                Calendar calendar = calendarRepository.findById(calendarId)
                                .orElseThrow(() -> new RuntimeException("calendar not found" + calendarId));

                trip.setCalendar(calendar);
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

                String stopId =  record.get("stop_id");
                Stop stop = stopRepository.findById(stopId)
                        .orElseThrow(() -> new RuntimeException("stop not found" + stopId));

                stopTime.setStop(stop);
                stopTime.setPickupType(Integer.parseInt(record.get("pickup_type")));
                stopTime.setDropOffType(Integer.parseInt(record.get("drop_off_type")));

                stopTimeRepository.save(stopTime);
            }
        } catch (IOException e) {

        }

    }

    public void saveDataCalendar(Path path) {

        CSVFormat format = CSVFormat.DEFAULT
                .builder()
                .setHeader()
                .setSkipHeaderRecord(true)
                .setDelimiter(',')
                .build();

        try (Reader reader = Files.newBufferedReader(path);
             CSVParser parser = new CSVParser(reader, format)) {

            for (CSVRecord record : parser) {

                Calendar calendar = new Calendar();
                calendar.setServiceId(record.get("service_id"));
                calendar.setMonday(Integer.parseInt(record.get("monday")) == 1);
                calendar.setTuesday(Integer.parseInt(record.get("tuesday")) == 1);
                calendar.setWednesday(Integer.parseInt(record.get("wednesday")) == 1);
                calendar.setThursday(Integer.parseInt(record.get("thursday")) == 1);
                calendar.setFriday(Integer.parseInt(record.get("friday")) == 1);
                calendar.setSaturday(Integer.parseInt(record.get("saturday")) == 1);
                calendar.setSunday(Integer.parseInt(record.get("sunday")) == 1);

                calendar.setStartDate(parseGtfsDate(record.get("start_date")));
                calendar.setEndDate(parseGtfsDate(record.get("end_date")));

                calendarRepository.save(calendar);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveDataCalendarDate(Path path) {

        CSVFormat format = CSVFormat.DEFAULT
                .builder()
                .setHeader()
                .setSkipHeaderRecord(true)
                .setDelimiter(',')
                .build();

        try (Reader reader = Files.newBufferedReader(path);
             CSVParser parser = new CSVParser(reader, format)) {

            for (CSVRecord record : parser) {

                CalendarDate calendarDate = new CalendarDate();

                String serviceId = record.get("service_id");
                Calendar calendar = calendarRepository.findById(serviceId)
                        .orElseThrow(() -> new RuntimeException("Calendar not found: " + serviceId));

                calendarDate.setCalendar(calendar);
                calendarDate.setExceptionType(Integer.parseInt(record.get("exception_type")));

                calendarDateRepository.save(calendarDate);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Date parseGtfsDate(String dateStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException("Failed to parse date: " + dateStr, e);
        }
    }

    private Double parseDoubleOrNull(String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        return Double.parseDouble(value);
    }
}

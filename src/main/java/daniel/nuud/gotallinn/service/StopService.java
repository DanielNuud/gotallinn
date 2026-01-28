package daniel.nuud.gotallinn.service;

import daniel.nuud.gotallinn.data.DataImport;
import daniel.nuud.gotallinn.model.ArrivalView;
import daniel.nuud.gotallinn.repository.StopTimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Component
@RequiredArgsConstructor
public class StopService implements CommandLineRunner {

    private final DataImport dataImport;

    Path pathOfStops = Paths.get("src/main/resources/files/stops.txt");
    Path pathOfRoutes = Paths.get("src/main/resources/files/routes.txt");
    Path pathOfTrips = Paths.get("src/main/resources/files/trips.txt");
    Path pathOfStoptimes = Paths.get("src/main/resources/files/stop_times.txt");
    Path pathOfCalendar = Paths.get("src/main/resources/files/calendar.txt");
    Path pathOfCalendarDates = Paths.get("src/main/resources/files/calendar_dates.txt");
    Path pathOfAgency = Paths.get("src/main/resources/files/agency.txt");

    @Override
    public void run(String... args) {

        dataImport.saveDataAgency(pathOfAgency);
        dataImport.saveDataCalendar(pathOfCalendar);
        dataImport.saveDataStops(pathOfStops);

        dataImport.saveDataRoutes(pathOfRoutes);

        dataImport.saveDataTrips(pathOfTrips);

        dataImport.saveDataStopTimes(pathOfStoptimes);
        dataImport.saveDataCalendarDate(pathOfCalendarDates);

        System.out.println("Ready");

//        String stopId = "162579";
//
//        List<ArrivalView> arrivals = stopTimeRepository.findArrivalsByStopId(stopId);
//
//        arrivals.stream()
//                .limit(20)
//                .forEach(a -> System.out.printf(
//                        "%s | %s | %s -> маршрут %s (%s)%n",
//                        a.getArrivalTime(),
//                        a.getStopName(),
//                        a.getTripId(),
//                        a.getRouteShortName(),
//                        a.getDirectionCode()
//                ));
    }
}

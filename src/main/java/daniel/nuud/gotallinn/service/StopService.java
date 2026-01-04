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
    private final StopTimeRepository stopTimeRepository;

    Path pathOfStops = Paths.get("src/main/resources/files/stops.txt");
    Path pathOfRoutes = Paths.get("src/main/resources/files/routes.txt");
    Path pathOfTrips = Paths.get("src/main/resources/files/trips.txt");
    Path pathOfStoptimes = Paths.get("src/main/resources/files/stop_times.txt");

    @Override
    public void run(String... args) {
//        dataImport.saveDataStops(pathOfStops);
//        dataImport.saveDataRoutes(pathOfRoutes);
//        dataImport.saveDataTrips(pathOfTrips);
//        dataImport.saveDataStopTimes(pathOfStoptimes);

        String stopId = "162579"; // подставь свой

        List<ArrivalView> arrivals = stopTimeRepository.findArrivalsByStopId(stopId);

        arrivals.stream()
                .limit(20)
                .forEach(a -> System.out.printf(
                        "%s | %s | %s -> маршрут %s (%s)%n",
                        a.getArrivalTime(),
                        a.getStopName(),
                        a.getTripId(),
                        a.getRouteShortName(),
                        a.getDirectionCode()
                ));
    }
}

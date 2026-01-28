package daniel.nuud.gotallinn.service;


import daniel.nuud.gotallinn.model.ArrivalView;
import daniel.nuud.gotallinn.model.Route;
import daniel.nuud.gotallinn.repository.RouteRepository;
import daniel.nuud.gotallinn.repository.StopTimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TimetableService {

    private final StopTimeRepository stopTimeRepository;
    private final RouteRepository routeRepository;

    public List<ArrivalView> getArrivalsByStopId(String stopId) {
        return stopTimeRepository.findArrivalsByStopId(stopId);
    }

    public List<Route> getRoutesByAgencyId(String agencyId) {
        return routeRepository.findByAgencyId(agencyId);
    }

}

package daniel.nuud.gotallinn.service;


import daniel.nuud.gotallinn.model.Route;
import daniel.nuud.gotallinn.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TimetableService {

    private final StopTimeRepository stopTimeRepository;
    private final RouteRepository routeRepository;
    private final AgencyRepository agencyRepository;
    private final CalendarRepository calendarRepository;
    private final StopRepository stopRepository;
    private final CalendarDateRepository calendarDateRepository;

    public List<Route> getRoutesByAgencyId(String agencyId) {
        return routeRepository.findByAgencyId(agencyId);
    }



}

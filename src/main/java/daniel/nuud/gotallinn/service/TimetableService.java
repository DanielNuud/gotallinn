package daniel.nuud.gotallinn.service;


import daniel.nuud.gotallinn.dto.RouteDTO;
import daniel.nuud.gotallinn.mapper.RouteMapper;
import daniel.nuud.gotallinn.model.Calendar;
import daniel.nuud.gotallinn.model.Route;
import daniel.nuud.gotallinn.model.Trip;
import daniel.nuud.gotallinn.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TimetableService {

    private final StopTimeRepository stopTimeRepository;
    private final RouteRepository routeRepository;
    private final AgencyRepository agencyRepository;
    private final CalendarRepository calendarRepository;
    private final StopRepository stopRepository;
    private final CalendarDateRepository calendarDateRepository;
    private final RouteMapper routeMapper;
    private final TripRepository tripRepository;

    public List<Route> getRoutesByAgencyId(String agencyId) {
        return routeRepository.findByAgencyId(agencyId);
    }

    public List<RouteDTO> getRoutesDTOByAgencyId(String agencyId) {

        List<Route> routes = routeRepository.findByAgencyId(agencyId);

        return routeRepository.findByAgencyId(agencyId).stream()
                .map(route -> {
                    Trip firstTrip = tripRepository.findFirstByRoute_RouteId(route.getRouteId());
                    Calendar calendar = firstTrip != null ? firstTrip.getCalendar() : null;

                    return routeMapper.toRouteDTO(route, calendar);

                })
                .sorted(Comparator.comparing(RouteDTO::routeShortName))
                .collect(Collectors.toList());
    }


}

package daniel.nuud.gotallinn.controller;

import daniel.nuud.gotallinn.model.ArrivalView;
import daniel.nuud.gotallinn.model.Route;
import daniel.nuud.gotallinn.repository.RouteRepository;
import daniel.nuud.gotallinn.service.TimetableService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/routes")
@RequiredArgsConstructor
public class RouteController {

    private final TimetableService timetableService;

    @GetMapping("/{agencyId}")
    public List<Route> getRoutesByAgency(@PathVariable String agencyId) {
        return timetableService.getRoutesByAgencyId(agencyId);
    }
}

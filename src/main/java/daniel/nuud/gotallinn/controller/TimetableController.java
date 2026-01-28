package daniel.nuud.gotallinn.controller;

import daniel.nuud.gotallinn.model.ArrivalView;
import daniel.nuud.gotallinn.service.TimetableService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/stops")
@RequiredArgsConstructor
public class TimetableController {

    private final TimetableService timetableService;

    @GetMapping("/{stopId}")
    public List<ArrivalView> getArrivals(@PathVariable String stopId) {
        return timetableService.getArrivalsByStopId(stopId);
    }
}

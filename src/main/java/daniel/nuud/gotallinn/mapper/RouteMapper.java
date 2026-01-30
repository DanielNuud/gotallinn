package daniel.nuud.gotallinn.mapper;

import daniel.nuud.gotallinn.dto.RouteDTO;
import daniel.nuud.gotallinn.model.Calendar;
import daniel.nuud.gotallinn.model.Route;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Getter
public class RouteMapper {

    public RouteDTO toRouteDTO(Route route, Calendar calendar) {
        return new RouteDTO(route.getRouteShortName(),
                route.getRouteLongName(),
                route.getRouteColor(),
                getRouteTypeName(route.getRouteType()),
                calendar.getMonday(),
                calendar.getTuesday(),
                calendar.getWednesday(),
                calendar.getThursday(),
                calendar.getFriday(),
                calendar.getSaturday(),
                calendar.getSunday()
                );
    }

    private String getRouteTypeName(Integer routeType) {
        return switch (routeType) {
            case 0 -> "Tram";
            case 3 -> "Bus";
            case 1 -> "Trolleybus";
            default -> "Unknown";
        };
    }
}

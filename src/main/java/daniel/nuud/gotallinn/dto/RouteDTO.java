package daniel.nuud.gotallinn.dto;

import lombok.Data;

public record RouteDTO (
        String routeShortName,
        String routeLongName,
        String routeColor
) {}

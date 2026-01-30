package daniel.nuud.gotallinn.dto;

public record RouteDTO (
        String routeShortName,
        String routeLongName,
        String routeColor,
        String routeType,
        boolean monday,
        boolean tuesday,
        boolean wednesday,
        boolean thursday,
        boolean friday,
        boolean saturday,
        boolean sunday
) {}

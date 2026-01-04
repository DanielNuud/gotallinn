package daniel.nuud.gotallinn.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "trips")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Trip {

    @Column(name = "route_id")
    private String routeId;

    @Column(name = "service_id")
    private String serviceId;

    @Id
    @Column(name = "trip_id")
    private String tripId;

    @Column(name = "trip_headsign")
    private String tripHeadsign;

    @Column(name = "trip_long_name")
    private String tripLongName;

    @Column(name = "direction_code")
    private String directionCode;

    @Column(name = "shape_id")
    private String shapeId;

    @Column(name = "wheelchair_accessible")
    private Integer wheelchairAccessible;

}

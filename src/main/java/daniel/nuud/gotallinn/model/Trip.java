package daniel.nuud.gotallinn.model;

import jakarta.persistence.*;
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

    @Id
    @Column(name = "trip_id")
    private String tripId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id")
    private Route route;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id")
    private Calendar calendar;

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

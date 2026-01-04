package daniel.nuud.gotallinn.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "stops")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Stop {

    @Id
    @Column(name = "stop_id")
    private String stopId;

    @Column(name = "stop_code")
    private String stopCode;

    @Column(name = "stop_name")
    private String stopName;

    @Column(name = "stop_lat")
    private Double stopLat;

    @Column(name = "stop_lon")
    private Double stopLon;

    @Column(name = "zone_id")
    private String zoneId;

    private String alias;

    @Column(name = "stop_area")
    private String stopArea;

    @Column(name = "stop_desc")
    private String stopDesc;

    @Column(name = "lest_x")
    private Double lestX;

    @Column(name = "lest_y")
    private Double lestY;

    @Column(name = "zone_name")
    private String zoneName;

    private String authority;

}

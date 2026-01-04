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
@Table(name = "routes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Route {

    @Id
    @Column(name = "route_id")
    private String routeId;

    @Column(name = "agency_id")
    private String agencyId;

    @Column(name = "route_short_name")
    private String routeShortName;

    @Column(name = "route_long_name")
    private String routeLongName;

    @Column(name = "route_type")
    private Integer routeType;

    @Column(name = "route_color")
    private String routeColor;

    @Column(name = "competent_authority")
    private String competentAuthority;

    @Column(name = "route_desc", columnDefinition = "TEXT")
    private String routeDesc;
}

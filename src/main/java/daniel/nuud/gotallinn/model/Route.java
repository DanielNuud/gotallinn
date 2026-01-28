package daniel.nuud.gotallinn.model;

import jakarta.persistence.*;
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "agency_id")
    private Agency agency;

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

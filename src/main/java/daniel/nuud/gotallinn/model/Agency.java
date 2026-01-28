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
@Table(name = "agency")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Agency {

    @Id
    @Column(name = "agency_id")
    private String agencyId;

    @Column(name = "agency_name")
    private String agencyName;

    @Column(name = "agency_url")
    private String agencyUrl;

    @Column(name = "agency_timezone")
    private String agencyTimezone;

    @Column(name = "agency_phone")
    private String agencyPhone;

    @Column(name = "agency_lang")
    private String agencyLang;
}

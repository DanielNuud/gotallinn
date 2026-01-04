package daniel.nuud.gotallinn.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StopTimeId implements Serializable {

    @Column(name = "trip_id")
    private String tripId;

    @Column(name = "stop_sequence")
    private Integer stopSequence;
}

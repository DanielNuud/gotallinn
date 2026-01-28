package daniel.nuud.gotallinn.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "calendar_dates")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CalendarDate {

    @EmbeddedId
    private CalendarDateId id;

    @ManyToOne
    @JoinColumn(name = "service_id", insertable = false, updatable = false)
    private Calendar calendar;

    @Column(name = "exception_type")
    private Integer exceptionType;

}

package daniel.nuud.gotallinn.repository;

import daniel.nuud.gotallinn.model.CalendarDate;
import daniel.nuud.gotallinn.model.CalendarDateId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarDateRepository extends JpaRepository<CalendarDate, CalendarDateId> {
}

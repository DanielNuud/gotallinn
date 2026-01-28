package daniel.nuud.gotallinn.repository;

import daniel.nuud.gotallinn.model.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, String> {
}

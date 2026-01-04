package daniel.nuud.gotallinn.repository;

import daniel.nuud.gotallinn.model.Stop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StopRepository extends JpaRepository<Stop, String> {
}

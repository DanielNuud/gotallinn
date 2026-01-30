package daniel.nuud.gotallinn.repository;

import daniel.nuud.gotallinn.model.Agency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, String> {
}

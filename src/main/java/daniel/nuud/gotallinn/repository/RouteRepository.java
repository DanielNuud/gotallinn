package daniel.nuud.gotallinn.repository;

import daniel.nuud.gotallinn.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route, String> {
    @Query("SELECT r FROM Route r WHERE r.agency.agencyId = :agencyId")
    List<Route> findByAgencyId(@Param("agencyId") String agencyId);
}

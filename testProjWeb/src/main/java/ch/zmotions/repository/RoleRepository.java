package ch.zmotions.repository;

import ch.zmotions.domain.RoleEO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleRepository extends JpaRepository<RoleEO, Long>{

    @Query("SELECT r FROM RoleEO r")
    List<RoleEO> fullFetch();

    RoleEO findByName(String role);
}

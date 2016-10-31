package ch.zmotions.repository;

import ch.zmotions.domain.UserEO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEO, Long>, UserRepositoryCustom {

    @Query("SELECT u FROM UserEO u")
    List<UserEO> fullFetch();
}

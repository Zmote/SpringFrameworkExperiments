package ch.zmotions.repository;

import ch.zmotions.domain.UserEO;
import org.hibernate.annotations.OrderBy;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEO, Long>, UserRepositoryCustom {
    @Query("SELECT u FROM UserEO u " +
            "LEFT JOIN FETCH u.role " +
            "ORDER BY u")
    List<UserEO> fullFetch();

    UserEO findByPk(Long id);
}

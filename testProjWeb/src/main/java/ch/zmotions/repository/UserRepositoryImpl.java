package ch.zmotions.repository;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

public class UserRepositoryImpl implements UserRepositoryCustom {
    @Autowired
    EntityManager em;

    @Autowired
    UserRepository userRepository;

    public List filterAgeFullFetchWith(Integer filter){
        Session session = em.unwrap(Session.class);
        session.enableFilter("ageFilter").setParameter("ageParam", filter);
        return userRepository.fullFetch();
    }
}

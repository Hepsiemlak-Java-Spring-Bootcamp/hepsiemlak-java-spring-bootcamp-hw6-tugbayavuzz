package emlakburada.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import emlakburada.model.Advert;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdvertRepository extends JpaRepository<Advert, Integer> {

    Optional<Advert> findByAdvertNo(int advertNo);

}

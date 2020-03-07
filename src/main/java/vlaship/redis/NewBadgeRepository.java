package vlaship.redis;

import org.springframework.data.repository.CrudRepository;

public interface NewBadgeRepository extends CrudRepository<NewBadge, Long> {

    Iterable<NewBadge> findAllByUserId(String userId);

    void deleteAllByUserId(String userId);

}

package vlaship.redis;

import java.util.ArrayList;
import java.util.List;

public interface NewBadgeService {

    void deleteAll();

    void deleteAll(String userId);

    Long create(NewBadge newBadge);

    List<NewBadge> pollAll(String userId);

    List<NewBadge> findAll(String userId);

    List<NewBadge> findAll();

    default List<NewBadge> convert(final Iterable<NewBadge> newBadges) {
        final List<NewBadge> badges = new ArrayList<>();
        newBadges.forEach(badges::add);
        return badges;
    }
}

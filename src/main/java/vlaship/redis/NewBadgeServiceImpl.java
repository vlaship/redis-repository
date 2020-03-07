package vlaship.redis;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@RequiredArgsConstructor
@Service
public class NewBadgeServiceImpl implements NewBadgeService {

    private final NewBadgeRepository repository;

    @Override
    public Long create(final NewBadge newBadge) {
        return repository.save(newBadge).getId();
    }

    @Override
    public List<NewBadge> pollAll(final String userId) {
        final Iterable<NewBadge> badges = repository.findAllByUserId(userId);
        repository.deleteAllByUserId(userId);
        return convert(badges);
    }

    @Override
    public List<NewBadge> findAll(String userId) {
        final Iterable<NewBadge> badges = repository.findAllByUserId(userId);
        return convert(badges);
    }

    @Override
    public List<NewBadge> findAll() {
        return convert(repository.findAll());
    }

    @Override
    public void deleteAll(final String userId) {
        repository.deleteAllByUserId(userId);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

}

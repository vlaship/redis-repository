package vlaship.redis;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

@Data
@RedisHash("NewBadge")
public class NewBadge implements Serializable {

    @Id
    private Long id;
    @Indexed
    private String userId;
    private String badgeId;

}


package vlaship.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
//@RequestMapping("/notification")
public class Controller {

    private final NewBadgeService service;

    @PostMapping("/newbadge")
    public ResponseEntity<Long> create(@RequestBody NewBadge newBadge) {
        return new ResponseEntity<>(service.create(newBadge), HttpStatus.CREATED);
    }

    @GetMapping("/newbadges/{userId}")
    public ResponseEntity<List<NewBadge>> find(@PathVariable String userId) {
        return new ResponseEntity<>(service.findAll(userId), HttpStatus.OK);
    }

    @DeleteMapping("/newbadges/{userId}")
    public ResponseEntity delete(@PathVariable String userId) {
        service.deleteAll(userId);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/newbadges")
    public ResponseEntity<List<NewBadge>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/newbadges")
    public ResponseEntity deleteAll() {
        service.deleteAll();
        return ResponseEntity.accepted().build();
    }
}

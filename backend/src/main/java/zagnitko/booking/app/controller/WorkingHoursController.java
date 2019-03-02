package zagnitko.booking.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zagnitko.booking.app.entity.Working;
import zagnitko.booking.app.service.WorkingHoursService;

@RestController
@RequestMapping("/booking/api/working")
public class WorkingHoursController {

    private final WorkingHoursService workingHoursService;

    /**
     * Constructor.
     * @param workingHoursService - workingHoursService.
     */
    @Autowired
    public WorkingHoursController(WorkingHoursService workingHoursService) {
        this.workingHoursService = workingHoursService;
    }

    /**
     * Get working hours by id.
     * @param workingHoursId - working hours id.
     * @return working hours.
     */
    @GetMapping(value = "/{workingHoursId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> getWorkingHoursById(@PathVariable("workingHoursId") Long workingHoursId) {
        return ResponseEntity.ok(workingHoursService.findOne(workingHoursId));
    }

    /**
     * Save working hours.
     * @param working - working hours data.
     * @return saved working hours.
     */
    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Working> saveWorkingHours(@RequestBody Working working) {
        Working savedWorking = workingHoursService.saveWorkingHours(working);
        return ResponseEntity.ok(savedWorking);
    }

}

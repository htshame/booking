package zagnitko.booking.app.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zagnitko.booking.app.dto.WorkingHoursDTO;
import zagnitko.booking.app.exception.WorkingHoursNotFoundException;
import zagnitko.booking.app.service.WorkingHoursService;

@RestController
@RequestMapping("/booking/api/working")
public class WorkingHoursController {

    private static final Logger LOG = LoggerFactory.getLogger(WorkingHoursController.class);

    private final WorkingHoursService workingHoursService;

    /**
     * Constructor.
     *
     * @param workingHoursService - workingHoursService.
     */
    @Autowired
    public WorkingHoursController(WorkingHoursService workingHoursService) {
        this.workingHoursService = workingHoursService;
    }

    /**
     * Get working hours by id.
     *
     * @param workingHoursId - working hours id.
     * @return working hours.
     * @throws WorkingHoursNotFoundException - WorkingHoursNotFoundException.
     */
    @GetMapping(value = "/{workingHoursId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<WorkingHoursDTO> getWorkingHoursById(@PathVariable("workingHoursId") Long workingHoursId)
            throws WorkingHoursNotFoundException {
        LOG.info("Searching for working hours by id {}.", workingHoursId);
        WorkingHoursDTO workingHoursDTO = workingHoursService.findWorkingHoursById(workingHoursId);
        LOG.info("Search for working hours by id {} was successful.", workingHoursId);
        return ResponseEntity.ok(workingHoursDTO);
    }

    /**
     * Save working hours.
     *
     * @param workingDto - working hours data.
     * @return saved working hours.
     */
    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<WorkingHoursDTO> saveWorkingHours(@RequestBody @Valid WorkingHoursDTO workingDto) {
        LOG.info("Trying to save working hours.");
        WorkingHoursDTO savedWorkingData = workingHoursService.saveWorkingHours(workingDto);
        LOG.info("Working hours were saved successfully.");
        return ResponseEntity.ok(savedWorkingData);
    }

}

package zagnitko.booking.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zagnitko.booking.app.dto.WorkingHoursDTO;
import zagnitko.booking.app.entity.Working;
import zagnitko.booking.app.exception.WorkingHoursNotFoundException;
import zagnitko.booking.app.repository.WorkingHoursRepository;

@Service
public class WorkingHoursService {

    private static final Logger LOG = LoggerFactory.getLogger(WorkingHoursService.class);

    private final WorkingHoursRepository workingHoursRepository;

    /**
     * Constructor.
     *
     * @param workingHoursRepository - workingHoursRepository.
     */
    @Autowired
    public WorkingHoursService(WorkingHoursRepository workingHoursRepository) {
        this.workingHoursRepository = workingHoursRepository;
    }

    /**
     * Get working hours by id.
     *
     * @param id - working hours record id.
     * @return working hours.
     */
    public WorkingHoursDTO findWorkingHoursById(Long id) throws WorkingHoursNotFoundException {
        Working working = workingHoursRepository.findOne(id);
        if (working == null) {
            LOG.error("Working hours not found by id {}.", id);
            throw new WorkingHoursNotFoundException();
        }
        return working.toWorkingHoursDTO();
    }

    /**
     * Save working hours.
     *
     * @param workingDto - working hours to save.
     * @return saved working hours.
     */
    public WorkingHoursDTO saveWorkingHours(WorkingHoursDTO workingDto) {
        Working working = workingHoursRepository.save(new Working(workingDto));
        return working.toWorkingHoursDTO();
    }
}

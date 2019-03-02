package zagnitko.booking.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zagnitko.booking.app.entity.Working;
import zagnitko.booking.app.repository.WorkingHoursRepository;

@Service
public class WorkingHoursService {

    private final WorkingHoursRepository workingHoursRepository;

    @Autowired
    public WorkingHoursService(WorkingHoursRepository workingHoursRepository) {
        this.workingHoursRepository = workingHoursRepository;
    }

    /**
     * Get working hours by id.
     * @param id - working hours record id.
     * @return working hours.
     */
    public Working findOne(Long id) {
        return workingHoursRepository.findOne(id);
    }

    /**
     * Save working hours.
     * @param working - working hours to save.
     * @return saved working hours.
     */
    public Working saveWorkingHours(Working working) {
        return workingHoursRepository.save(working);
    }
}

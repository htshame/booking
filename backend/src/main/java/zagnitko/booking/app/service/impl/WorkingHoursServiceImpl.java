package zagnitko.booking.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zagnitko.booking.app.entity.Working;
import zagnitko.booking.app.repository.WorkingHoursRepository;
import zagnitko.booking.app.service.WorkingHoursService;

@Service
public class WorkingHoursServiceImpl implements WorkingHoursService {

	@Autowired
    private WorkingHoursRepository repository;
	
	@Override
	public Working findOne() {
		return repository.findOne(1L);
	}

	@Override
	public void save(Working working) {
		repository.save(working);
	}
}

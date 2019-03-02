package zagnitko.booking.app.service;

import zagnitko.booking.app.entity.Working;

public interface WorkingHoursService {

    Working findOne();

    void save(Working working);
}

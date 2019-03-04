package zagnitko.booking.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Working hours not found.")
public class WorkingHoursNotFoundException extends Exception {
    private static final long serialVersionUID = 5360086707604087194L;
}

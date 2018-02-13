package zagnitko.booking.app.controller;

import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zagnitko.booking.app.entity.Working;
import zagnitko.booking.app.service.WorkingHoursService;

@RestController
@RequestMapping("/booking/api/working")
public class WorkingHoursController {

	@Autowired
	private WorkingHoursService service;

	@RequestMapping(value = "/get", method = GET, produces = {"application/json"})
    public ResponseEntity<Object> get() {
        return new ResponseEntity<Object>(service.findOne(), HttpStatus.OK);
    }

	@RequestMapping(value = "/save", method = PUT, produces = {"application/json"})
    public ResponseEntity<Object> save(String workingStart, String workingEnd) {
		service.save(new Working(workingStart, workingEnd));
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

}

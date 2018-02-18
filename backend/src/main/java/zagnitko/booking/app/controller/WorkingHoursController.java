package zagnitko.booking.app.controller;

import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.Date;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@RequestMapping(value = "/save", method = POST, produces = {"application/json"})
    public ResponseEntity<Object> save(@RequestBody Working working) {
		service.save(new Working(working.getWorkingStart(), working.getWorkingEnd()));
        return new ResponseEntity<Object>("success", HttpStatus.OK);
    }

}

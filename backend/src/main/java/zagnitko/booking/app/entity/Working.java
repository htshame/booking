package zagnitko.booking.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import zagnitko.booking.app.dto.WorkingHoursDTO;

@Entity
@Table(name = "WORKING")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Working {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "working_start")
    private String workingStart;

    @Column(name = "working_end")
    private String workingEnd;

    public Working() {

    }

    public Working(WorkingHoursDTO workingHoursDTO) {
        this.id = workingHoursDTO.getId();
        this.workingStart = workingHoursDTO.getWorkingStart();
        this.workingEnd = workingHoursDTO.getWorkingEnd();
    }

    public WorkingHoursDTO toWorkingHoursDTO() {
        WorkingHoursDTO workingHoursDTO = new WorkingHoursDTO();
        workingHoursDTO.setId(this.id);
        workingHoursDTO.setWorkingStart(this.workingStart);
        workingHoursDTO.setWorkingEnd(this.workingEnd);
        return workingHoursDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWorkingStart() {
        return workingStart;
    }

    public void setWorkingStart(String workingStart) {
        this.workingStart = workingStart;
    }

    public String getWorkingEnd() {
        return workingEnd;
    }

    public void setWorkingEnd(String workingEnd) {
        this.workingEnd = workingEnd;
    }

}

package zagnitko.booking.app.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import zagnitko.booking.app.entity.Working;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkingHoursDTO {

    private Long id;

    @NotNull
    private String workingStart;

    @NotNull
    private String workingEnd;

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

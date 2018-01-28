import { Component } from '@angular/core';
import { WorkingService } from './working.service';

@Component({
    moduleId: module.id,  
    selector: 'working',
    templateUrl: './working.component.html',
    styleUrls: ['./working.component.css']
})
export class WorkingComponent {

    workingHours: any;

    timeFrom: any;
    timeTo: any; 

    constructor(private workingService: WorkingService) {
        this.workingService.getWorkingHours().subscribe(data => {
            this.workingHours = data;
        });
        this.timeFrom = "09:00";
        this.timeTo = "17:30";
    }
    
    setWorkingHours() {
        let data: any = {};
        data.timeFrom = this.timeFrom;
        data.timeTo = this.timeTo;
        this.workingService.setWorkingHours(data).subscribe(data => {
        });
    }
}

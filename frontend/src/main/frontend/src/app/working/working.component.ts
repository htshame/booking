import { Component } from '@angular/core';
import { WorkingService } from './working.service';
import { ToasterService } from 'angular5-toaster/dist';

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

    constructor(private workingService: WorkingService, private toasterService: ToasterService) {
        this.workingService.getWorkingHours().subscribe(data => {
            this.workingHours = data;
        });
        this.timeFrom = new Date(null, null, null, 9, 30);
        this.timeTo = new Date(null, null, null, 17, 30);
    }

    setWorkingHours() {
        let data: any = {};
        data.timeFrom = this.timeFrom;
        data.timeTo = this.timeTo;
        this.workingService.setWorkingHours(data).subscribe(data => {
        	this.toasterService.pop('success', 'Success', 'Working hours were set successfully!');
        }, err => {
            this.toasterService.pop('error', 'Error', 'Error saving working hours!');
            console.log(err);
        });
    }
}

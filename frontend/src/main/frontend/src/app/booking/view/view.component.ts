import {Component} from '@angular/core';
import {ViewService} from './view.service';

@Component({
  moduleId: module.id,
  selector: 'view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.css']
})
export class ViewComponent {
  public meetings: any;

  constructor(private viewService: ViewService) {
    this.viewService.getMeetings().subscribe(data => {
      this.meetings = data;
    });
  }
}

import {Component} from '@angular/core';
import {MainService} from './main.service';
import {animate, keyframes, query, stagger, style, transition, trigger} from '@angular/animations';

@Component({
  moduleId: module.id,
  selector: 'main',
  templateUrl: 'main.component.html',
  styleUrls: ['main.component.css'],
  animations: [
    trigger('openHelp', [
      transition(':enter', [
        style({transform: 'translateX(-100%)', opacity: 0}),
        animate('300ms', style({transform: 'translateX(0)', opacity: 1}))
      ]),
      transition(':leave', [
        style({transform: 'translateX(0)', opacity: 1}),
        animate('300ms', style({transform: 'translateX(-100%)', opacity: 0}))
      ])
    ])
  ]
})

export class MainComponent {

  public isHelpOpen: boolean = false;

  constructor(private mainService: MainService) {
  }

  openHelp() {
    this.isHelpOpen = !this.isHelpOpen;
  }
}

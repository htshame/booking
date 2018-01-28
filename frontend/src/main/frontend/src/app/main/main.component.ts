import { Component } from '@angular/core';
import { MainService } from './main.service';

@Component({
    moduleId: module.id,
    selector: 'main',
    templateUrl: 'main.component.html',
    styleUrls: ['main.component.css']
})

export class MainComponent {

    constructor(private mainService: MainService) {
    }
} 

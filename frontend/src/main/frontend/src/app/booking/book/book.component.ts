import { Component } from '@angular/core';
import { BookService } from './book.service';
import { HttpInterceptor } from './../../http/http.interceptor';

@Component({
    moduleId: module.id,  
    selector: 'book',
    templateUrl: './book.component.html',
    styleUrls: ['./book.component.css']
})
export class BookComponent {
     constructor(private bookService: BookService) {
    }

    bookingDate: any;
    startTime: any; 
    duration: any; 

    bookMeeting() {
        let data: any = {};
        data.bookingDate = this.bookingDate;
        data.startTime = this.startTime;
        data.duration = this.duration;
        this.bookService.bookMeeting(data).subscribe(data => {
        });
    }
}

import { Component } from '@angular/core';
import { BookService } from './book.service';
import { HttpInterceptor } from './../../http/http.interceptor';
import { ToasterService } from 'angular5-toaster/dist';

@Component({
    moduleId: module.id,
    selector: 'book',
    templateUrl: './book.component.html',
    styleUrls: ['./book.component.css']
})
export class BookComponent {
    constructor(private bookService: BookService, private toasterService: ToasterService) {
    }

    public bookingStart: any;
    public bookingEnd: any; 

    bookMeeting() {
        let data: any = {};
        data.bookingStart = this.bookingStart;
        data.bookingEnd = this.bookingEnd;
        this.bookService.bookMeeting(data).subscribe(data => {
        	this.toasterService.pop('success', 'Success', 'Room was booked successfully!');
        }, err => {
            this.toasterService.pop('error', 'Error', 'Error booking the room!');
            console.log(err);
        });
    }
}

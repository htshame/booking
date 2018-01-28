import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpInterceptor } from './../../http/http.interceptor';

@Injectable()
export class BookService {

    constructor(private http: HttpInterceptor) {
    }

    bookMeeting(data): Observable<any> {
        return this.http.post('/booking/api/book/book', data).map(res => res.json());
    }
}

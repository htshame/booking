import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpInterceptor } from './../../http/http.interceptor';

@Injectable()
export class ViewService {

    constructor(private http: HttpInterceptor) {
    }
    
    getMeetings(): Observable<any> {
        return this.http.get('booking/book/get', null).map(res => res.json());
    }
}

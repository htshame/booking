import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpInterceptor } from './../http/http.interceptor';

@Injectable()
export class WorkingService {

    constructor(private http: HttpInterceptor) {
    }

    getWorkingHours(): Observable<any> {
        return this.http.get('booking/working/getData', null).map(res => res.json());
    }

    setWorkingHours(data): Observable<any> {
        return this.http.post('booking/working/setData', data).map(res => res.json());
    }

}

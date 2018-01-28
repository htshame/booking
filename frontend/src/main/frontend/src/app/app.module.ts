import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpModule, JsonpModule, RequestOptions, XHRBackend } from '@angular/http';
import { HashLocationStrategy, LocationStrategy } from '@angular/common';

import { HttpInterceptor } from './http/http.interceptor';  
import { WindowRef } from './environments/window.ref';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { MainComponent } from './main/main.component';
import { MainService } from './main/main.service';
import { WorkingComponent } from './working/working.component';
import { WorkingService } from './working/working.service';
import { BookComponent } from './booking/book/book.component';
import { BookService } from './booking/book/book.service';
import { ViewComponent } from './booking/view/view.component';
import { ViewService } from './booking/view/view.service';

export function httpFactory(backend: XHRBackend, options: RequestOptions, window: WindowRef, router: Router) {
    return new HttpInterceptor(backend, options, window, router);
} 

@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    WorkingComponent,
    BookComponent,
    ViewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    FormsModule,
    HttpModule
  ],
  providers: [
    MainService,
    WindowRef,
    WorkingService,
    BookService,
    ViewService,
    {provide: LocationStrategy, useClass: HashLocationStrategy},
    {provide: HttpInterceptor, useFactory: httpFactory, deps: [XHRBackend, RequestOptions, WindowRef, Router]}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

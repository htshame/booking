import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MainComponent } from './main/main.component';
import { WorkingComponent } from './working/working.component';
import { BookComponent } from './booking/book/book.component';
import { ViewComponent } from './booking/view/view.component';

const routes: Routes = [
    {
        path: 'main',
        component: MainComponent
    }, {
        path: 'working',
        component: WorkingComponent
    }, {
        path: 'book',
        component: BookComponent
    }, {
        path: 'view',
        component: ViewComponent
    }, {
        path: '**',
        redirectTo: 'main'
    }
];

@NgModule({
    imports: [ RouterModule.forRoot(routes, {useHash: true}) ],
    exports: [ RouterModule ]
})

export class AppRoutingModule {};

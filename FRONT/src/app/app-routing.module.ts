import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { BugListComponent } from './bug-list/bug-list.component';
import { DeveloperListComponent } from './developer-list/developer-list.component';
import { MenuComponent } from './menu/menu.component';

const routes: Routes = [
  { path: 'developer', component: DeveloperListComponent },
  { path: '', component: BugListComponent },  // you must add your component here
  //{ path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

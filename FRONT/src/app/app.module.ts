import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { DragDropModule } from '@angular/cdk/drag-drop';

// search module
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { BugListComponent } from './bug-list/bug-list.component';
import { DeveloperListComponent } from './developer-list/developer-list.component';

import { SharedService } from './shared.service';

import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    BugListComponent,
    DeveloperListComponent
  ],
  exports: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    DragDropModule,
    Ng2SearchPipeModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  
  providers: [SharedService],
  bootstrap: [AppComponent]
})
export class AppModule { }

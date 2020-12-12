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
import { ShowDevComponent } from './developer-list/show-dev/show-dev.component';
import { AddEditDevComponent } from './developer-list/add-edit-dev/add-edit-dev.component';
import { BugDetailComponent } from './bug-detail/bug-detail.component';
import { EditBugComponent } from './bug-detail/edit-bug/edit-bug.component';
import { ShowBugComponent } from './bug-detail/show-bug/show-bug.component';
import { AddEditCommentComponent } from './bug-detail/add-edit-comment/add-edit-comment.component';
import { AddBugComponent } from './bug-list/add-bug/add-bug.component';



@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    BugListComponent,
    DeveloperListComponent,
    ShowDevComponent,
    AddEditDevComponent,
    BugDetailComponent,
    EditBugComponent,
    ShowBugComponent,
    AddEditCommentComponent,
    AddBugComponent
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

import { Component } from '@angular/core';
import { CdkDragDrop, moveItemInArray, transferArrayItem } from '@angular/cdk/drag-drop';
import { Input, OnChanges, SimpleChanges } from '@angular/core';


/**
 * @title Basic Drag&Drop
 */

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {


  msg: string = "";

  recherche: string = "";

  filter: string = "";

  constructor() {
  
  }
  
  searchText: any;

  todo = [
    { id: 11, name: 'Mr. Nice'},
    { id: 12, name: 'Narco'},
    { id: 13, name: 'Bombasto'}
  ];

  inprogress = [
    { id: 14, name: 'Celeritas'},
    { id: 15, name: 'Magneta'},
    { id: 16, name: 'RubberMan'}
  ];

  done = [
    { id: 17, name: 'Dynama'},
    { id: 18, name: 'Dr IQ'},
    { id: 19, name: 'Magma'},
    { id: 20, name: 'Tornado'}
  ];

  drop(event: CdkDragDrop<any>) {
    if (event.previousContainer === event.container) {
      moveItemInArray(event.container.data, event.previousIndex, event.currentIndex);
    } else {
      transferArrayItem(event.previousContainer.data,
        event.container.data,
        event.previousIndex,
        event.currentIndex);
    }
  }
}


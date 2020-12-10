import { Component, OnInit } from '@angular/core';
import { CdkDragDrop, moveItemInArray, transferArrayItem } from '@angular/cdk/drag-drop';
import { Input, OnChanges, SimpleChanges } from '@angular/core';
import { Router } from '@angular/router';

import { SharedService } from 'src/app/shared.service';


@Component({
  selector: 'app-bug-list',
  templateUrl: './bug-list.component.html',
  styleUrls: ['./bug-list.component.css']
})
export class BugListComponent implements OnInit {



  searchText: any;

  bugs: any;

  bugsTODO: any;

  bugsINPROGRESS: any;

  bugsDONE: any;

  constructor(
    private service: SharedService, private router: Router) { }


  ngOnInit(): void {
    //this.bugs = this.service.getBugs();
    this.bugsTODO = this.service.getBugsEtatTODO();
    this.bugsINPROGRESS = this.service.getBugsEtatINPROGRESS();
    this.bugsDONE = this.service.getBugsEtatDONE();
  }

  refreshDevList() {
    this.service.getBugs().subscribe(data => {
      this.bugs = data;
    });
  }











  /*
  msg: string = "";

  recherche: string = "";


  

  bug: any;

  bugTODO: any;

  bugINPROGRESS: any;

  bugDONE: any;


  urlApi = 'http://localhost:8000';  // URL de l'API

  urlApiDelete = 'http://localhost:8000/bugs/1';  // URL de l'API

  urlApiTODO = 'http://localhost:8000/bugs2/TO_DO';  // URL de l'API

  urlApiINPROGRESS = 'http://localhost:8000/bugs2/IN_PROGRESS';  // URL de l'API

  urlApiDONE = 'http://localhost:8000/bugs2/DONE';  // URL de l'API
  
  todo = [];

  constructor(private router: Router, private http: HttpClient) {
    /*this.bugTODO = this.http.get(this.urlApiTODO);
    this.bugINPROGRESS = this.http.get(this.urlApiINPROGRESS);
    this.bugDONE = this.http.get(this.urlApiDONE);*/
    //this.bug = this.http.get(this.urlApi);
    //this.bug.forEach(element => this.todo.push(element));

    //this.http.delete(this.urlApi);


    //this.http.put(this.urlApi,this.inprogress).

    //this.urlApi.put(this.urlApi);
/*
  }

  ngOnInit(): void {
  }



  /*

  todo = [
    { id: 11, name: 'Mr. Nice' },
    { id: 12, name: 'Narco' },
    { id: 13, name: 'Bombasto' }
  ];*/

  /*inprogress = [
    { id: 14, name: 'Celeritas' },
    { id: 15, name: 'Magneta' },
    { id: 16, name: 'RubberMan' }
  ];

  done = [
    { id: 17, name: 'Dynama' },
    { id: 18, name: 'Dr IQ' },
    { id: 19, name: 'Magma' },
    { id: 20, name: 'Tornado' }
  ];*/















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

  gotoHome() {
    this.router.navigate(['']);  // define your component where you want to go
  }
}

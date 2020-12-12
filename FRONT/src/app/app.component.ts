import { Component } from '@angular/core';
import { CdkDragDrop, moveItemInArray, transferArrayItem } from '@angular/cdk/drag-drop';
import { Input, OnChanges, SimpleChanges } from '@angular/core';
import { Router } from '@angular/router';

import { HttpClient, HttpParams, HttpHeaders} from '@angular/common/http';

import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';

import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/retry';
import 'rxjs/add/observable/of';

import { catchError } from 'rxjs/operators';
import { HttpErrorHandler, HandleError } from './http-error-handler.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})


export class AppComponent {



  comments: any;

  urlApi = 'http://localhost:8000/developers';  // URL de l'API

  constructor(
    private http: HttpClient) { this.comments = this.http.get(this.urlApi); }


  getPosts() {

    this.comments = this.http.get(this.urlApi);
  }

}

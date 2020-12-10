import { Component } from '@angular/core';
import { CdkDragDrop, moveItemInArray, transferArrayItem } from '@angular/cdk/drag-drop';
import { Input, OnChanges, SimpleChanges } from '@angular/core';
import { Router } from '@angular/router';

import { HttpClient, HttpParams, HttpHeaders} from '@angular/common/http';

import { Comment } from './post';
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
    private http: HttpClient) { this.comments = this.http.get(this.urlApi);}
  
 
  getPosts() {

    this.comments = this.http.get(this.urlApi);
  } 





  /*readonly ROOT_URL = 'https://jsonplaceholder.typicode.com';

  //posts: any;

  posts: Observable<any> = new Observable();
  newPost: Observable<any> = new Observable();
  
  constructor(private http: HttpClient) {}

  getPosts() {

    let params = new HttpParams().set('userId', '1');

    let headers = new HttpHeaders().set('Authorization','auth-token');

    this.posts = this.http.get(this.ROOT_URL + '/posts', { params, headers });
  }*/
  /*
  createPost() {
    const data: Post = {
      id: 25,
      userId: 23,
      title: 'My New Post',
      body: 'Hello World!'
    }

    this.newPost = this.http.post<Post>(this.ROOT_URL + '/foo', data)
      .retry(3)
      .catch(err => {
        console.log()
        return Observable.of(err)
      })
  }*/

}

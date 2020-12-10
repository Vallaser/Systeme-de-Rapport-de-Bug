import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SharedService {

  readonly APIUrl = "http://localhost:8000";
  
  constructor(private http: HttpClient) { }


  getBugs(): Observable<any[]> {
    return this.http.get<any>(this.APIUrl + '/bugs');
  }

  getBugsEtatTODO(): Observable<any[]> {
    return this.http.get<any>(this.APIUrl + '/bugs2/TO_DO');
  }

  getBugsEtatINPROGRESS(): Observable<any[]> {
    return this.http.get<any>(this.APIUrl + '/bugs2/IN_PROGRESS');
  }

  getBugsEtatDONE(): Observable<any[]> {
    return this.http.get<any>(this.APIUrl + '/bugs2/DONE');
  }

  createBug(val: any) {
    return this.http.post(this.APIUrl + '/bugs', val);
  }


  updateBug(val: any) {
    return this.http.put(this.APIUrl + '/bugs', val);
  }

  deleteBug(val: any) {
    return this.http.delete(this.APIUrl + '/bugs', val);
  }

  getComments(): Observable<any[]> {
    return this.http.get<any>(this.APIUrl + '/comments');
  }


  createComment(val: any) {
    return this.http.post(this.APIUrl + '/comments', val);
  }


  deleteComment(val: any) {
    return this.http.delete(this.APIUrl + '/comments', val);
  }

  getDevelopers(): Observable<any[]> {
    return this.http.get<any>(this.APIUrl + '/developers');
  }


  createDeveloper(val: any) {
    return this.http.post(this.APIUrl + '/developers', val);
  }

  updateDeveloper(val: any) {
    return this.http.put(this.APIUrl + '/developers/{id}/avatar=/{avatar}', val);
  }

  deleteDeveloper(val: any) {
    return this.http.delete(this.APIUrl + '/developers/'+val.id_developer);
  }
}

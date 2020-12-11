import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Bug } from './bug';

@Injectable({
  providedIn: 'root'
})
export class SharedService {

  readonly APIUrl = "http://localhost:8000";
  
  constructor(private http: HttpClient) { }


  getBugs(): Observable<any[]> {
    return this.http.get<any>(this.APIUrl + '/bugs');
  }

  getBug(id:number): Observable<any[]> {
    return this.http.get<any>(this.APIUrl + '/bugs/'+id);
  }

  getBugsEtatTODO(): Observable<any[]> {
    return this.http.get<any>(this.APIUrl + '/bugs/etat/TO_DO');
  }

  getBugsEtatINPROGRESS(): Observable<any[]> {
    return this.http.get<any>(this.APIUrl + '/bugs/etat/IN_PROGRESS');
  }

  getBugsEtatDONE(): Observable<any[]> {
    return this.http.get<any>(this.APIUrl + '/bugs/etat/DONE');
  }

  getBugsIndexAndEtatTODO(index:number): Observable<any[]> {
    return this.http.get<any>(this.APIUrl + '/bugs/'+index+'/etat/TO_DO');
  }

  getBugsIndexAndEtatINPROGRESS(index: number): Observable<any[]> {
    return this.http.get<any>(this.APIUrl + '/bugs/' + index + '/etat/IN_PROGRESS');
  }

  getBugsIndexAndEtatDONE(index: number): Observable<any[]> {
    return this.http.get<any>(this.APIUrl + '/bugs/' + index + '/etat/DONE');
  }

  getBugTab(id: number): Observable<Bug> {
    return this.http.get<Bug>(this.APIUrl + '/bugstab/' + id);
  }

  getDeveloperByBug(id: number):Observable<any[]> {
    return this.http.get<any>(this.APIUrl + '/bugsdeveloper/' + id);
  }

  getCommentsByBug(id: number): Observable<any[]> {
    return this.http.get<any>(this.APIUrl + '/bugscomments/' + id);
  }

  /*getIdByBug(index: number, etat: string): Observable<number>{
    return this.http.get<number>(this.APIUrl + '/bugsGetId/'+index+'/etat/'+etat);
  }*/

  createBug(val: any) {
    return this.http.post(this.APIUrl + '/bugs', val);
  }

  updateBugEtat(val: any) {
    return this.http.put(this.APIUrl + '/bugs/' + val.id_bug + '/etat=' + val.etat, val);
  }
 
  updateBugDescription(val: any) {
    return this.http.put(this.APIUrl + '/bugs/'+val.id_bug+'/description='+val.description, val);
  }

  updateBugPriority(val: any) {
    return this.http.put(this.APIUrl + '/bugs/' + val.id_bug + '/priority=' + val.priority, val);
  }

  updateBugTitle(val: any) {
    return this.http.put(this.APIUrl + '/bugs/' + val.id_bug + '/title=' + val.title, val);
  }

  deleteBug(id_bug: number) {
    return this.http.delete(this.APIUrl + '/bugs/'+id_bug);
  }

  getComments(): Observable<any[]> {
    return this.http.get<any>(this.APIUrl + '/comments');
  }


  createComment(val: any) {
    return this.http.post(this.APIUrl + '/comments', val);
  }

  updateCommentComment(val: any) {
    return this.http.put(this.APIUrl + '/comments/' + val.id_comment + '/comment=' + val.comment, val);
  }

  updateDateComment(val: any) {
    return this.http.put(this.APIUrl + '/bugs/' + val.date_comment + '/datecomment=' + val.date_comment, val);
  }


  deleteComment(val: any) {
    return this.http.delete(this.APIUrl + '/comments/'+val.id_comment, val);
  }

  getDevelopers(): Observable<any[]> {
    return this.http.get<any>(this.APIUrl + '/developers');
  }

  getDevByCommentId(id: number): Observable<any[]> {
    return this.http.get<any>(this.APIUrl + '/commentsDev/'+id);
  }


  createDeveloper(val: any) {
    return this.http.post(this.APIUrl + '/developers', val);
  }

  updateDeveloper(val: any) {
    return this.http.put(this.APIUrl + '/developers/'+val.id_developer+'/avatar='+val.avatar,val);
  }

  deleteDeveloper(val: any) {
    return this.http.delete(this.APIUrl + '/developers/'+val.id_developer);
  }
}

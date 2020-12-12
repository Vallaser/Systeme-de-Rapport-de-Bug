import { Component, OnInit } from '@angular/core';
import { CdkDragDrop, moveItemInArray, transferArrayItem } from '@angular/cdk/drag-drop';
import { Input, OnChanges, SimpleChanges } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
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
  bug: any;
  ModalTitle: string = "";
  ActivateAddBugComp: boolean = false;

  constructor(
    private service: SharedService, private router: Router) { }


  ngOnInit(): void {
    this.bugsTODO = this.service.getBugsEtatTODO();
    this.bugsINPROGRESS = this.service.getBugsEtatINPROGRESS();
    this.bugsDONE = this.service.getBugsEtatDONE();
  }

  refreshDevList() {
    this.service.getBugs().subscribe(data => {
      this.bugs = data;
    });
  }

  navigate(id:number) {
    this.router.navigate(['bug', id]);

  }

  addClick() {
    this.bug = {
      id_bug: 0
    }
    this.ModalTitle = "Add Bug";
    this.ActivateAddBugComp = true;
  }

  closeBugClick() {
    this.ActivateAddBugComp = false;
    this.bugsTODO = this.service.getBugsEtatTODO();
    this.bugsINPROGRESS = this.service.getBugsEtatINPROGRESS();
    this.bugsDONE = this.service.getBugsEtatDONE();
  }

  addBug(val:any) {
    this.service.createBug(val).subscribe();
  }

  deleteClick(item: any) {
    if (confirm('Are you sure ?')) {
      this.service.deleteBug(item.id_bug).subscribe(data => {
        this.bugsTODO = this.service.getBugsEtatTODO();
        this.bugsINPROGRESS = this.service.getBugsEtatINPROGRESS();
        this.bugsDONE = this.service.getBugsEtatDONE();
      });
    }
  }

  updateBugEtat(val:any,id:number,etat:string) {
    this.bugsTODO = this.service.getBugsEtatTODO();
    this.bugsINPROGRESS = this.service.getBugsEtatINPROGRESS();
    this.bugsDONE = this.service.getBugsEtatDONE();
  }

  drop(event: CdkDragDrop<any>) {
    if (event.previousContainer === event.container) {
    }
    else {
      if (event.previousContainer.id == "cdk-drop-list-0" && event.container.id == "cdk-drop-list-1") {
        if (confirm(this.bugsTODO[event.previousIndex])) {
          
        }
      }
      else if (event.previousContainer.id == "cdk-drop-list-0" && event.container.id == "cdk-drop-list-2") {
        if (confirm(event.previousContainer.id)) {

        }
      }
      else if (event.previousContainer.id == "cdk-drop-list-1" && event.container.id == "cdk-drop-list-0") {
        if (confirm(event.previousContainer.id)) {

        }
      }
      else if (event.previousContainer.id == "cdk-drop-list-1" && event.container.id == "cdk-drop-list-2") {
        if (confirm(event.previousContainer.id)) {

        }
      }
      else if (event.previousContainer.id == "cdk-drop-list-2" && event.container.id == "cdk-drop-list-0") {
        if (confirm(event.previousContainer.id)) {

        }
      }
      else if (event.previousContainer.id == "cdk-drop-list-2" && event.container.id == "cdk-drop-list-1") {
        if (confirm(event.previousContainer.id)) {

        }
      }
    }
  }

  gotoHome() {
    this.router.navigate(['']);
  }
}

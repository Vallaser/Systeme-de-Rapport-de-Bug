import { Component, OnInit } from '@angular/core';
import { SharedService } from 'src/app/shared.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-show-dev',
  templateUrl: './show-dev.component.html',
  styleUrls: ['./show-dev.component.css']
})
export class ShowDevComponent implements OnInit {

  developers: any;

  ModalTitle: string = "";
  ActivateAddEditDevComp: boolean = false;
  dev: any;


  constructor(private router: Router,
    private service: SharedService) { }


  ngOnInit(): void {
    this.developers = this.service.getDevelopers();
    //this.refreshDevList();
  }


  addClick() {
    this.dev = {
      id_developer: 0,
      name: ""
    }
    this.ModalTitle = "Add Developer";
    this.ActivateAddEditDevComp = true;
  }


  editClick(item:any) {
    this.dev = item;
    this.ModalTitle = "Edit Department";
    this.ActivateAddEditDevComp = true;
  }

  deleteClick(item: any) {
    if (confirm('Are you sure ?')) {
      this.service.deleteDeveloper(item).subscribe(data => {
        this.developers = this.service.getDevelopers();
      });
      //this.router.navigateByUrl('developer');
      //this.developers = this.service.getDevelopers();
    }
  }



  closeClick() {
    this.ActivateAddEditDevComp = false;
    this.developers = this.service.getDevelopers();
  }


  refreshDevList() {
    this.service.getDevelopers().subscribe(data => {
      this.developers = data;
    });
  }

}

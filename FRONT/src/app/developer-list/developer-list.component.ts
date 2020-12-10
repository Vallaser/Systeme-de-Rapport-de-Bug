import { Component, OnInit } from '@angular/core';
import { SharedService } from 'src/app/shared.service';

@Component({
  selector: 'app-developer-list',
  templateUrl: './developer-list.component.html',
  styleUrls: ['./developer-list.component.css']
})
export class DeveloperListComponent implements OnInit {

  developers: any;

  constructor(
    private service:SharedService) {  }


  ngOnInit(): void {
    this.developers = this.service.getDevelopers();
    //this.developers = this.refreshDevList();
  }

  refreshDevList() {
    this.service.getDevelopers().subscribe(data => {
      this.developers = data;
    });
  }
  
}

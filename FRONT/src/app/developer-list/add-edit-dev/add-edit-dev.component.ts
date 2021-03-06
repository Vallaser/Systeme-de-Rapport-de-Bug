import { Component, OnInit, Input } from '@angular/core';
import { SharedService } from 'src/app/shared.service';

@Component({
  selector: 'app-add-edit-dev',
  templateUrl: './add-edit-dev.component.html',
  styleUrls: ['./add-edit-dev.component.css']
})
export class AddEditDevComponent implements OnInit {

  constructor(private service:SharedService) { }

  @Input() dev: any;
  id_developer: number=0;
  name: string = "";
  avatar: string = "";

  ngOnInit(): void {
    this.id_developer = this.dev.id_developer;
    this.name = this.dev.name;
    this.avatar = this.dev.avatar;
  }


  addDeveloper() {
    var val = {
      name: this.name,
      avatar: this.avatar
    };
    this.service.createDeveloper(val).subscribe();
  }

  updateDeveloper() {
    var val = {
      id_developer: this.id_developer,
      name: this.name,
      avatar: this.avatar
    };
    this.service.updateDeveloper(val).subscribe();
      
  }

}

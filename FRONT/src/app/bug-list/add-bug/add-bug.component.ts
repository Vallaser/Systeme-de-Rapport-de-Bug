import { Component, OnInit } from '@angular/core';
import { SharedService } from 'src/app/shared.service';

@Component({
  selector: 'app-add-bug',
  templateUrl: './add-bug.component.html',
  styleUrls: ['./add-bug.component.css']
})
export class AddBugComponent implements OnInit {

  constructor(private service: SharedService) { }

  

  id_bug: number = 0;
  title: string = "";
  description: string = "";
  etat: string = "";
  priority: string = "";



  ngOnInit(): void {
    
  }


  addBug() {
    var val = {
      id_bug: this.id_bug,
      title: this.title,
      description: this.description,
      etat: this.etat,
      priority: this.priority
    };
    this.service.createBug(val).subscribe();
  }


}

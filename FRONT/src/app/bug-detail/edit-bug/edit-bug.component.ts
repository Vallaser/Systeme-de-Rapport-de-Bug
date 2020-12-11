import { Component, OnInit, Input} from '@angular/core';
import { SharedService } from 'src/app/shared.service';

@Component({
  selector: 'app-edit-bug',
  templateUrl: './edit-bug.component.html',
  styleUrls: ['./edit-bug.component.css']
})
export class EditBugComponent implements OnInit {

  constructor(private service: SharedService) { }

  @Input() bug: any;
  id_bug: number = 0;
  title: string = "";
  description: string = "";
  priority: string = "";
  etat: string = "";
  

  ngOnInit(): void {
    this.id_bug = this.bug.id_bug;
    this.title = this.bug.title;
    this.description = this.bug.description;
    this.priority = this.bug.priority;
    this.etat = this.bug.etat;
    
  }

  updateBug() {
    var val = {
      id_bug: this.id_bug,
      title: this.title,
      description: this.description,
      priority: this.priority,
      etat: this.etat
    };
    this.service.updateBugDescription(val).subscribe();
    this.service.updateBugEtat(val).subscribe();
    this.service.updateBugPriority(val).subscribe();
    this.service.updateBugTitle(val).subscribe();
  }
}

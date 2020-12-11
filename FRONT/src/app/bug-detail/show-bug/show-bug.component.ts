import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Subscription } from 'rxjs';
import { SharedService } from 'src/app/shared.service';

@Component({
  selector: 'app-show-bug',
  templateUrl: './show-bug.component.html',
  styleUrls: ['./show-bug.component.css']
})
export class ShowBugComponent implements OnInit {

  bugs: any;
  dev: any;
  comments: any;
  bug: any;

  ModalTitle: string = "";
  ActivateEditBugComp: boolean = false;

  private subscription: Subscription = new Subscription();

  id: number = 0;

  constructor(private service: SharedService, private router: Router, activatedRoute: ActivatedRoute) {
    this.subscription = activatedRoute.params.subscribe(
      (param: any) => this.id = param['id']
    );

    this.bugs = this.service.getBugTab(this.id);
    this.dev = this.service.getDeveloperByBug(this.id);
    this.comments = this.service.getCommentsByBug(this.id);
    this.ActivateEditBugComp = false;
  }

  ngOnInit(): void {


  }

  editClick(item: any) {
    this.bug = item;
    this.ModalTitle = "Edit Bug";
    this.ActivateEditBugComp = true;
  }

  deleteClick(item: any) {
    if (confirm('Are you sure ?')) {
      this.service.deleteBug(item.id_bug).subscribe(data => {
        this.router.navigateByUrl('');
      });
    }
  }


  closeClick() {
    this.ActivateEditBugComp = false;
    this.bugs = this.service.getBugTab(this.id);
    this.dev = this.service.getDeveloperByBug(this.id);
    this.comments = this.service.getCommentsByBug(this.id);
  }

}

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
  devs: any;
  comments: any;
  bug: any;
  comment: any;

  ModalTitle: string = "";
  ActivateEditBugComp: boolean = false;
  ActivateAddEditCommentComp: boolean = false;

  private subscription: Subscription = new Subscription();

  id_bug: number = 0;

  constructor(private service: SharedService, private router: Router, activatedRoute: ActivatedRoute) {
    this.subscription = activatedRoute.params.subscribe(
      (param: any) => this.id_bug = param['id']
    );

    this.bugs = this.service.getBugTab(this.id_bug);
    this.devs = this.service.getDeveloperByBug(this.id_bug);
    this.comments = this.service.getCommentsByBug(this.id_bug);
    this.ActivateEditBugComp = false;
  }

  ngOnInit(): void {


  }

  editBugClick(bug: any) {
    this.bug = bug;
    this.ModalTitle = "Edit Bug";
    this.ActivateEditBugComp = true;
  }

  deleteBugClick(bug: any) {
    if (confirm('Are you sure ?')) {
      this.service.deleteBug(bug.id_bug).subscribe(data => {
        this.router.navigateByUrl('');
      });
    }
  }


  closeBugClick() {
    this.ActivateEditBugComp = false;
    this.bugs = this.service.getBugTab(this.id_bug);
    this.devs = this.service.getDeveloperByBug(this.id_bug);
    this.comments = this.service.getCommentsByBug(this.id_bug);
  }

  addClick() {
    this.comment = {
      id_comment: 0
    }
    this.ModalTitle = "Add Comment";
    this.ActivateAddEditCommentComp = true;
  }


  editCommentClick(comment: any) {
    this.comment = comment;
    this.ModalTitle = "Edit Comment";
    this.ActivateAddEditCommentComp = true;
  }


  deleteCommentClick(comment: any) {
    if (confirm('Are you sure ?')) {
      this.service.deleteComment(comment).subscribe();
      this.bugs = this.service.getBugTab(this.id_bug);
      this.devs = this.service.getDeveloperByBug(this.id_bug);
      this.comments = this.service.getCommentsByBug(this.id_bug);
    }
  }

  closeCommentClick() {
    this.ActivateAddEditCommentComp = false;
    this.bugs = this.service.getBugTab(this.id_bug);
    this.devs = this.service.getDeveloperByBug(this.id_bug);
    this.comments = this.service.getCommentsByBug(this.id_bug);
  }
}

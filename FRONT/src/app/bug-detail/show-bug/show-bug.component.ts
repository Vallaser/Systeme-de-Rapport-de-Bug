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
  ActivateEditCommentComp: boolean = false;

  private subscription: Subscription = new Subscription();

  id: number = 0;

  constructor(private service: SharedService, private router: Router, activatedRoute: ActivatedRoute) {
    this.subscription = activatedRoute.params.subscribe(
      (param: any) => this.id = param['id']
    );

    this.bugs = this.service.getBugTab(this.id);
    this.devs = this.service.getDeveloperByBug(this.id);
    this.comments = this.service.getCommentsByBug(this.id);
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
      this.service.deleteBug(bug.id_bug).subscribe();
    }
  }


  closeBugClick() {
    this.ActivateEditBugComp = false;
    this.bugs = this.service.getBugTab(this.id);
    this.devs = this.service.getDeveloperByBug(this.id);
    this.comments = this.service.getCommentsByBug(this.id);
  }

  /*
  devcomments: any;

  anyfunction(comment: any) {
    console.log(comment.id_developer);
    this.devcomments = this.service.getDevByCommentId(comment.id);
  }*/



  editCommentClick(comment: any) {
    this.comment = comment;
    this.ModalTitle = "Edit Comment";
    this.ActivateEditCommentComp = true;
  }


  deleteCommentClick(comment: any) {
    if (confirm('Are you sure ?')) {
      this.service.deleteComment(comment).subscribe(data => {
        this.router.navigateByUrl('');
      });
    }
  }

  closeCommentClick() {
    this.ActivateEditCommentComp = false;
    this.bugs = this.service.getBugTab(this.id);
    this.devs = this.service.getDeveloperByBug(this.id);
    this.comments = this.service.getCommentsByBug(this.id);
  }


}

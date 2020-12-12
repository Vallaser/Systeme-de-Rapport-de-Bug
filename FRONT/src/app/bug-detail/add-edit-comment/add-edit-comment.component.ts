import { Component, OnInit, Input } from '@angular/core';
import { SharedService } from 'src/app/shared.service';

@Component({
  selector: 'app-add-edit-comment',
  templateUrl: './add-edit-comment.component.html',
  styleUrls: ['./add-edit-comment.component.css']
})
export class AddEditCommentComponent implements OnInit {

  constructor(private service: SharedService) { }

  @Input() comment: any;
  @Input() id_bug: number = 0;

  id_comment: number = 0;
  comment_text: string = "";



  ngOnInit(): void {
    this.id_bug = this.id_bug;
    this.id_comment = this.comment.id_comment;
    this.comment_text = this.comment.comment;
  }


  addComment() {
    var val = {
      comment: this.comment_text,
      bug_id :  this.id_bug,
      dateComment: "2020-12-12T00:36:55.903Z",
      developer_id: 1

    };
    this.service.createComment(val).subscribe();
  }


  updateComment() {
    var val = {
      id_comment: this.id_comment,
      comment: this.comment_text
    };
    this.service.updateCommentComment(val).subscribe();
    //this.service.updateBugEtat(val).subscribe();
  }

}

import { Component, OnInit, Input } from '@angular/core';
import { SharedService } from 'src/app/shared.service';

@Component({
  selector: 'app-edit-comment',
  templateUrl: './edit-comment.component.html',
  styleUrls: ['./edit-comment.component.css']
})
export class EditCommentComponent implements OnInit {

  constructor(private service: SharedService) { }

  @Input() comment: any;

  id_comment: number = 0;
  comment_text: string = "";
  


  ngOnInit(): void {
    this.id_comment = this.comment.id_comment;
    this.comment_text = this.comment.comment;
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

import {Component, Input, OnInit} from '@angular/core';
import {CommentListItem} from "../../../models/comment-list-item";
import {CommentService} from "../../../services/comment.service";

@Component({
  selector: 'app-comment-list',
  templateUrl: './comment-list.component.html',
  styleUrl: './comment-list.component.css'
})
export class CommentListComponent implements OnInit{

  comments: CommentListItem[] = []
  @Input() postId!: number;

  constructor(private commentService: CommentService) {
  }

  ngOnInit(): void {
    this.commentService.fetchComments(this.postId).subscribe(
      (commentList: CommentListItem[]) => this.comments = commentList)
  }


}

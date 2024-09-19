import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {PostDetails} from "../../models/post-details";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {handleValidationErrors} from "../../utils/validation.handler";
import {CommentFormData} from "../../models/comment-form-data";
import {CommentService} from "../../services/comment.service";
import {PostService} from "../../services/post.service";

@Component({
  selector: 'app-post-details',
  templateUrl: './post-details.component.html',
  styleUrl: './post-details.component.css'
})
export class PostDetailsComponent implements OnInit {

  postId!: number;
  post!: PostDetails;
  showCommentForm: Boolean = false;



  constructor(
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private postService: PostService
  ) {

  }

  ngOnInit(): void {
    this.route.params.subscribe({
      next: params => {
        this.postId = params['id'] as number;
        this.postService.fetchPostById(this.postId).subscribe((postDetails: PostDetails) => {
          next: this.post = postDetails;
        });
      }
    })
  }

  displayCommentForm() {
    this.showCommentForm = !this.showCommentForm;
  }



}

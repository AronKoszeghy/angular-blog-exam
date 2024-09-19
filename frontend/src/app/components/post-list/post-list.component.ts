import {Component, OnInit} from '@angular/core';
import {PostListItem} from "../../models/post-list-item";
import {PostService} from "../../services/post.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-post-list',
  templateUrl: './post-list.component.html',
  styleUrl: './post-list.component.css'
})
export class PostListComponent implements OnInit{

  posts: PostListItem[] = [];

  constructor(
    private postService: PostService,
    private router: Router) {
  }

  ngOnInit(): void {
    this.postService.fetchPosts().subscribe(
      (postList: PostListItem[]) => this.posts = postList)
  }



}

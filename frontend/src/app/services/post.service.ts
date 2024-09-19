import { Injectable } from '@angular/core';
import {PostFormData} from "../models/post-form-data";
import {HttpClient} from "@angular/common/http";
import {PostListItem} from "../models/post-list-item";
import {Observable} from "rxjs";
import {PostDetails} from "../models/post-details";


const BASE_URL = 'http://localhost:8080/api/posts';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private http: HttpClient) { }

  createPost(data: PostFormData) {
    return this.http.post(BASE_URL, data);
  }

  fetchPosts(): Observable<PostListItem[]> {
    return this.http.get<PostListItem[]>(BASE_URL);
  }

  fetchPostById(postId: number): Observable<PostDetails> {
    return this.http.get<PostDetails>(`${BASE_URL}/${postId}`);
  }


}

import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {CommentFormData} from "../models/comment-form-data";
import {Observable} from "rxjs";
import {CommentListItem} from "../models/comment-list-item";

const BASE_URL = 'http://localhost:8080/api/posts';

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  constructor(private http: HttpClient) {

  }

  createComment(data: CommentFormData, postId: number) {
    return this.http.post(`${BASE_URL}/${postId}/comments`, data)
  }

  fetchComments(postId: number): Observable<CommentListItem[]> {
    return this.http.get<CommentListItem[]>(`${BASE_URL}/${postId}/comments`);
  }

}

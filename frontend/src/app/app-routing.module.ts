import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {PostListComponent} from "./components/post-list/post-list.component";
import {PostFormComponent} from "./components/post-form/post-form.component";
import {CommentListComponent} from "./components/post-details/comment-list/comment-list.component";
import {PostDetailsComponent} from "./components/post-details/post-details.component";
import {NavbarComponent} from "./components/navbar/navbar.component";

const routes: Routes = [
  {path: '', component: PostListComponent},
  {path: 'new-post', component: PostFormComponent},
  {path: 'posts', component: PostListComponent},
  {path: 'posts/:id', component: PostDetailsComponent},
  //{path: 'new-comment', component: CommentFormComponent},
  {path: 'comment-list', component: CommentListComponent},
  {path: '**', redirectTo: 'posts'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

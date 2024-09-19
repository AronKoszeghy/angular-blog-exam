import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {PostService} from "../../services/post.service";
import {Router} from "@angular/router";
import {handleValidationErrors} from "../../utils/validation.handler";

@Component({
  selector: 'app-post-form',
  templateUrl: './post-form.component.html',
  styleUrl: './post-form.component.css'
})
export class PostFormComponent{

  form: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private postService: PostService,
    private router: Router
  ) {
    this.form = this.formBuilder.group({
      title: ['', [Validators.required]],
      text: ['', [Validators.required]],
      imageUrl: ['']
    })
  }


  onSubmit() {
    const data = {...this.form.value};
    this.postService.createPost(data).subscribe({
      next: response => this.router.navigate(['posts']),
      error: errors => handleValidationErrors(errors, this.form)
    })
  }
}

import {Component, Input} from '@angular/core';
import {CommentFormData} from "../../../models/comment-form-data";
import {handleValidationErrors} from "../../../utils/validation.handler";
import {CommentService} from "../../../services/comment.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";

@Component({
    selector: 'app-comment-form',
    templateUrl: './comment-form.component.html',
    styleUrl: './comment-form.component.css'
})
export class CommentFormComponent {

    form: FormGroup;
    @Input() postId!: number;

    constructor(
        private commentService: CommentService,
        private formBuilder: FormBuilder,
        private router: Router) {
        this.form = this.formBuilder.group({
            author: [''],
            text: ['', [Validators.required]]
        })
    }

    onSubmit() {
        const data: CommentFormData = {...this.form.value};
        this.commentService.createComment(data, this.postId).subscribe({
            next: response => this.router.navigateByUrl('/', {skipLocationChange: true}).then(() => {
                this.router.navigate([`posts/${this.postId}`]);
            }),
            error: errors => handleValidationErrors(errors, this.form)
        })
    }

}

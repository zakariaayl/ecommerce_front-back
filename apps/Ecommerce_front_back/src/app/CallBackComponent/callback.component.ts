import { Component, OnInit } from '@angular/core';
import { FormGroup,FormBuilder,ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../Services/authService/auth-service.service';


@Component({
  selector: 'app-callback',
  templateUrl:'./callback.component.html',
  imports: [
    ReactiveFormsModule
  ]
})
export class CallbackComponent implements OnInit {
  constructor(private auth: AuthService, private router: Router,private fb: FormBuilder) {}
  passwordForm!: FormGroup;
  async ngOnInit() {
    await this.auth.handleRedirectCallback();
    console.log("dkhelte l hna f callbackcomp")
    this.router.navigate(['/'])
  }
  onSubmit(){
    console.log("dkhelte l hn")
    this.router.navigate(['/'])
  }
}

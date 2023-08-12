import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  loginForm = new FormGroup({
    user : new FormControl (null, Validators.required),
    pass : new FormControl (null, Validators.required),
  })

  loginUser(){
    console.log(this.loginForm.value);
  }

  get user(){
    return this.loginForm.get('user')
  }

  get pass(){
    return this.loginForm.get('pass')
  }


}

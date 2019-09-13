import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private islogged:boolean;

  isLoggedIn():boolean{
    return this.islogged;
  }

  setIsLogged(islogged:boolean){
    this.islogged=islogged;
  }
}

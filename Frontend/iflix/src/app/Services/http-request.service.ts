import { Injectable } from '@angular/core';
import { LoginInfo } from '../Model/login-info';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HttpRequestService {
  url='http://localhost:8080/iFlix/';

  constructor(private http:HttpClient) { }

  loginUser(userLogin:LoginInfo){
    return this.http.post<any>(this.url+"login",userLogin);
  }
}

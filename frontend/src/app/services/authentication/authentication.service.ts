import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { JwtUtilsService } from './jwt-utils.service';
import {catchError, map} from 'rxjs/operators';
import * as jwt_decode from 'jwt-decode';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private readonly loginPath = '/api/auth/login';

  constructor(private http: HttpClient, private jwtUtilsService: JwtUtilsService) { }

  login(username: string, password: string): Observable<boolean> {
    var headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post(this.loginPath, JSON.stringify({ username, password }), { headers }).pipe(
      map((res: any) => {
        let token = res && res['token'];
        if (token) {
          localStorage.setItem('accessToken', token);
          localStorage.setItem('companyId', this.getTokenInfo().companyId);
          localStorage.setItem('sub', this.getTokenInfo().sub);
          localStorage.setItem('role', this.getTokenInfo().role);
          return true;
        } else {
          return false;
        }
      }),
      catchError((error: any) => {
        if (error.status === 400) {
          return throwError('Ilegal login');
        } else {
          return throwError(error.json().error || 'Server error');
        }
      }));
  }

  getToken(): any {
    return localStorage.getItem('accessToken') || null;
  }

  removeToken() {
    localStorage.removeItem('accessToken');
  }

  isLoggedIn(): boolean {
    // tslint:disable-next-line:triple-equals
    if (this.getToken() != '' && this.getToken() != null) { return true; } else { return false; }
  }

  getTokenInfo() {
    const tokenVal = this.getToken();
    if (tokenVal) {
      return jwt_decode(tokenVal);
    }
    return null;
  }

}

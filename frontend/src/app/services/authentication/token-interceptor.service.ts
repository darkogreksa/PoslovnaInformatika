import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable, Injector } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthenticationService } from './authentication.service';

@Injectable({
  providedIn: 'root'
})
export class TokenInterceptorService implements HttpInterceptor {

  constructor(private inj: Injector) { }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let authenticationService: AuthenticationService = this.inj.get(AuthenticationService);
    request = request.clone({
      setHeaders: {
        'X-Auth-Token': `${authenticationService.getToken()}`
      }
    });

    return next.handle(request);
  }

}

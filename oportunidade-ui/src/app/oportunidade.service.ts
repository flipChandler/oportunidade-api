import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Oportunidade } from './oportunidade.model';

@Injectable({
  providedIn: 'root'
})
export class OportunidadeService {

  apiUrl = 'http://localhost:8080/oportunidades';

  constructor(private httpClient: HttpClient) { }

  listar(): Observable<Oportunidade[]> {
    return this.httpClient.get<Oportunidade[]>(this.apiUrl);
  }

}

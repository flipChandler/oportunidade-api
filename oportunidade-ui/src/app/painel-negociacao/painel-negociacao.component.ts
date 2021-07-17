import { OportunidadeService } from './../oportunidade.service';
import { Component, OnInit } from '@angular/core';
import { Oportunidade } from '../oportunidade.model';

@Component({
  selector: 'app-painel-negociacao',
  templateUrl: './painel-negociacao.component.html',
  styleUrls: ['./painel-negociacao.component.css']
})
export class PainelNegociacaoComponent implements OnInit {
  oportunidades: Oportunidade[] = [];

  constructor(private service: OportunidadeService) { }

  ngOnInit(): void {
    this.service.listar().subscribe(res => {
      this.oportunidades = res;
    })

  }

}



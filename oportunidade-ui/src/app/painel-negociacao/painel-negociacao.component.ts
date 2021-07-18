import { OportunidadeService } from './../oportunidade.service';
import { Component, OnInit } from '@angular/core';
import { Oportunidade } from '../oportunidade.model';
import { MessageService } from 'primeng/api';

@Component({
  selector: 'app-painel-negociacao',
  templateUrl: './painel-negociacao.component.html',
  styleUrls: ['./painel-negociacao.component.css']
})
export class PainelNegociacaoComponent implements OnInit {

  oportunidade: Oportunidade = {};

  oportunidades: Oportunidade[] = [];

  constructor(
    private service: OportunidadeService,
    private messageService: MessageService) { }

  ngOnInit(): void {
    this.consultar();
  }

  consultar() {
    this.service.listar().subscribe(resposta => {
      this.oportunidades = resposta;
    });
  };

  adicionar() {
    this.service.adicionar(this.oportunidade)
      .subscribe(() => {
        this.oportunidade = {};
        this.consultar();

        this.messageService.add({
          severity: 'success',
          summary: 'Oportunidade adicionada com sucesso'
        });
      },
        resposta => {
          let msg = 'Erro inesperado. Tente novamente!';

          if (resposta.error.message) {
            msg = resposta.error.message;
          }

          this.messageService.add({
            severity: 'error',
            summary: msg
          });
        }
      );
  }
}



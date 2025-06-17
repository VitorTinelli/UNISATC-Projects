import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, FormsModule, CommonModule],
  templateUrl: './mensagem.html',
  styleUrl: './mensagem.css',
})
export class AppComponent {
  mensagens = [
    { author: 'attendant', text: 'Olá! Como eu posso te ajudar?' },
    { author: 'you', text: 'Eu quero comprar uma pizza!' },
    { author: 'attendant', text: 'Eu acho que não entendi' },
  ];
  newMessage = '';

  enviarMensagem() {
    console.log("Mensagem enviada:", this.newMessage);
    if (this.newMessage.trim() !== '') {
      this.mensagens.push({ author: 'you', text: this.newMessage });
      this.newMessage = '';
    }
  }

}


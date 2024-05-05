import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HomeComponent } from "./home/home.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,HomeComponent],
  template: '<main>' +
    '<header class="ushatech">' +
    '<img src="/assets/logo.png" class="ushatech" alt="ushatech" >' +
    '</header>' +
    '<section class="content">' +
    '<app-home></app-home>'+
    '</section>'+
    '</main>',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'homes';
}

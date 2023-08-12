import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FlightListComponent } from './flight-list/flight-list.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { FlightService } from './flight.service';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FlightCreateComponent } from './flight-create/flight-create.component';
import { FlightEditComponent } from './flight-edit/flight-edit.component';
import { SearchPipe } from './search.pipe';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FlightListComponent,
    HomeComponent,
    LoginComponent,
    FlightCreateComponent,
    FlightEditComponent,
    SearchPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule

  ],
  providers: [FlightService],
  bootstrap: [AppComponent]
})
export class AppModule { }

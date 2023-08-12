import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FlightCreateComponent } from './flight-create/flight-create.component';
import { FlightEditComponent } from './flight-edit/flight-edit.component';
import { FlightListComponent } from './flight-list/flight-list.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  {path: 'home', component : HomeComponent},
  {path: 'flight-list', component : FlightListComponent},
  {path: 'login', component : LoginComponent},
  {path: 'flight-create', component : FlightCreateComponent},
  {path: 'Edit/:id', component: FlightEditComponent},
  {path: 'flight', component: FlightListComponent},
  {path: '**', component: FlightListComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

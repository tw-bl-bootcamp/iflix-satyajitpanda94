import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserloginComponent } from './Components/userlogin/userlogin.component';
import { MoviesComponent } from './Components/movies/movies.component';
import { NotFoundComponent } from './Components/not-found/not-found.component';
import { AuthGuard } from './auth.guard';
import { AuthService } from './auth.service';


const routes: Routes = [
  {path:"", component:UserloginComponent},
  {path:"movies",component:MoviesComponent,canActivate:[AuthGuard]},
  {path:'**',component:NotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

export const routingComponents=[
  UserloginComponent,
  MoviesComponent,
  NotFoundComponent
];

export const routingServices=[
  AuthGuard,
  AuthService
];

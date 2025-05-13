import { Routes } from '@angular/router';
import { HomeComponent } from './componenti/home/home.component';
import { SpecialitaComponent } from './componenti/specialita/specialita.component';
import { PrenotaComponent } from './componenti/prenota/prenota.component';
import { LoginComponent } from './componenti/login/login.component';
import { RegComponent } from './componenti/reg/reg.component';

export const routes: Routes = [
    {path:"", redirectTo:"home", pathMatch:"full"},
    {path:'home', component: HomeComponent},
    {path:'specialita', component: SpecialitaComponent},
    {path:'prenotazioni', component: PrenotaComponent},
    {path:'login', component:LoginComponent},
    {path:'reg', component:RegComponent}
];

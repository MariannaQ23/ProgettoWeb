import { RouterModule, Routes } from "@angular/router";
import { HomeComponent } from "./componenti/home/home.component";
import { LoginComponent } from "./componenti/login/login.component";
import { PrenotaComponent } from "./componenti/prenota/prenota.component";
import { RegComponent } from "./componenti/reg/reg.component";
import { SpecialitaComponent } from "./componenti/specialita/specialita.component";
import { NgModule } from "@angular/core";


const routes: Routes = [
    {path:"", redirectTo:"home", pathMatch:"full"},
    {path:'home', component: HomeComponent},
    {path:'specialita', component: SpecialitaComponent},
    {path:'prenotazione', component: PrenotaComponent},
    {path:'login', component:LoginComponent},
    {path:'reg', component:RegComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule{
    
}
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { MedicinesComponent } from './medicines/medicines.component';
import { AddMedicineComponent } from './medicines/add-medicine/add-medicine.component';
import { EditMedicineComponent } from './medicines/edit-medicine/edit-medicine.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    MedicinesComponent,
    AddMedicineComponent,
    EditMedicineComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgChartsModule } from 'ng2-charts';
import { HomeComponent } from './home/home.component';



@NgModule({
  declarations: [
    HomeComponent
  ],
  imports: [
    CommonModule,
    NgChartsModule
  ],
  exports: [
    HomeComponent,
    NgChartsModule
  ]
})
export class ComponentsModule { }

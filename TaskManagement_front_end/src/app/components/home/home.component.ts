import { Component } from '@angular/core';
import { ChartConfiguration } from 'chart.js';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  title = 'ng2-charts-demo';

  // Doughnut
  public doughnutChartLabels: string[] = [ 'Done', 'Pending', 'ToDo' ];

  public doughnutChartDataset: ChartConfiguration<'doughnut'>['data']['datasets'] = [
    {
      data: 
        [90, 25, 25]
       
      ,
      label: 'projet 1'
    }
  ];

  public doughnutChartOptions: ChartConfiguration<'doughnut'>['options'] = {
    responsive: false
  };

  constructor() {
  }

}

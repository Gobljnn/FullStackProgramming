import { Component, OnInit } from '@angular/core';
import {ExchangeRatesService} from '../services/exchange-rates.service';

@Component({
  selector: 'app-converter',
  templateUrl: './converter.component.html',
  styleUrls: ['./converter.component.css']
})
export class ConverterComponent implements OnInit {

  amount = 1;
  from = 'CAD';
  to = 'USD';
  rate!: { [key: string]: number; }; //remove !

  convert(): number{
    return this.amount * this.rate[this.to];
  }

  loadRates(){
    this.service.getRates(this.from).subscribe(res => this.rate = res.conversion_rates);
  }

  getAllCurrency(): string[]{
    return Object.keys(this.rate);
  }

  constructor(private service: ExchangeRatesService) {

   }

  ngOnInit(): void {
    this.loadRates();
  }

}

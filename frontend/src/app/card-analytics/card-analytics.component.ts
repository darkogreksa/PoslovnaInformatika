import { Component, OnInit } from '@angular/core';
import { Analytics } from '../model/analytics';
import { Subscription } from 'rxjs';
import { ActivatedRoute } from '@angular/router';
import { AnalyticsService } from '../services/analytics.service';


@Component({
  selector: 'app-card-analytics',
  templateUrl: './card-analytics.component.html',
  styleUrls: ['./card-analytics.component.css']
})
export class CardAnalyticsComponent implements OnInit {
  analytics: Analytics[] = [];
  sub: Subscription;
  cardId: number;
  constructor(
    private analyticsService: AnalyticsService,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.sub = this.route.params.subscribe(params => {
      this.cardId = params['id'];
      this.getAnalytics();
    });
  }

  getAnalytics() {
    this.analyticsService.getAllByCard(this.cardId).subscribe(
      (analytics: Analytics[]) => {
        this.analytics = analytics;
        console.log(this.analytics);
      },
      (error) => console.log(error)
    );
  }

}

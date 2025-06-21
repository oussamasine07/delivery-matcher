import {AfterViewInit, Component, ElementRef, EventEmitter, inject, OnInit, Output, ViewChild} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {NgClass, NgForOf, NgIf} from "@angular/common";
import {announcementForm} from '../../../../models/types/annoucementForm';
import Choices from 'choices.js';
import {City} from '../../../../models/interfaces/city';
import {CityService} from '../../../../services/city/city.service';
import {JournyService} from '../../../../services/journy/journy.service';
import {Journy} from '../../../../models/interfaces/journy';

@Component({
  selector: 'app-journy-create',
  imports: [
    FormsModule,
    NgIf,
    ReactiveFormsModule,
    NgClass,
    NgForOf
  ],
  templateUrl: './journy-create.component.html',
  styleUrl: './journy-create.component.css'
})
export class JournyCreateComponent implements OnInit, AfterViewInit {

  cityService: CityService = inject(CityService);
  journyService: JournyService = inject(JournyService);


  availableCities: City[] = [];
  //@ViewChild('citiesSelect') citiesSelect!: ElementRef;
  private choicesInstance: Choices | null = null;

  @ViewChild('citiesSelect') set citiesSelectSetter(el: ElementRef) {
    if (el && this.availableCities.length > 0 && !this.choicesInstance) {
      this.choicesInstance = new Choices(el.nativeElement, {
        removeItemButton: true,
        placeholderValue: 'Select crossed cities',
        shouldSort: false,
      });
    }
  }

  ngAfterViewInit(): void {
    this.cityService.getCities().subscribe({
      next: (cities: City[]) => {
        this.availableCities = cities;
        console.log(this.availableCities)
      },
      error: e => {
        console.log(e)
      }
    })
  }


  ngOnInit() {
    setTimeout(() => {
      this.animate = true;
    }, 10)
  }

  animate = false;

  fieldErrors: Record<string, string|string[]> = {};

  @Output() close = new EventEmitter();
  onCloseClick () {
    this.animate = false;
    setTimeout(() => {
      this.close.emit()
    }, 300);

  }

  @Output() emitCreateJourny = new EventEmitter();
  journyObj = {
    name: "",
    departure_destination: null,
    final_destination: null,
    passed_by_cities: null
  }
  onCreateJournySubmit (event: FormsModule) {
    this.journyService.createJourny(this.journyObj).subscribe({
      next: (j: Journy) => {
        this.emitCreateJourny.emit(j);
        this.onCloseClick();
      },
      error: e => {
        this.fieldErrors = e.error;
      }
    })

  }
}






















import {
  AfterViewInit,
  Component,
  ElementRef,
  EventEmitter,
  inject,
  Input,
  OnInit,
  Output,
  ViewChild
} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {NgClass, NgForOf, NgIf} from '@angular/common';
import {City} from '../../../../models/interfaces/city';
import Choices from 'choices.js';
import {CityService} from '../../../../services/city/city.service';
import {JournyService} from '../../../../services/journy/journy.service';
import {Journy} from '../../../../models/interfaces/journy';
import {journyForm} from '../../../../models/types/journyForm';

@Component({
  selector: 'app-journy-update',
  imports: [
    FormsModule,
    NgForOf,
    NgIf,
    ReactiveFormsModule,
    NgClass
  ],
  templateUrl: './journy-update.component.html',
  styleUrl: './journy-update.component.css'
})
export class JournyUpdateComponent implements OnInit, AfterViewInit{
  cityService: CityService = inject(CityService);
  journyService: JournyService = inject(JournyService);


  availableCities: City[] = [];
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


    this.journyObj = {
      name: this.currentJourny?.name || "",
      departure_destination: this.currentJourny?.departureDestination?.id || null,
      final_destination: this.currentJourny?.finalDestination?.id || null,
      passed_by_cities: null
    }
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

  journy: Journy | null = null;

  @Input() currentJourny: Journy | null = null;
  @Output() emitUpdateJourny = new EventEmitter();

  journyObj: journyForm = {
    name: "",
    departure_destination: null,
    final_destination: null,
    passed_by_cities: null
  }
  onUpdateJournySubmit (event: FormsModule) {
    console.log(this.journyObj);
    this.journyService.updateJourny(this.journyObj, this.currentJourny?.id).subscribe({

      next: (j: Journy) => {
        this.emitUpdateJourny.emit(j);
        this.onCloseClick();
      },
      error: e => {
        this.fieldErrors = e.error;
      }
    })
  }
}

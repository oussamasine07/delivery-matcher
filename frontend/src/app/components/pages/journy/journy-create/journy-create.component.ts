import {AfterViewInit, Component, ElementRef, EventEmitter, OnInit, Output, ViewChild} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {NgClass, NgForOf, NgIf} from "@angular/common";
import {announcementForm} from '../../../../models/types/annoucementForm';
import Choices from 'choices.js';

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

  @ViewChild('citiesSelect') citiesSelect!: ElementRef;
  ngAfterViewInit(): void {
    new Choices(this.citiesSelect.nativeElement, {
      removeItemButton: true,
      placeholderValue: 'Select crossed cities',
      shouldSort: false
    });
  }
  availableCities = ['Rabat', 'Kenitra', 'Fes', 'Oujda', 'Chefchaouen'];


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

  announcementObj: announcementForm = {
    name: "",
    max_dimentions: null,
    goods_type: "",
    capacity: null,
    journy_id: null
  }
}

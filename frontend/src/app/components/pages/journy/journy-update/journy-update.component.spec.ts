import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JournyUpdateComponent } from './journy-update.component';

describe('JournyUpdateComponent', () => {
  let component: JournyUpdateComponent;
  let fixture: ComponentFixture<JournyUpdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [JournyUpdateComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(JournyUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

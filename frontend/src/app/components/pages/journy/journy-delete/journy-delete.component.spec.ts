import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JournyDeleteComponent } from './journy-delete.component';

describe('JournyDeleteComponent', () => {
  let component: JournyDeleteComponent;
  let fixture: ComponentFixture<JournyDeleteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [JournyDeleteComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(JournyDeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

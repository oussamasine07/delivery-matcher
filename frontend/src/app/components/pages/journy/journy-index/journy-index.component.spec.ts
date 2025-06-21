import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JournyIndexComponent } from './journy-index.component';

describe('JournyIndexComponent', () => {
  let component: JournyIndexComponent;
  let fixture: ComponentFixture<JournyIndexComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [JournyIndexComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(JournyIndexComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JournyCreateComponent } from './journy-create.component';

describe('JournyCreateComponent', () => {
  let component: JournyCreateComponent;
  let fixture: ComponentFixture<JournyCreateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [JournyCreateComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(JournyCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnnouncementIndexComponent } from './announcement-index.component';

describe('AnnouncementIndexComponent', () => {
  let component: AnnouncementIndexComponent;
  let fixture: ComponentFixture<AnnouncementIndexComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AnnouncementIndexComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AnnouncementIndexComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

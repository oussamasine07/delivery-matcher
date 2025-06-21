import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnnouncementDeleteComponent } from './announcement-delete.component';

describe('AnnouncementDeleteComponent', () => {
  let component: AnnouncementDeleteComponent;
  let fixture: ComponentFixture<AnnouncementDeleteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AnnouncementDeleteComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AnnouncementDeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnnouncementSenderComponent } from './announcement-sender.component';

describe('AnnouncementSenderComponent', () => {
  let component: AnnouncementSenderComponent;
  let fixture: ComponentFixture<AnnouncementSenderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AnnouncementSenderComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AnnouncementSenderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

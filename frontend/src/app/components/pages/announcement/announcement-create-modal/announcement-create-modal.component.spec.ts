import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnnouncementCreateModalComponent } from './announcement-create-modal.component';

describe('AnnouncementCreateModalComponent', () => {
  let component: AnnouncementCreateModalComponent;
  let fixture: ComponentFixture<AnnouncementCreateModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AnnouncementCreateModalComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AnnouncementCreateModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { TestBed } from '@angular/core/testing';

import { JournyService } from './journy.service';

describe('JournyService', () => {
  let service: JournyService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(JournyService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

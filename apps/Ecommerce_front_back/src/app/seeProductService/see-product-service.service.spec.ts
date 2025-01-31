import { TestBed } from '@angular/core/testing';

import { SeeProductServiceService } from './see-product-service.service';

describe('SeeProductServiceService', () => {
  let service: SeeProductServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SeeProductServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

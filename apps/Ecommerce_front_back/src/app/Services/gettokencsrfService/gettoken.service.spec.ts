import { TestBed } from '@angular/core/testing';

import { GettokenService } from './gettoken.service';

describe('GettokenService', () => {
  let service: GettokenService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GettokenService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

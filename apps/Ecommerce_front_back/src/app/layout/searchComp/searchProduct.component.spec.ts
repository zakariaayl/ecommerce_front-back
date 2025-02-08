import { ComponentFixture, TestBed } from '@angular/core/testing';
import { SearchProductComponent } from './searchProduct.component';

describe('SearchProductComponent', () => {
  let component: SearchProductComponent;
  let fixture: ComponentFixture<SearchProductComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SearchProductComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(SearchProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

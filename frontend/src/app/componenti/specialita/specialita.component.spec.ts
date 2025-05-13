import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SpecialitaComponent } from './specialita.component';

describe('SpecialitaComponent', () => {
  let component: SpecialitaComponent;
  let fixture: ComponentFixture<SpecialitaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SpecialitaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SpecialitaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

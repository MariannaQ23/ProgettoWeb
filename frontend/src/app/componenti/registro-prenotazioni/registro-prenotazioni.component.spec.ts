import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistroPrenotazioniComponent } from './registro-prenotazioni.component';

describe('RegistroPrenotazioniComponent', () => {
  let component: RegistroPrenotazioniComponent;
  let fixture: ComponentFixture<RegistroPrenotazioniComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RegistroPrenotazioniComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegistroPrenotazioniComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

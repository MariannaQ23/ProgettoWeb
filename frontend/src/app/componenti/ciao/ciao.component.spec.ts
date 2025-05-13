import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CiaoComponent } from './ciao.component';

describe('CiaoComponent', () => {
  let component: CiaoComponent;
  let fixture: ComponentFixture<CiaoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CiaoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CiaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmploComponent } from './emplo.component';

describe('EmploComponent', () => {
  let component: EmploComponent;
  let fixture: ComponentFixture<EmploComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmploComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmploComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

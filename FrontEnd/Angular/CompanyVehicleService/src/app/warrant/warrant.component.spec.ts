import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WarrantComponent } from './warrant.component';

describe('WarrantComponent', () => {
  let component: WarrantComponent;
  let fixture: ComponentFixture<WarrantComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WarrantComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WarrantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

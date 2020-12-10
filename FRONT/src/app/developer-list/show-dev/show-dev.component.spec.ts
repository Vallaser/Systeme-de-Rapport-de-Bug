import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowDevComponent } from './show-dev.component';

describe('ShowDevComponent', () => {
  let component: ShowDevComponent;
  let fixture: ComponentFixture<ShowDevComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShowDevComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowDevComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowBugComponent } from './show-bug.component';

describe('ShowBugComponent', () => {
  let component: ShowBugComponent;
  let fixture: ComponentFixture<ShowBugComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShowBugComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowBugComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

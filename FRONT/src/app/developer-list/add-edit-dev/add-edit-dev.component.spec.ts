import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddEditDevComponent } from './add-edit-dev.component';

describe('AddEditDevComponent', () => {
  let component: AddEditDevComponent;
  let fixture: ComponentFixture<AddEditDevComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddEditDevComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddEditDevComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

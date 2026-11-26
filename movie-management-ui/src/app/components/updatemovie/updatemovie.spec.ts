import { ComponentFixture, TestBed } from '@angular/core/testing';
import { MovieUpdate } from './updatemovie';

describe('MovieUpdate', () => {
  let component: MovieUpdate;
  let fixture: ComponentFixture<MovieUpdate>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [MovieUpdate],
    }).compileComponents();

    fixture = TestBed.createComponent(MovieUpdate);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';
import { MovieCreate } from './createmovie';

describe('Createmovie', () => {
  let component: MovieCreate;
  let fixture: ComponentFixture<MovieCreate>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [MovieCreate],
    }).compileComponents();

    fixture = TestBed.createComponent(MovieCreate);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

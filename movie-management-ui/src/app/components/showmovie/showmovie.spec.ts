import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Showmovie } from './showmovie';

describe('Showmovie', () => {
  let component: Showmovie;
  let fixture: ComponentFixture<Showmovie>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [Showmovie],
    }).compileComponents();

    fixture = TestBed.createComponent(Showmovie);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

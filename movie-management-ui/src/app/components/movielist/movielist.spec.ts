import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Movielist } from './movielist';

describe('Movielist', () => {
  let component: Movielist;
  let fixture: ComponentFixture<Movielist>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [Movielist],
    }).compileComponents();

    fixture = TestBed.createComponent(Movielist);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { SmartOrganizerGatewayTestModule } from '../../../../test.module';
import { CalendarDetailComponent } from 'app/entities/micro2/calendar/calendar-detail.component';
import { Calendar } from 'app/shared/model/micro2/calendar.model';

describe('Component Tests', () => {
    describe('Calendar Management Detail Component', () => {
        let comp: CalendarDetailComponent;
        let fixture: ComponentFixture<CalendarDetailComponent>;
        const route = ({ data: of({ calendar: new Calendar(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [SmartOrganizerGatewayTestModule],
                declarations: [CalendarDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(CalendarDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(CalendarDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.calendar).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});

/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { SmartOrganizerGatewayTestModule } from '../../../../test.module';
import { WorkgroupDetailComponent } from 'app/entities/SmartOrganizerMicro/workgroup/workgroup-detail.component';
import { Workgroup } from 'app/shared/model/SmartOrganizerMicro/workgroup.model';

describe('Component Tests', () => {
    describe('Workgroup Management Detail Component', () => {
        let comp: WorkgroupDetailComponent;
        let fixture: ComponentFixture<WorkgroupDetailComponent>;
        const route = ({ data: of({ workgroup: new Workgroup(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [SmartOrganizerGatewayTestModule],
                declarations: [WorkgroupDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(WorkgroupDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(WorkgroupDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.workgroup).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});

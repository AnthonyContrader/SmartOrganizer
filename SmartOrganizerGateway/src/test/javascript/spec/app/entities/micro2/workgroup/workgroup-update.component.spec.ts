/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { SmartOrganizerGatewayTestModule } from '../../../../test.module';
import { WorkgroupUpdateComponent } from 'app/entities/micro2/workgroup/workgroup-update.component';
import { WorkgroupService } from 'app/entities/micro2/workgroup/workgroup.service';
import { Workgroup } from 'app/shared/model/micro2/workgroup.model';

describe('Component Tests', () => {
    describe('Workgroup Management Update Component', () => {
        let comp: WorkgroupUpdateComponent;
        let fixture: ComponentFixture<WorkgroupUpdateComponent>;
        let service: WorkgroupService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [SmartOrganizerGatewayTestModule],
                declarations: [WorkgroupUpdateComponent]
            })
                .overrideTemplate(WorkgroupUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(WorkgroupUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(WorkgroupService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new Workgroup(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.workgroup = entity;
                    // WHEN
                    comp.save();
                    tick(); // simulate async

                    // THEN
                    expect(service.update).toHaveBeenCalledWith(entity);
                    expect(comp.isSaving).toEqual(false);
                })
            );

            it(
                'Should call create service on save for new entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new Workgroup();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.workgroup = entity;
                    // WHEN
                    comp.save();
                    tick(); // simulate async

                    // THEN
                    expect(service.create).toHaveBeenCalledWith(entity);
                    expect(comp.isSaving).toEqual(false);
                })
            );
        });
    });
});

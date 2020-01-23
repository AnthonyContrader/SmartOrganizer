/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { SmartOrganizerGatewayTestModule } from '../../../../test.module';
import { WorkgroupDeleteDialogComponent } from 'app/entities/micro2/workgroup/workgroup-delete-dialog.component';
import { WorkgroupService } from 'app/entities/micro2/workgroup/workgroup.service';

describe('Component Tests', () => {
    describe('Workgroup Management Delete Component', () => {
        let comp: WorkgroupDeleteDialogComponent;
        let fixture: ComponentFixture<WorkgroupDeleteDialogComponent>;
        let service: WorkgroupService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [SmartOrganizerGatewayTestModule],
                declarations: [WorkgroupDeleteDialogComponent]
            })
                .overrideTemplate(WorkgroupDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(WorkgroupDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(WorkgroupService);
            mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
            mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
        });

        describe('confirmDelete', () => {
            it('Should call delete service on confirmDelete', inject(
                [],
                fakeAsync(() => {
                    // GIVEN
                    spyOn(service, 'delete').and.returnValue(of({}));

                    // WHEN
                    comp.confirmDelete(123);
                    tick();

                    // THEN
                    expect(service.delete).toHaveBeenCalledWith(123);
                    expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                    expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
                })
            ));
        });
    });
});

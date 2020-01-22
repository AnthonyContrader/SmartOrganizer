import { browser, ExpectedConditions as ec } from 'protractor';
import { NavBarPage, SignInPage } from '../../../page-objects/jhi-page-objects';

import { WorkgroupComponentsPage, WorkgroupUpdatePage } from './workgroup.page-object';

describe('Workgroup e2e test', () => {
    let navBarPage: NavBarPage;
    let signInPage: SignInPage;
    let workgroupUpdatePage: WorkgroupUpdatePage;
    let workgroupComponentsPage: WorkgroupComponentsPage;

    beforeAll(async () => {
        await browser.get('/');
        navBarPage = new NavBarPage();
        signInPage = await navBarPage.getSignInPage();
        await signInPage.autoSignInUsing('admin', 'admin');
        await browser.wait(ec.visibilityOf(navBarPage.entityMenu), 5000);
    });

    it('should load Workgroups', async () => {
        await navBarPage.goToEntity('workgroup');
        workgroupComponentsPage = new WorkgroupComponentsPage();
        expect(await workgroupComponentsPage.getTitle()).toMatch(/Workgroups/);
    });

    it('should load create Workgroup page', async () => {
        await workgroupComponentsPage.clickOnCreateButton();
        workgroupUpdatePage = new WorkgroupUpdatePage();
        expect(await workgroupUpdatePage.getPageTitle()).toMatch(/Create or edit a Workgroup/);
        await workgroupUpdatePage.cancel();
    });

    it('should create and save Workgroups', async () => {
        await workgroupComponentsPage.clickOnCreateButton();
        await workgroupUpdatePage.setNameInput('name');
        expect(await workgroupUpdatePage.getNameInput()).toMatch('name');
        await workgroupUpdatePage.setMembersInput('members');
        expect(await workgroupUpdatePage.getMembersInput()).toMatch('members');
        await workgroupUpdatePage.setResponsibleInput('responsible');
        expect(await workgroupUpdatePage.getResponsibleInput()).toMatch('responsible');
        await workgroupUpdatePage.setWorkInput('work');
        expect(await workgroupUpdatePage.getWorkInput()).toMatch('work');
        await workgroupUpdatePage.save();
        expect(await workgroupUpdatePage.getSaveButton().isPresent()).toBeFalsy();
    });

    afterAll(async () => {
        await navBarPage.autoSignOut();
    });
});

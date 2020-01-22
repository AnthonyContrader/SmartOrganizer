import { browser, ExpectedConditions as ec } from 'protractor';
import { NavBarPage, SignInPage } from '../../../page-objects/jhi-page-objects';

import { EmployeeComponentsPage, EmployeeUpdatePage } from './employee.page-object';

describe('Employee e2e test', () => {
    let navBarPage: NavBarPage;
    let signInPage: SignInPage;
    let employeeUpdatePage: EmployeeUpdatePage;
    let employeeComponentsPage: EmployeeComponentsPage;

    beforeAll(async () => {
        await browser.get('/');
        navBarPage = new NavBarPage();
        signInPage = await navBarPage.getSignInPage();
        await signInPage.autoSignInUsing('admin', 'admin');
        await browser.wait(ec.visibilityOf(navBarPage.entityMenu), 5000);
    });

    it('should load Employees', async () => {
        await navBarPage.goToEntity('employee');
        employeeComponentsPage = new EmployeeComponentsPage();
        expect(await employeeComponentsPage.getTitle()).toMatch(/Employees/);
    });

    it('should load create Employee page', async () => {
        await employeeComponentsPage.clickOnCreateButton();
        employeeUpdatePage = new EmployeeUpdatePage();
        expect(await employeeUpdatePage.getPageTitle()).toMatch(/Create or edit a Employee/);
        await employeeUpdatePage.cancel();
    });

    it('should create and save Employees', async () => {
        await employeeComponentsPage.clickOnCreateButton();
        await employeeUpdatePage.setNameInput('name');
        expect(await employeeUpdatePage.getNameInput()).toMatch('name');
        await employeeUpdatePage.setSurnameInput('surname');
        expect(await employeeUpdatePage.getSurnameInput()).toMatch('surname');
        await employeeUpdatePage.setFiscalcodeInput('fiscalcode');
        expect(await employeeUpdatePage.getFiscalcodeInput()).toMatch('fiscalcode');
        await employeeUpdatePage.setPositionInput('position');
        expect(await employeeUpdatePage.getPositionInput()).toMatch('position');
        await employeeUpdatePage.workgroupSelectLastOption();
        await employeeUpdatePage.save();
        expect(await employeeUpdatePage.getSaveButton().isPresent()).toBeFalsy();
    });

    afterAll(async () => {
        await navBarPage.autoSignOut();
    });
});

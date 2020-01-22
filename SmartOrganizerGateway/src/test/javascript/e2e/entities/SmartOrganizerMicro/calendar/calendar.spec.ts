import { browser, ExpectedConditions as ec } from 'protractor';
import { NavBarPage, SignInPage } from '../../../page-objects/jhi-page-objects';

import { CalendarComponentsPage, CalendarUpdatePage } from './calendar.page-object';

describe('Calendar e2e test', () => {
    let navBarPage: NavBarPage;
    let signInPage: SignInPage;
    let calendarUpdatePage: CalendarUpdatePage;
    let calendarComponentsPage: CalendarComponentsPage;

    beforeAll(async () => {
        await browser.get('/');
        navBarPage = new NavBarPage();
        signInPage = await navBarPage.getSignInPage();
        await signInPage.autoSignInUsing('admin', 'admin');
        await browser.wait(ec.visibilityOf(navBarPage.entityMenu), 5000);
    });

    it('should load Calendars', async () => {
        await navBarPage.goToEntity('calendar');
        calendarComponentsPage = new CalendarComponentsPage();
        expect(await calendarComponentsPage.getTitle()).toMatch(/Calendars/);
    });

    it('should load create Calendar page', async () => {
        await calendarComponentsPage.clickOnCreateButton();
        calendarUpdatePage = new CalendarUpdatePage();
        expect(await calendarUpdatePage.getPageTitle()).toMatch(/Create or edit a Calendar/);
        await calendarUpdatePage.cancel();
    });

    it('should create and save Calendars', async () => {
        await calendarComponentsPage.clickOnCreateButton();
        await calendarUpdatePage.setDateInput('2000-12-31');
        expect(await calendarUpdatePage.getDateInput()).toMatch('2000-12-31');
        await calendarUpdatePage.setCheckinInput('checkin');
        expect(await calendarUpdatePage.getCheckinInput()).toMatch('checkin');
        await calendarUpdatePage.setCheckoutInput('checkout');
        expect(await calendarUpdatePage.getCheckoutInput()).toMatch('checkout');
        await calendarUpdatePage.employeeSelectLastOption();
        await calendarUpdatePage.save();
        expect(await calendarUpdatePage.getSaveButton().isPresent()).toBeFalsy();
    });

    afterAll(async () => {
        await navBarPage.autoSignOut();
    });
});

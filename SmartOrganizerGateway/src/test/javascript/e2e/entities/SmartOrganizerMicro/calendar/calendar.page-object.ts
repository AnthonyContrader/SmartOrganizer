import { element, by, ElementFinder } from 'protractor';

export class CalendarComponentsPage {
    createButton = element(by.id('jh-create-entity'));
    title = element.all(by.css('jhi-calendar div h2#page-heading span')).first();

    async clickOnCreateButton() {
        await this.createButton.click();
    }

    async getTitle() {
        return this.title.getText();
    }
}

export class CalendarUpdatePage {
    pageTitle = element(by.id('jhi-calendar-heading'));
    saveButton = element(by.id('save-entity'));
    cancelButton = element(by.id('cancel-save'));
    dateInput = element(by.id('field_date'));
    checkinInput = element(by.id('field_checkin'));
    checkoutInput = element(by.id('field_checkout'));
    employeeSelect = element(by.id('field_employee'));

    async getPageTitle() {
        return this.pageTitle.getText();
    }

    async setDateInput(date) {
        await this.dateInput.sendKeys(date);
    }

    async getDateInput() {
        return this.dateInput.getAttribute('value');
    }

    async setCheckinInput(checkin) {
        await this.checkinInput.sendKeys(checkin);
    }

    async getCheckinInput() {
        return this.checkinInput.getAttribute('value');
    }

    async setCheckoutInput(checkout) {
        await this.checkoutInput.sendKeys(checkout);
    }

    async getCheckoutInput() {
        return this.checkoutInput.getAttribute('value');
    }

    async employeeSelectLastOption() {
        await this.employeeSelect
            .all(by.tagName('option'))
            .last()
            .click();
    }

    async employeeSelectOption(option) {
        await this.employeeSelect.sendKeys(option);
    }

    getEmployeeSelect(): ElementFinder {
        return this.employeeSelect;
    }

    async getEmployeeSelectedOption() {
        return this.employeeSelect.element(by.css('option:checked')).getText();
    }

    async save() {
        await this.saveButton.click();
    }

    async cancel() {
        await this.cancelButton.click();
    }

    getSaveButton(): ElementFinder {
        return this.saveButton;
    }
}

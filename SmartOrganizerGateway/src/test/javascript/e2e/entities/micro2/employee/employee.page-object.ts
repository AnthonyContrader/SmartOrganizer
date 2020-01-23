import { element, by, ElementFinder } from 'protractor';

export class EmployeeComponentsPage {
    createButton = element(by.id('jh-create-entity'));
    title = element.all(by.css('jhi-employee div h2#page-heading span')).first();

    async clickOnCreateButton() {
        await this.createButton.click();
    }

    async getTitle() {
        return this.title.getText();
    }
}

export class EmployeeUpdatePage {
    pageTitle = element(by.id('jhi-employee-heading'));
    saveButton = element(by.id('save-entity'));
    cancelButton = element(by.id('cancel-save'));
    nameInput = element(by.id('field_name'));
    surnameInput = element(by.id('field_surname'));
    fiscalcodeInput = element(by.id('field_fiscalcode'));
    positionInput = element(by.id('field_position'));
    workgroupSelect = element(by.id('field_workgroup'));

    async getPageTitle() {
        return this.pageTitle.getText();
    }

    async setNameInput(name) {
        await this.nameInput.sendKeys(name);
    }

    async getNameInput() {
        return this.nameInput.getAttribute('value');
    }

    async setSurnameInput(surname) {
        await this.surnameInput.sendKeys(surname);
    }

    async getSurnameInput() {
        return this.surnameInput.getAttribute('value');
    }

    async setFiscalcodeInput(fiscalcode) {
        await this.fiscalcodeInput.sendKeys(fiscalcode);
    }

    async getFiscalcodeInput() {
        return this.fiscalcodeInput.getAttribute('value');
    }

    async setPositionInput(position) {
        await this.positionInput.sendKeys(position);
    }

    async getPositionInput() {
        return this.positionInput.getAttribute('value');
    }

    async workgroupSelectLastOption() {
        await this.workgroupSelect
            .all(by.tagName('option'))
            .last()
            .click();
    }

    async workgroupSelectOption(option) {
        await this.workgroupSelect.sendKeys(option);
    }

    getWorkgroupSelect(): ElementFinder {
        return this.workgroupSelect;
    }

    async getWorkgroupSelectedOption() {
        return this.workgroupSelect.element(by.css('option:checked')).getText();
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

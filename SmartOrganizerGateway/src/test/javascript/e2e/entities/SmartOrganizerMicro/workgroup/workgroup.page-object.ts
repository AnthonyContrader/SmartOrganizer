import { element, by, ElementFinder } from 'protractor';

export class WorkgroupComponentsPage {
    createButton = element(by.id('jh-create-entity'));
    title = element.all(by.css('jhi-workgroup div h2#page-heading span')).first();

    async clickOnCreateButton() {
        await this.createButton.click();
    }

    async getTitle() {
        return this.title.getText();
    }
}

export class WorkgroupUpdatePage {
    pageTitle = element(by.id('jhi-workgroup-heading'));
    saveButton = element(by.id('save-entity'));
    cancelButton = element(by.id('cancel-save'));
    nameInput = element(by.id('field_name'));
    membersInput = element(by.id('field_members'));
    responsibleInput = element(by.id('field_responsible'));
    workInput = element(by.id('field_work'));

    async getPageTitle() {
        return this.pageTitle.getText();
    }

    async setNameInput(name) {
        await this.nameInput.sendKeys(name);
    }

    async getNameInput() {
        return this.nameInput.getAttribute('value');
    }

    async setMembersInput(members) {
        await this.membersInput.sendKeys(members);
    }

    async getMembersInput() {
        return this.membersInput.getAttribute('value');
    }

    async setResponsibleInput(responsible) {
        await this.responsibleInput.sendKeys(responsible);
    }

    async getResponsibleInput() {
        return this.responsibleInput.getAttribute('value');
    }

    async setWorkInput(work) {
        await this.workInput.sendKeys(work);
    }

    async getWorkInput() {
        return this.workInput.getAttribute('value');
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

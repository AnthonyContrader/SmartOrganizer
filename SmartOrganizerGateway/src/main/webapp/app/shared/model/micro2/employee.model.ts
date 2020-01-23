export interface IEmployee {
    id?: number;
    name?: string;
    surname?: string;
    fiscalcode?: string;
    position?: string;
    workgroupId?: number;
}

export class Employee implements IEmployee {
    constructor(
        public id?: number,
        public name?: string,
        public surname?: string,
        public fiscalcode?: string,
        public position?: string,
        public workgroupId?: number
    ) {}
}

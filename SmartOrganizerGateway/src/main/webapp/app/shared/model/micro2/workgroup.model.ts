export interface IWorkgroup {
    id?: number;
    name?: string;
    members?: string;
    responsible?: string;
    work?: string;
}

export class Workgroup implements IWorkgroup {
    constructor(public id?: number, public name?: string, public members?: string, public responsible?: string, public work?: string) {}
}

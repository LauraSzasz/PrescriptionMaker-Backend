import {AdministrationMethod} from "./administration-method";

export class Medicine {
  id!: number;
  brandName!: string;
  chemicalName!: string;
  quantity!: number;
  posology!: string;
  administrationMethod!: AdministrationMethod;
}

export enum MemberType {
  ADMIN = "Admin",
  STUDENT = "Student",
  INSTRUCTOR = "Instructor",
}

export class User {
  constructor(
    public id: number,
    public firstName: string,
    public lastName: string,
    public email: string,
    public memberType: string,
    public phoneNumber: string,
    public address: string,
    public profilePhoto: string,
  ) {}

}
export class Student extends User {
  constructor(
    id: number,
    firstName: string,
    lastName: string,
    email: string,
    phoneNumber: string,
    address: string,
    profilePhoto: string,
    public hacettepeID: string,
    public semesterECTS: number
  ) {
    super(id, firstName, lastName, email, MemberType.STUDENT, phoneNumber, address, profilePhoto);
  }
}
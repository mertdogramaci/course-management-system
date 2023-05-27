export enum MemberType {
  ADMIN = "Admin",
  STUDENT = "Student",
  ACADEMICIAN = "Academician",
}

export class User {
  constructor(
    public id: number,
    public firstName: string,
    public lastName: string,
    public hacettepeId: string,
    public email: string,
    public memberType: string,
    public profilePhoto: string,
    public linkedInURL: string,
    public githubURL: string,
    public phoneNumber: string,
    public about: string,
    public experience: string,
    public interests: string
  ) {}
}
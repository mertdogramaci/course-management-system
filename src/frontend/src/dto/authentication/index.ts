import { User } from "../../@types/user";

export class LoginRequestDTO {
  constructor(
    public email: string,
    public password: string,
  ) { }
}

export class LoginResponseDTO {
  constructor(
    public accessToken:string,
    public user: User
  ) {}
}

export class EnrollmentRequestDTO {
  constructor(
    public firstName: string,
    public lastName: string,
    public hacettepeId: string,
    public email: string,
    public password: string,
    public memberType: string
  ) { }
}

export class JobCreateRequestDTO {
  constructor(
    public jobTitle: string,
    public jobDescription: string,
    public employerId: number,
  ) { }
}

export class JobUpdateRequestDTO {
  constructor(
    public jobTitle: string,
    public jobDescription: string,
  ) { }
}


export class ApplyJobRequestDTO {
  constructor(
    public jobId: number,
    public memberId: number,
  ) { }
}
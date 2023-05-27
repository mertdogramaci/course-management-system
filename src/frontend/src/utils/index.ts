import { AuthUser } from "../@types/authentication";
import { User } from "../@types/user";

export const isAdmin = (user: User | AuthUser | null | undefined) => {
  return user && user.memberType === "ADMIN";
}
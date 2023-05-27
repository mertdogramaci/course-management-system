import { ReactNode, useState } from 'react';
import { Navigate, useLocation } from 'react-router-dom';
import useAuth from '../hooks/useAuth';
import Login from '../pages/authentication/Login';

import { PATH_MAIN } from '../routes/paths';

type AuthGuardProps = {
  children: ReactNode;
  isAdminGuard?: boolean;
};

export default function AuthGuard({ children, isAdminGuard }: AuthGuardProps) {
  const { isAuthenticated, user } = useAuth();
  const { pathname } = useLocation();
  const [requestedLocation, setRequestedLocation] = useState<string | null>(null);

  if (!isAuthenticated) {
    if (pathname !== requestedLocation) {
      setRequestedLocation(pathname);
    }
    return <Login />;
  }

  if (requestedLocation && pathname !== requestedLocation) {
    if ((window.location.pathname.includes('/admin/') && user?.memberType !== "ADMIN")
        || (isAdminGuard && user?.memberType !== "ADMIN")) {
      setRequestedLocation(null);
      return <Navigate to={PATH_MAIN.feed} />;
    }
    setRequestedLocation(null);
    return <Navigate to={requestedLocation} />;
  }

  return <>{children}</>;
}

import { lazy, Suspense } from 'react';
import { Navigate, useRoutes } from 'react-router-dom';
import LoadingScreen from '../components/LoadingScreen';
import AuthGuard from '../guards/AuthGuard';
import GuestGuard from '../guards/GuestGuard';
import MainLayout from '../layouts/MainLayout';

const Loadable = (Component: any) => (props: any) => {
  // eslint-disable-next-line react-hooks/rules-of-hooks
  return (
    <Suspense fallback={<LoadingScreen />}>
      <Component {...props} />
    </Suspense>
  );
};

export default function Router() {
  return useRoutes([
    {
      path: 'auth',
      children: [
        {
          path: 'login',
          element: (
            <GuestGuard>
              <Login />
            </GuestGuard>
          )
        },
        {
          path: 'enroll',
          element: (
            <GuestGuard>
              <Enrollment />
            </GuestGuard>
          )
        },
        { path: 'forgot-password',
          element: (
          <GuestGuard>
            <ForgotPassword />
          </GuestGuard>
          )
        },
      ]
    },

    {
      path: '/admin',
      element: (
        <AuthGuard isAdminGuard>
          <MainLayout />
        </AuthGuard>
      ),
      children: [
        { path: '', element: <HomePage /> },
        { path: 'enrollment-requests', element: <EnrollmentRequests /> },
        { path: 'forgot-password-requests', element: <ForgotPasswordRequests /> },
      ]
    },

    // MainPage Routes
    {
      path: '/',
      element: (
        <AuthGuard>
          <MainLayout />
        </AuthGuard>
      ),
      children: [
        { path: '', element: <HomePage /> }
      ]
    },

    // Others
    { path: '/404', element: <NotFound /> },
    { path: '*', element: <Navigate to="/404" replace /> }
  ]);
}

const Login = Loadable(lazy(() => import('../pages/authentication/Login')))
const Enrollment = Loadable(lazy(() => import('../pages/authentication/Enrollment')))
const ForgotPassword = Loadable(lazy(() => import('../pages/authentication/ForgotPassword')))

const EnrollmentRequests= Loadable(lazy(() => import('../pages/admin/EnrollmentRequests')))
const ForgotPasswordRequests = Loadable(lazy(() => import('../pages/admin/ForgotPasswordRequests')))

const HomePage = Loadable(lazy(() => import('../components/HomePage')));

const NotFound = Loadable(lazy(() => import('../pages/NotFound')))


import { lazy, Suspense } from 'react';
import { Navigate, useRoutes } from 'react-router-dom';
import LoadingScreen from '../components/LoadingScreen';
import AuthGuard from '../guards/AuthGuard';
import GuestGuard from '../guards/GuestGuard';
import MainLayout from '../layouts/MainLayout';
import TranscriptPage from '../pages/student/pages/TranscriptPage';
import StudentsPage from '../pages/admin/students/StudentsPage';

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
        { path: '', element: <HomePage /> },
        { path: 'profile', element: <Profile />, children: [
          { path: ':id', element: <Profile /> }
        ] },
        { path: 'studentEnrollsSection', element: <CoursesPage /> },
        { path: 'settings', element: <Settings />},
        { path: 'sectionHasTimeSlot', element: <TimeTable/>},
        {path: 'transcript', element: <TranscriptPage/>},
        {path: 'members/fetchAllMembers', element: <StudentsPage/>}
      ]
    },

    // Others
    { path: '/404', element: <NotFound /> },
    { path: '*', element: <Navigate to="/404" replace /> }
  ]);
}

const Login = Loadable(lazy(() => import('../pages/authentication/Login')))
const Enrollment = Loadable(lazy(() => import('../pages/authentication/Enrollment')))

const EnrollmentRequests= Loadable(lazy(() => import('../pages/admin/EnrollmentRequests')))

const HomePage = Loadable(lazy(() => import('../components/HomePage')));
const Profile = Loadable(lazy(() => import('../pages/student/Profile')))
const CoursesPage = Loadable(lazy(() => import('../pages/student/pages/CoursesPage')))
const Settings = Loadable(lazy(() => import('../pages/Settings')))
const TimeTable = Loadable(lazy(() => import('../pages/student/pages/TimeTable')))


const NotFound = Loadable(lazy(() => import('../pages/NotFound')))



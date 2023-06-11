
function path(root: string, sublink: string) {
  return `${root}${sublink}`;
}

export const ROOTS_AUTH = '/auth';
export const ROOTS_ADMIN = '/admin';
export const ROOTS_MAIN = '/';

export const PATH_AUTH = {
  root: ROOTS_AUTH,
  login: path(ROOTS_AUTH, '/login'),
  register: path(ROOTS_AUTH, '/enroll'),
};

export const PATH_ADMIN = {
  root: ROOTS_MAIN,
  enrollmentRequests: path(ROOTS_ADMIN, '/enrollment-requests')
};

export const PATH_PAGE = {
  page404: '/404',
};

export const PATH_MAIN = {
  root: ROOTS_MAIN,
  feed: '/feed',
  jobs: '/jobs',
  events: '/events',
  presentations: '/presentations',
  chat: '/chat',
  myNetwork: '/myNetwork',
  profile: '/profile',
  settings: '/settings',
  courses: '/studentEnrollsSection',
  faculties: '/faculties',
  departments: '/departments',
  timetable: '/sectionHasTimeSlot',
  transcript: '/transcript',
  students: '/members/fetchAllMembers',
  log: '/log',
  courseRegistration: '/courseRegistration',
  advisor: '/advisor'
};
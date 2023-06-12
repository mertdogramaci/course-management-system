const ApiRoutes = {
  LOGIN: '/login',
  COURSES: '/studentEnrollsSection',
  SECTIONS_TO_ENROLL: '/studentEnrollsSection/getSectionsToEnroll',
  ENROLL_SECTION: '/studentEnrollsSection/enroll',
  PROFILE: '/members/profile',
  ENROLLMENT: '/enroll',
  APPROVE_ENROLLMENT: '/enroll/approve',
  DENY_ENROLLMENT: '/enroll/deny',
  SEARCH: '/members/search',
  CHANGE_PASSWORD: '/members/change-password',
  EVENT_LIST: '/event-list',
  ADD_CONTACT: '/contact/add',
  LIST_CONTACTS: '/contact/list',
  CONNECTION_REQUEST: '/contact/request',
  APPROVE_CONNECTION_REQUEST: '/contact/request/approve',
  DENY_CONNECTION_REQUEST: '/contact/request/deny',
  TIMETABLE: '/sectionHasTimeSlot',
  TRANSCRIPT: '/transcript',
  STUDENTS: '/members/fetchAllMembers',
  ADVISOR: '/instructorAdvisorStudent',
  MEMBER: '/members',
  ALLSTUDENTS: '/members/fetchAllStudents',
  SECTIONS: '/sections'
};

export default ApiRoutes;

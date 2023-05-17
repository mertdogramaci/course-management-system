import React from 'react';
import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import HomePage from './components/HomePage';
import StudentsPage from './components/pages/StudentsPage';
import SectionsPage from './components/pages/SectionsPage';
import CoursesPage from './components/pages/CoursesPage';
import DepartmentsPage from './components/pages/DepartmentsPage';
import FacultiesPage from './components/pages/FacultiesPage';
import HomeworksPage from './components/pages/HomeworksPage';
import InstructorsPage from './components/pages/InstructorsPage';
import InstructorContactInfosPage from './components/pages/InstructorContactInfosPage';
import StudentContactInfosPage from './components/pages/StudentContactInfosPage';
import SubmissionsPage from './components/pages/SubmissionsPage';

function App() {
  return (
    <div className='App'>
      <BrowserRouter>
        <Routes>
          <Route exact element={<HomePage />} path={"/"}/>
          <Route exact element={<StudentsPage />} path={"/students"}/>
          <Route exact element={<SectionsPage />} path={'/sections'}/>
          <Route exact element={<CoursesPage/>} path={'/courses'}/>
          <Route exact element={<DepartmentsPage/>} path={'/departments'}/>
          <Route exact element={<FacultiesPage/>} path={'/faculties'}/>
          <Route exact element={<HomeworksPage/>} path={'/homeworks'}/>
          <Route exact element={<InstructorsPage/>} path={'/instructors'}/>
          <Route exact element={<InstructorContactInfosPage/>} path={'/instructorContactInfos'}/>
          <Route exact element={<StudentContactInfosPage/>} path={'/studentContactInfos'}/>
          <Route exact element={<SubmissionsPage/>} path={'/submissions'}/>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;

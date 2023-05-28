import React from "react";
import 'bootstrap/dist/css/bootstrap.css';
import { Collapse, Nav, Navbar, NavbarBrand, NavItem, NavLink } from 'reactstrap';
import { Link } from 'react-router-dom';

function AppNavbar() {
    return (
        <Navbar collapseOnSelect expand="sm" bg="dark" variant="dark">
            <NavbarBrand tag={Link} to="/">Home</NavbarBrand>
            <Collapse navbar>
                <Nav className="me-auto">
                    <NavItem>
                        <NavLink href="/courses">Courses</NavLink>
                    </NavItem>
                    <NavItem>
                        <NavLink href="/departments">Departments</NavLink>
                    </NavItem>
                    <NavItem>
                        <NavLink href="/faculties">Faculties</NavLink>
                    </NavItem>
                    <NavItem>
                        <NavLink href="/homeworks">Homeworks</NavLink>
                    </NavItem>
                    <NavItem>
                        <NavLink href="/instructors">Instructors</NavLink>
                    </NavItem>
                    <NavItem>
                        <NavLink href="/instructorContactInfos">Instructor Contact Infos</NavLink>
                    </NavItem>
                    <NavItem>
                        <NavLink href="/sections">Sections</NavLink>
                    </NavItem>
                    <NavItem>
                        <NavLink href="/students">Students</NavLink>
                    </NavItem>
                    <NavItem>
                        <NavLink href="/studentContactInfos">Student Contact Infos</NavLink>
                    </NavItem>
                    <NavItem>
                        <NavLink href="/submissions">Submissions</NavLink>
                    </NavItem>
                    <NavItem>
                        <NavLink href="/timeSlots">Time Slots</NavLink>
                    </NavItem>
                </Nav>
            </Collapse>
        </Navbar>
    );
}

export default AppNavbar;
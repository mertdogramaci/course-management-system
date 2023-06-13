import React, { useEffect, useState } from "react";
import { useNavigate, useParams, Link } from "react-router-dom";
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import ApiRoutes from '../../../api/routes';
import axios from '../../../api/axios';

function EditStudent() {
    const initialStudentState = {
        address: "",
        email: "",
        firstName: "",
        hacettepeID: "",
        id: "",
        lastName: "",
        memberType: "",
        phoneNumber: "",
        semesterECTS: "",
    };

    const [student, setStudent] = useState(initialStudentState);
    const navigate = useNavigate();
    const { id } = useParams();

    useEffect(
        () => {
            fetchStudent();
        }, [id]
    );

    const fetchStudent = async () => {
        try {
            const response = await axios.get(ApiRoutes.MEMBER + "/findStudent/" + id);

            if (response.status === 200) {
                const fetchedStudent = response.data;

                console.log(response.data);

                if (JSON.stringify(fetchedStudent) !== JSON.stringify(student)) {
                    setStudent(fetchedStudent);
                }
            }
        } catch (error) {
            console.log("error!!");
        }
    }

    const handleChange = (event) => {
        const { name, value } = event.target;

        setStudent((prevState) => {
            return {
                ...prevState, [name]: value,
            };
        });
    }

    const handleSubmit = async (event) => {
        event.preventDefault();
        
        try {
            const response = await axios.put(ApiRoutes.MEMBER + id, student);
        } catch (error) {
            console.log("error");
        }
        
        navigate('/members/fetchAllMembers');
    }

    const title = <h2>Edit User</h2>;

    return (
        <div>
            <Container>
                {title}
                <Form onSubmit={handleSubmit}>
                    <FormGroup>
                        <Label for="firstName">Name</Label>
                        <Input type="text" name="firstName" id="firstName" value={student.firstName}
                            onChange={handleChange} autoComplete="name" />
                    </FormGroup>
                    <FormGroup>
                        <Label for="lastName">Surname</Label>
                        <Input type="text" name="lastName" id="lastName" value={student.lastName || ''}
                            onChange={handleChange} autoComplete="surname" />
                    </FormGroup>
                    <FormGroup>
                        <Label for="email">Email</Label>
                        <Input type="text" name="email" id="email" value={student.email || ''}
                            onChange={handleChange} autoComplete="email" />
                    </FormGroup>
                    <FormGroup>
                        <Label for="phoneNumber">Phone</Label>
                        <Input type="text" name="phoneNumber" id="phoneNumber" value={student.phoneNumber || ''}
                            onChange={handleChange} autoComplete="phone" />
                    </FormGroup>
                    <FormGroup>
                        <Label for="hacettepeID">Hacettepe ID</Label>
                        <Input type="text" name="hacettepeID" id="hacettepeID" value={student.hacettepeID || ''}
                            onChange={handleChange} autoComplete="hacettepeID" />
                    </FormGroup>
                    <FormGroup>
                        <Button color="primary" type="submit">Save</Button>{' '}
                        <Button color="secondary" tag={Link} to="/members/fetchAllMembers">Cancel</Button>
                    </FormGroup>
                </Form>
            </Container>
        </div>
    )
}

export default EditStudent;
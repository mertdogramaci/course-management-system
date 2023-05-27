import jwtDecode from 'jwt-decode';
import axios from '../api/axios';
import ApiRoutes from '../api/routes';

const isValidToken = (accessToken: string) => {
  if (!accessToken) {
    return false;
  }
  const decoded = jwtDecode<{ exp: number }>(accessToken);
  const currentTime = Date.now() / 1000;

  return decoded.exp > currentTime;
};

const setSession = (accessToken: string | null) => {
  if (accessToken) {
    localStorage.setItem('accessToken', accessToken);
    axios.defaults.headers.common.Authorization = `Bearer ${accessToken}`;

  } else {
    localStorage.removeItem('accessToken');
    delete axios.defaults.headers.common.Authorization;
  }
};

export const getToken = () => {
  return localStorage.getItem('accessToken');
}

export const fetchUserData = () => {
  return axios.get(ApiRoutes.PROFILE);
}

export let isStudent =
	!(getToken() === null) ? !atob(getToken()!.split('.')[1]).includes("ADMIN") && !atob(getToken()!.split('.')[1]).includes("STUDENT_REPRESENTATIVE")
  && !atob(getToken()!.split('.')[1]).includes("GRADUATE") && !atob(getToken()!.split('.')[1]).includes("ACADEMICIAN")  : false;

export { isValidToken, setSession };

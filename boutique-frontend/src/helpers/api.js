import axios from 'axios';

// const apiBaseUrl = "http://localhost:5245/WeatherForecast";
const apiBaseUrl = "http://10.0.2.2:5245/WeatherForecast";

export const checkRoomAvailability = (roomId, dateRange) => {
    return axios.post(`${apiBaseUrl}/Room/available/${roomId}`, dateRange);
};

export const getRooms = () => {
    return axios.get(`${apiBaseUrl}/Rooms`);
};

export const getRoomById = (roomId) => {
    return axios.get(`${apiBaseUrl}/Room/${roomId}`);
};

export const handleError = (error) => {
    if (error.response) {
        console.error('Server responded with error status:', error.response.status);
    } else if (error.request) {
        console.error('No response received:', error.request);
    } else {
        console.error('Error setting up request:', error.message);
    }
    console.error('API error:', error);
};
import axios from 'axios';

// const apiBaseUrl = "http://localhost:5245/WeatherForecast";
const apiBaseUrl = "http://localhost:8080/api";

export const checkRoomAvailability = (roomId, checkIn, checkOut) => {
    return axios.get(`${apiBaseUrl}/rooms/available?roomId=${roomId}&checkIn=${checkIn}&checkOut=${checkOut}`);
};

export const bookRoom = (bookingDetails) => {
    return axios.post(`${apiBaseUrl}/reservation`, bookingDetails);
};

export const getRooms = (page = 1) => {
    return axios.get(`${apiBaseUrl}/rooms?page=${page}`);
};

export const getRoomById = (roomId) => {
    return axios.get(`${apiBaseUrl}/rooms/${roomId}`);
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
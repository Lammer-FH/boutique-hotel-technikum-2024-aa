import { defineStore } from 'pinia';
import axios from 'axios';

export const useRoomsStore = defineStore('rooms', {
  state: () => ({
    rooms: []
  }),
  actions: {
    async fetchRooms() {
      axios.get('http://10.0.2.2:5245/WeatherForecast/Rooms')
        .then(response => {
            // Process the response data
            console.log(response.data);
            this.rooms = response.data
        })
        .catch(error => {
            // Handle errors
            if (error.response) {
                // The request was made and the server responded with a status code
                console.error('Server responded with error status:', error.response.status);
            } else if (error.request) {
                // The request was made but no response was received
                console.error('No response received:', error.request);
            } else {
                // Something else happened while setting up the request
                console.error('Error setting up request:', error.message);
            }
            console.error('Error fetching rooms:', error);
        });
      // try {
      //   console.log('Request URL: http://localhost:5245/WeatherForecast/Rooms');
      //   const response = await fetch('http://localhost:5245/WeatherForecast/Rooms');
      //   // console.log('Request URL: http://10.0.2.2:5245/WeatherForecast/Rooms');
      //   // const response = await fetch('http://10.0.2.2:5245/WeatherForecast/Rooms');
      //   const data = await response.json();
      //   console.error("Store received:" + data[0].imageUrl);
      //   this.rooms = data;
      // } catch (error) {
      //   console.error('Error fetching rooms:', error);
      // }
    }
  }
});
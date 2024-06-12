import { defineStore } from 'pinia';

export const useRoomsStore = defineStore('rooms', {
  state: () => ({
    rooms: []
  }),
  actions: {
    async fetchRooms() {
      try {
        const response = await fetch('http://localhost:5245/WeatherForecast/Rooms');
        const data = await response.json();
        console.error("Store received:" + data[0].imageUrl);
        this.rooms = data;
      } catch (error) {
        console.error('Error fetching rooms:', error);
      }
    }
  }
});
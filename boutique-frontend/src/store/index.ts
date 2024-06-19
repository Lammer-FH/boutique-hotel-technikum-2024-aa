import { defineStore } from 'pinia';
import { getRooms, handleError } from '../helpers/api';


export const useRoomsStore = defineStore('rooms', {
  state: () => ({
    rooms: []
  }),
  actions: {
    async fetchRooms() {
      getRooms()
        .then(response => {
          console.log('fetchRooms called')
          console.log(response.data);
          this.rooms = response.data
        })
        .catch(handleError);
    }
  }
});
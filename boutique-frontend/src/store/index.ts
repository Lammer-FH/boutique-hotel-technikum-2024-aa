import { defineStore } from 'pinia';
import { getRooms, handleError } from '../helpers/api';


export const useRoomsStore = defineStore('rooms', {
  state: () => ({
    rooms: [],
    totalPages: 0
  }),
  actions: {
    async fetchRooms(page = 1) {
      getRooms(page)
        .then(response => {
          console.log('fetchRooms called')
          console.log(response.data);
          this.rooms = response.data
          if (this.rooms.length % 5 == 0) {
            this.totalPages = this.rooms.length / 5 + 1;
          } else {
            this.totalPages = (this.rooms.length / 5) + 2;
          }
        })
        .catch(handleError);
    }
  }
});
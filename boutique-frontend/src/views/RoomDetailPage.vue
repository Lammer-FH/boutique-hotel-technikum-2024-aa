<!-- RoomPage.vue -->
<template>
    <ion-page>
        <Header title="Room Details"></Header>
        <ion-content>
            <div v-if="room">
                <h1>{{ room.name }}</h1>
                <p>{{ room.description }}</p>
                <img :src="room.imageUrl" alt="Room Image" />
                <!-- Add other room details here -->
                <DateRangePicker :id="room.id" />
            </div>
            <div v-else>
                <p>Loading...</p>
            </div>

        </ion-content>
    </ion-page>
</template>
<script>
import { defineComponent, ref, onMounted } from 'vue';
import { useRoute } from 'vue-router';
import { IonPage, IonHeader, IonToolbar, IonTitle, IonContent, IonItem, IonLabel, IonDatetime, IonButton } from '@ionic/vue';
import Header from '@/components/Header.vue';
import DateRangePicker from '@/components/DateRangePicker.vue';
import { getRoomById, handleError } from '../helpers/api';


export default defineComponent({
    name: 'RoomDetailPage',
    components: {
        IonPage,
        IonHeader,
        IonToolbar,
        IonTitle,
        IonContent,
        IonItem,
        IonLabel,
        IonDatetime,
        IonButton,
        Header,
        DateRangePicker
    },
    setup() {
        const route = useRoute();
        const room = ref(null);
        const fetchRoomDetails = async (id) => {
            getRoomById(id)
                .then(response => {
                    console.log(response.data);
                    room.value = response.data
                })
                .catch(handleError);
        };
        onMounted(() => {
            const roomId = route.params.id;
            fetchRoomDetails(roomId);
        });
        return {
            room
        };
    }
});
</script>
<style scoped>
/* Add styles for your room page here */
</style>
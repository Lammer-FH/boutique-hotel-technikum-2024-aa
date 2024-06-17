<!-- Impressum.vue -->
<template>
    <ion-page>
        <Header title="Room" />
        <ion-content>

            <ion-card v-for="room in rooms" :key="room.id" class="room-card">
                <img :src="room.imageUrl" :alt="room.name" class="room-image" />
                <ion-card-header>
                    <ion-card-title>{{ room.name }}</ion-card-title>
                    <ion-card-subtitle>{{ room.price }} €</ion-card-subtitle>
                </ion-card-header>
                <ion-card-content>
                    <p>{{ room.description }}</p>
                    <div class="room-extras">
                        <ion-icon :icon="wifiIcon" v-if="room.extras.includes('wifi')"></ion-icon>
                        <ion-icon :icon="tvIcon" v-if="room.extras.includes('tv')"></ion-icon>
                        <ion-icon :icon="acIcon" v-if="room.extras.includes('ac')"></ion-icon>
                    </div>
                </ion-card-content>
            </ion-card>
            <ion-footer>
                <ion-toolbar>
                    <ion-buttons slot="end">
                        <ion-button @click="loadPreviousPage" :disabled="page === 1">Previous</ion-button>
                        <ion-button @click="loadNextPage">Next</ion-button>
                    </ion-buttons>
                </ion-toolbar>
            </ion-footer>

        </ion-content>
    </ion-page>
</template>

<script lang="ts">
import { defineComponent, ref, onMounted, computed } from 'vue';
import {
    IonPage,
    IonHeader,
    IonToolbar,
    IonButtons,
    IonMenuButton,
    IonTitle,
    IonContent,
    IonCard,
    IonCardHeader,
    IonCardTitle,
    IonCardSubtitle,
    IonCardContent,
    IonFooter,
    IonButton,
    IonIcon
} from '@ionic/vue';
import { wifi, tv, snow } from 'ionicons/icons'; // Import the icons you need
import Header from '@/components/Header.vue';
import { useRoomsStore } from '@/store';
import { Room } from '@/models/room.ts';


export default defineComponent({
    name: 'Rooms',
    components: {
        IonPage,
        IonHeader,
        IonToolbar,
        IonButtons,
        IonMenuButton,
        IonTitle,
        IonContent,
        IonCard,
        IonCardHeader,
        IonCardTitle,
        IonCardSubtitle,
        IonCardContent,
        IonFooter,
        IonButton,
        IonIcon,
        Header
    },
    setup() {
        console.log('SETUP ROOMS');

        const roomsStore = useRoomsStore();

        // Fetch rooms data when component is mounted
        roomsStore.fetchRooms();
        
        // Use computed property to access rooms data from store
        const rooms = computed(() => roomsStore.rooms as Room[]);


        const page = ref(1);
        const pageSize = 5;

        // Icons for room extras
        const wifiIcon = wifi;
        const tvIcon = tv;
        const acIcon = snow;

        

        function loadNextPage() {
            page.value++;
            console.error("Test error Room");
            // fetchRooms();
        }

        function loadPreviousPage() {
            console.error("Test error Room");

            if (page.value > 1) {
                page.value--;
                // fetchRooms();
            }
        }

        onMounted(() => {
            // fetchRooms();
        });

        return {
            rooms,
            page,
            wifiIcon,
            tvIcon,
            acIcon,
            loadNextPage,
            loadPreviousPage
        };
    }
});
</script>

<style scoped>
.room-card {
    margin-bottom: 20px;
}

.room-image {
    width: 100%;
    height: auto;
    object-fit: cover;
}

.room-extras ion-icon {
    font-size: 24px;
    margin-right: 10px;
}
</style>
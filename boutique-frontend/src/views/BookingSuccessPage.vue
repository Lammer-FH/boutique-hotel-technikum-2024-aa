<template>
    <ion-page>
        <Header title="Booking Success"></Header>
        <ion-content>
            <div class="booking-success">
                <h1>Booking Successful!</h1>
                <h4>Guest Information</h4>
                <p>First Name: {{ firstName }}</p>
                <p>Last Name: {{ lastName }}</p>
                <p>Email: {{ email }}</p>
                <p>Start Date: {{ startDate }}</p>
                <p>End Date: {{ endDate }}</p>
                <p>Include Breakfast: {{ includeBreakfast ? 'Yes' : 'No' }}</p>
                <p>RoomType: {{ roomType }}</p>
                <p>Description: {{ description }}</p>
                <div class="room-extras">
                        <ion-icon :icon="wifiIcon" v-if="extras.includes('wifi')"></ion-icon>
                        <ion-icon :icon="tvIcon" v-if="extras.includes('tv')"></ion-icon>
                        <ion-icon :icon="acIcon" v-if="extras.includes('ac')"></ion-icon>
                </div>
                <img :src="imageUrl" alt="Room Image" />
                <h4>Contact Information</h4>
                <ion-card>
                    <ion-card-header>
                        <ion-card-title>Contact Information</ion-card-title>
                    </ion-card-header>
                    <ion-card-content>
                        <p><strong>Hotel Name:</strong> {{ hotelName }}</p>
                        <p><strong>Address:</strong> {{ address }}</p>
                        <p><strong>Phone:</strong> {{ phone }}</p>
                        <p><strong>Email:</strong> <a :href="`mailto:${companyEmail}`">{{ companyEmail }}</a></p>
                    </ion-card-content>
                </ion-card>
            </div>
            <ion-card-content>
                <p>Location description</p>
                <iframe :src="locationMapUrl" width="100%" height="450" style="border:0;" loading="lazy"></iframe>
            </ion-card-content>
        </ion-content>
    </ion-page>

</template>

<script>
import { defineComponent, computed } from 'vue';
import { IonPage, IonHeader, IonToolbar, IonTitle, IonContent, IonItem, IonButton } from '@ionic/vue';
import { useRoute } from 'vue-router';
import Header from '@/components/Header.vue';
import { wifi, tv, snow } from 'ionicons/icons'; // Import the icons you need


export default defineComponent({
    name: 'BookingSuccess',
    components: {
        IonPage,
        IonHeader,
        IonToolbar,
        IonTitle,
        IonContent,
        IonButton,
        IonItem,
        Header,
    },
    data() {
    return {
      hotelName: 'Boutique Bliss',
      address: '123 Boutique St, City, Country',
      phone: '+123 456 7890',
      companyEmail: 'info@boutiquebliss.com',
    }
  },
    setup() {

        // Icons for room extras
        const wifiIcon = wifi;
        const tvIcon = tv;
        const acIcon = snow;

        const route = useRoute();

        // Computed properties to retrieve booking details from query parameters
        const firstName = route.params.firstName;
        const lastName = route.params.lastName;
        const email = route.params.email;
        const includeBreakfast = route.params.includeBreakfast == "true";
        const startDate = route.params.startDate;
        const endDate = route.params.endDate;
        const extras = route.params.extras ? route.params.extras.split(',') : []; // Split extras into array
        const roomType = route.params.roomType;
        const description = route.params.description;
        const imageUrl = route.params.imageUrl;

        return {
            firstName,
            lastName,
            email,
            includeBreakfast,
            startDate,
            endDate,
            extras,
            wifiIcon,
            tvIcon,
            acIcon,
            roomType,
            description,
            imageUrl,
            locationMapUrl: 'https://www.google.com/maps/embed?...'
        };
    }
});
</script>

<style scoped>
.booking-success {
    padding: 16px;
}
</style>

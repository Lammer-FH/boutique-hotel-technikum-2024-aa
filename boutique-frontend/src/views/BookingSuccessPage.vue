<template>
    <ion-page>
        <Header title="Booking Success"></Header>
        <ion-content>
            <div class="booking-success">
                <h1>Booking Successful!</h1>
                <p>First Name: {{ firstName }}</p>
                <p>Last Name: {{ lastName }}</p>
                <p>Email: {{ email }}</p>
                <p>Start Date: {{ startDate }}</p>
                <p>End Date: {{ endDate }}</p>
                <p>Include Breakfast: {{ includeBreakfast ? 'Yes' : 'No' }}</p>
            </div>

        </ion-content>
    </ion-page>

</template>

<script>
import { defineComponent, computed } from 'vue';
import { IonPage, IonHeader, IonToolbar, IonTitle, IonContent, IonItem, IonButton } from '@ionic/vue';
import { useRoute } from 'vue-router';
import Header from '@/components/Header.vue';

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
    setup() {
        const route = useRoute();

        // Computed properties to retrieve booking details from query parameters
        const firstName = route.params.firstName;
        const lastName = route.params.lastName;
        const email = route.params.email;
        const includeBreakfast = route.params.includeBreakfast == "true";
        const startDate = route.params.startDate;
        const endDate = route.params.endDate;

        return {
            firstName,
            lastName,
            email,
            includeBreakfast,
            startDate,
            endDate
        };
    }
});
</script>

<style scoped>
.booking-success {
    padding: 16px;
}
</style>

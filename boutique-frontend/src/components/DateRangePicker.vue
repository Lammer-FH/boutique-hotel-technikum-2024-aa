<template>
    <div class="date-range-picker">
        <ion-grid>
            <ion-row>
                <ion-col size="6">
                    <ion-item lines="none">
                        <ion-label position="stacked">Start Date</ion-label>
                        <ion-datetime display-format="MM/DD/YYYY" :min="minDate" :max="maxDate" v-model="startDate"
                            presentation="date" placeholder="Select Start Date"></ion-datetime>
                    </ion-item>
                </ion-col>
                <ion-col size="6">
                    <ion-item lines="none">
                        <ion-label position="stacked">End Date</ion-label>
                        <ion-datetime display-format="MM/DD/YYYY" :min="startDate" :max="maxDate" v-model="endDate"
                            presentation="date" placeholder="Select End Date"></ion-datetime>
                    </ion-item>
                </ion-col>
            </ion-row>
        </ion-grid>
        <ion-button expand="block" @click="checkAvailability">Check Availability</ion-button>
        <div v-if="isRoomAvailable">
            <ion-row>
                <ion-col size="12" size-md="6">
                    <ion-item lines="none">
                        <ion-input v-model="firstName" label="First Name: " placeholder="Enter first name"></ion-input>
                    </ion-item>
                </ion-col>
                <ion-col size="12" size-md="6">
                    <ion-item lines="none">
                        <ion-input v-model="lastName" label="Last Name: " placeholder="Enter last name"></ion-input>
                    </ion-item>
                </ion-col>
                <ion-col size="12" size-md="6">
                    <ion-item lines="none">
                        <ion-input v-model="email" label="Email: " placeholder="Enter email" type="email"></ion-input>
                    </ion-item>
                </ion-col>
                <ion-col size="12" size-md="6">
                    <ion-item lines="none">
                        <ion-input v-model="confirmEmail" label="Confirm Email: "
                            placeholder="Enter email again"></ion-input>
                    </ion-item>
                </ion-col>
                <ion-col size="12" size-md="6">
                    <ion-item lines="none">
                        <ion-checkbox v-model="includeBreakfast"></ion-checkbox>
                        <ion-label>I want breakfast</ion-label>
                    </ion-item>
                </ion-col>
            </ion-row>

            <ion-button :disabled="!isRoomAvailable" expand="block" @click="handleRoomBooking">Book Room</ion-button>
        </div>
    </div>
</template>

<script>
import { defineComponent, ref } from 'vue';
import { useRouter } from 'vue-router';
import { IonGrid, IonRow, IonCol, IonItem, IonLabel, IonDatetime, IonButton, IonInput, IonCheckbox } from '@ionic/vue';
import { checkRoomAvailability, bookRoom, handleError } from '../helpers/api';

export default defineComponent({
    name: 'DateRangePicker',
    props: ['id'],
    components: {
        IonGrid,
        IonRow,
        IonCol,
        IonItem,
        IonLabel,
        IonDatetime,
        IonButton,
        IonInput,
        IonCheckbox
    },
    setup(props) {
        // form
        const isRoomAvailable = ref(false);
        const firstName = ref('');
        const lastName = ref('');
        const email = ref('');
        const confirmEmail = ref('');
        const includeBreakfast = ref(false);

        // datepicker
        const today = new Date().toISOString().split('T')[0];
        const tomorrow = new Date(today);
        tomorrow.setDate(tomorrow.getDate() + 1);
        const startDate = ref(today);
        const endDate = ref(tomorrow.toISOString().split('T')[0]);
        const minDate = today;
        const maxDate = new Date(new Date().setFullYear(new Date().getFullYear() + 1)).toISOString().split('T')[0];

        const router = useRouter();

        const checkAvailability = () => {
            if (startDate.value && endDate.value) {
                const selectedDateRange = {
                    start: startDate.value,
                    end: endDate.value
                };
                checkRoomAvailability(props.id, selectedDateRange)
                    .then(response => {
                        isRoomAvailable.value = response.data;
                    })
                    .catch(handleError);
            } else {
                console.error('Both start and end dates must be selected');
            }
        };

        const handleRoomBooking = () => {
            const bookingDetails = {
                firstName: firstName.value,
                lastName: lastName.value,
                email: email.value,
                confirmEmail: confirmEmail.value,
                includeBreakfast: includeBreakfast.value,
                startDate: startDate.value,
                endDate: endDate.value,
            };
            bookRoom(props.id, bookingDetails)
                .then(() => {
                    const queryString = `/${encodeURIComponent(firstName.value)}/${encodeURIComponent(lastName.value)}/${encodeURIComponent(email.value)}/${encodeURIComponent(confirmEmail.value)}/${encodeURIComponent(includeBreakfast.value)}/${encodeURIComponent(startDate.value)}/${encodeURIComponent(endDate.value)}`;
                    console.log(queryString);
                    // Navigate to booking success page with query parameters
                    router.push({ path: `/booking-success${queryString}` });
                })
                .catch(handleError);
        };

        return {
            startDate,
            endDate,
            minDate,
            maxDate,
            isRoomAvailable,
            checkAvailability,
            handleRoomBooking,
            firstName,
            lastName,
            email,
            confirmEmail,
            includeBreakfast,
        };
    }
});
</script>

<style scoped>
.date-range-picker {
    padding: 16px;
}

ion-item {
    margin-bottom: 16px;
}
</style>

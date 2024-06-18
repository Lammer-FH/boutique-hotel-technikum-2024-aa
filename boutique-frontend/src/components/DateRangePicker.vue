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
    </div>
</template>

<script>
import { defineComponent, ref } from 'vue';
import { useRouter } from 'vue-router';
import { IonGrid, IonRow, IonCol, IonItem, IonLabel, IonDatetime, IonButton, IonInput, IonCheckbox } from '@ionic/vue';
import { checkRoomAvailability, handleError } from '../helpers/api';

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

        return {
            startDate,
            endDate,
            minDate,
            maxDate,
            isRoomAvailable,
            checkAvailability,
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

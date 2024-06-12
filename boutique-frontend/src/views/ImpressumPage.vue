<!-- Impressum.vue -->
<template>
  <ion-page>
    <Header title="Impressum" />

    <ion-content>

      <ion-card>
        <ion-card-header>
          <ion-card-title>Legal Information</ion-card-title>
        </ion-card-header>
        <ion-card-content>
          <p>{{ legalInfo }}</p>
        </ion-card-content>
      </ion-card>

      <ion-card>
        <ion-card-header>
          <ion-card-title>Contact Information</ion-card-title>
        </ion-card-header>
        <ion-card-content>
          <p><strong>Hotel Name:</strong> {{ hotelName }}</p>
          <p><strong>Address:</strong> {{ address }}</p>
          <p><strong>Phone:</strong> {{ phone }}</p>
          <p><strong>Email:</strong> <a :href="`mailto:${email}`">{{ email }}</a></p>
        </ion-card-content>
      </ion-card>

      <ion-card>
        <ion-card-header>
          <ion-card-title>Managing Director</ion-card-title>
        </ion-card-header>
        <ion-card-content>
          <p>{{ managingDirector }}</p>
        </ion-card-content>
      </ion-card>

      <ion-card>
        <ion-card-header>
          <ion-card-title>Company Details</ion-card-title>
        </ion-card-header>
        <ion-card-content>
          <p><strong>Company Name:</strong> {{ companyName }}</p>
          <p><strong>Registration Number:</strong> {{ registrationNumber }}</p>
          <p><strong>VAT Number:</strong> {{ vatNumber }}</p>
        </ion-card-content>
      </ion-card>

      <ion-card>
        <ion-card-header>
          <ion-card-title>Disclaimer</ion-card-title>
        </ion-card-header>
        <ion-card-content>
          <p>{{ disclaimer }}</p>
        </ion-card-content>
      </ion-card>

    </ion-content>
  </ion-page>
</template>

<script>
import { defineComponent } from 'vue';
import { IonPage, IonHeader, IonToolbar, IonTitle, IonContent } from '@ionic/vue';
import Header from '@/components/Header.vue';

export default defineComponent({
  name: 'ImpressumPage',
  components: {
    IonPage,
    IonHeader,
    IonToolbar,
    IonTitle,
    IonContent,
    Header
  },
  data() {
    return {
      hotelName: 'Boutique Bliss',
      address: '123 Boutique St, City, Country',
      phone: '+123 456 7890',
      email: 'info@boutiquebliss.com',
      managingDirector: 'Jane Doe',
      companyName: 'Boutique Bliss Ltd.',
      registrationNumber: '123456789',
      vatNumber: 'VAT123456789',
      legalInfo: 'This is the legal information required for an Impressum. Please provide accurate and complete information as required by local laws and regulations.',
      disclaimer: 'The content of this website has been created with the utmost care. However, we cannot guarantee the accuracy, completeness, or timeliness of the content. Any reliance you place on such information is therefore strictly at your own risk.'
    }
  }
});
</script>

<style scoped>
ion-content {
  --padding-start: 16px;
  --padding-end: 16px;
}

ion-card {
  margin-bottom: 20px;
}

ion-card-title {
  font-size: 1.5em;
  font-weight: bold;
}

ion-card-content p {
  font-size: 1em;
  line-height: 1.6;
}

@media (min-width: 768px) {
  ion-card-content p {
    font-size: 1.1em;
  }
}

@media (max-width: 767px) {
  ion-card-content p {
    font-size: 1em;
  }
}
</style>

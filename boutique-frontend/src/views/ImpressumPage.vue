<!-- Impressum.vue -->
<template>
    <ion-page>
      <ion-header>
        <ion-toolbar>
          <ion-title>Impressum</ion-title>
        </ion-toolbar>
      </ion-header>
      <ion-content>
        <p>Content Impressum</p>
      </ion-content>
    </ion-page>
  </template>
  
  <script>
  import { defineComponent } from 'vue';
  import { IonPage, IonHeader, IonToolbar, IonTitle, IonContent } from '@ionic/vue';
  
  export default defineComponent({
    name: 'ImpressumPage',
    components: {
      IonPage,
      IonHeader,
      IonToolbar,
      IonTitle,
      IonContent
    }
  });
  </script>
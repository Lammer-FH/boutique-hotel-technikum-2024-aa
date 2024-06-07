<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <Header title="About" />
      </ion-toolbar>
    </ion-header>
    <ion-content>
      <p>Content About</p>
    </ion-content>
  </ion-page>
</template>

<script>
import { defineComponent } from 'vue';
import { IonPage, IonHeader, IonToolbar, IonTitle, IonContent } from '@ionic/vue';
import Header from '@/components/Header.vue'


export default defineComponent({
  name: 'AboutPage',
  components: {
    IonPage,
    IonHeader,
    IonToolbar,
    IonTitle,
    IonContent,
    Header
  }
});
</script>
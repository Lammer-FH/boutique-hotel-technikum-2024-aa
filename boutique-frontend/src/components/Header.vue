<!-- src/components/Header.vue -->
<template>
  <ion-header>
    <ion-toolbar>
      <ion-title>{{ title }}</ion-title>
    </ion-toolbar>
  </ion-header>
</template>

<script setup>
import { defineProps } from 'vue';
import { IonHeader, IonToolbar, IonTitle } from '@ionic/vue';

const props = defineProps({
  title: {
    type: String,
    required: true,
  },
});
</script>
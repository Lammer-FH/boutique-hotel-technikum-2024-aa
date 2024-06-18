<!-- src/components/Header.vue -->
<template>
  <ion-header>
    <ion-toolbar>
      <ion-buttons slot="start">
          <ion-menu-button></ion-menu-button>
      </ion-buttons>
      <ion-title>{{ title }}</ion-title>
    </ion-toolbar>
  </ion-header>
</template>

<script setup>
import { defineProps } from 'vue';
import { IonHeader, IonToolbar, IonTitle, IonMenuButton } from '@ionic/vue';

const props = defineProps({
  title: {
    type: String,
    required: true,
  },
});
</script>
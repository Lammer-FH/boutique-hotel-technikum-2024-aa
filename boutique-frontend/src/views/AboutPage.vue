<template>
  <ion-page>
    <Header title="About"/>
    <ion-content>

      <ion-card>
        <ion-card-header>
          <ion-card-title>{{ hotelName }}</ion-card-title>
          <ion-card-subtitle>Welcome to our boutique hotel</ion-card-subtitle>
        </ion-card-header>
        <ion-card-content>
          <p>{{ introduction }}</p>
        </ion-card-content>
      </ion-card>

      <ion-card>
        <ion-card-header>
          <ion-card-title>Our Vision</ion-card-title>
        </ion-card-header>
        <ion-card-content>
          <p>{{ vision }}</p>
        </ion-card-content>
      </ion-card>

      <ion-card>
        <ion-card-header>
          <ion-card-title>Meet the Team</ion-card-title>
        </ion-card-header>
        <ion-card-content>
          <ion-grid>
            <ion-row>
              <ion-col size="12" size-md="6" v-for="member in team" :key="member.name">
                <ion-card>
                  <ion-card-header>
                    <ion-avatar slot="start">
                    </ion-avatar>
                    <ion-card-title>{{ member.name }}</ion-card-title>
                    <ion-card-subtitle>{{ member.role }}</ion-card-subtitle>
                  </ion-card-header>
                  <ion-card-content>
                    <p>{{ member.bio }}</p>
                  </ion-card-content>
                </ion-card>
              </ion-col>
            </ion-row>
          </ion-grid>
        </ion-card-content>
      </ion-card>

      <ion-card>
        <ion-card-header>
          <ion-card-title>Our Location</ion-card-title>
        </ion-card-header>
        <ion-card-content>
          <p>{{ locationDescription }}</p>
          <iframe :src="locationMapUrl" width="100%" height="450" style="border:0;"
            loading="lazy"></iframe>
        </ion-card-content>
      </ion-card>

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
  },
  data() {
    console.log('SETUP ROOMS');
    return {
      hotelName: 'Boutique Bliss',
      introduction: 'Nestled in the heart of the city, Boutique Bliss offers a unique blend of modern luxury and historic charm. Established in 2020, our hotel has become a beloved destination for travelers seeking a distinctive and memorable experience.',
      vision: 'Our vision is to create a sanctuary where guests can unwind and feel at home. We are dedicated to providing exceptional service, personalized experiences, and a welcoming atmosphere that reflects the spirit of our vibrant city.',
      team: [
        {
          name: 'Jane Doe',
          role: 'Founder & CEO',
          bio: 'Jane founded Boutique Bliss with a passion for hospitality and a vision for creating unique guest experiences. With over 20 years of experience in the hotel industry, she leads our team with dedication and care.',
          image: 'path/to/jane-image.jpg'
        },
        {
          name: 'John Smith',
          role: 'Head Chef',
          bio: 'John brings a wealth of culinary expertise to Boutique Bliss. His innovative approach to cuisine and commitment to using locally sourced ingredients ensure that every meal is a delightful experience.',
          image: 'path/to/john-image.jpg'
        },
      ],
      locationDescription: 'Located in the historic district, our hotel is within walking distance of many popular attractions, shops, and restaurants. Enjoy the vibrant local culture and the convenience of our central location.',
      locationMapUrl: 'https://www.google.com/maps/embed?...'
    }
  }
});
</script>


<style scoped>
.about-page {
  padding: 20px;
  max-width: 800px;
  margin: 0 auto;
  font-family: Arial, sans-serif;
}

.header {
  text-align: center;
}

.header h1 {
  font-size: 2.5em;
  margin-bottom: 0.5em;
}

.header p {
  font-size: 1.2em;
  color: #777;
}

.content section {
  margin-bottom: 40px;
}

.content h2 {
  font-size: 2em;
  margin-bottom: 10px;
}

.content p {
  font-size: 1.1em;
  line-height: 1.6;
  color: #555;
}

.team-members {
  display: flex;
  flex-wrap: wrap;
  gap: 20px;
}

.team-member {
  flex: 1 1 200px;
  text-align: center;
}

.team-member img {
  width: 150px;
  height: 150px;
  border-radius: 50%;
  object-fit: cover;
  margin-bottom: 10px;
}

.team-member h3 {
  font-size: 1.5em;
  margin: 0.5em 0;
}

.team-member p {
  font-size: 1em;
  color: #777;
}
</style>
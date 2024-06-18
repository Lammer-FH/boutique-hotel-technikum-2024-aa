<!-- Home.vue -->
<template>
  <ion-page>
    <Header title="Home"/>
    <ion-content>
      <div class="landing-page">
        <section class="hero">
          <div class="hero-text">
            <h1>Welcome to Our Boutique Hotel</h1>
            <p>Experience luxury and comfort in the heart of the city</p>
            <ion-button expand="block" router-link="/rooms">Explore Our Rooms</ion-button>
          </div>
        </section>

        <section class="about">
          <ion-card>
            <ion-card-header>
              <ion-card-title>About Us</ion-card-title>
            </ion-card-header>
            <ion-card-content>
              <p>
                Nestled in the vibrant cityscape, our boutique hotel offers an oasis of tranquility and style. With a rich history and modern amenities, we provide a unique experience that combines the charm of the past with the luxuries of the present.
              </p>
            </ion-card-content>
          </ion-card>
        </section>

        <section class="facilities">
          <ion-card>
            <ion-card-header>
              <ion-card-title>Our Facilities</ion-card-title>
            </ion-card-header>
            <ion-card-content>
              <ion-grid>
                <ion-row>
                  <ion-col size="12" size-md="6">
                    <ion-icon name="restaurant" size="large"></ion-icon>
                    <h2>Gourmet Dining</h2>
                    <p>Indulge in our exquisite culinary delights prepared by top chefs.</p>
                  </ion-col>
                  <ion-col size="12" size-md="6">
                    <ion-icon name="fitness" size="large"></ion-icon>
                    <h2>Fitness Center</h2>
                    <p>Stay fit and energized with our state-of-the-art fitness facilities.</p>
                  </ion-col>
                </ion-row>
                <ion-row>
                  <ion-col size="12" size-md="6">
                    <ion-icon name="spa" size="large"></ion-icon>
                    <h2>Spa & Wellness</h2>
                    <p>Relax and rejuvenate with our luxurious spa treatments.</p>
                  </ion-col>
                  <ion-col size="12" size-md="6">
                    <ion-icon name="bed" size="large"></ion-icon>
                    <h2>Luxurious Rooms</h2>
                    <p>Enjoy a restful stay in our elegantly designed rooms and suites.</p>
                  </ion-col>
                </ion-row>
              </ion-grid>
            </ion-card-content>
          </ion-card>
        </section>

        <section class="contact">
          <ion-card>
            <ion-card-header>
              <ion-card-title>Contact Us</ion-card-title>
            </ion-card-header>
            <ion-card-content>
              <p>For reservations and inquiries, please contact us at:</p>
              <ion-list>
                <ion-item>
                  <ion-icon slot="start" name="call"></ion-icon>
                  <ion-label>(123) 456-7890</ion-label>
                </ion-item>
                <ion-item>
                  <ion-icon slot="start" name="mail"></ion-icon>
                  <ion-label>info@boutiquehotel.com</ion-label>
                </ion-item>
              </ion-list>
              <ion-button expand="block" router-link="/about">Get in Touch</ion-button>
            </ion-card-content>
          </ion-card>
        </section>
      </div>
    </ion-content>
  </ion-page>
</template>

<script>
import { defineComponent } from 'vue';
import { IonPage, IonHeader, IonToolbar, IonTitle, IonContent, IonButton } from '@ionic/vue';
import HelloSpringWorld from '@/components/HelloSpringWorld.vue';
import Header from '@/components/Header.vue';

export default defineComponent({
  name: 'HomePage',
  components: {
    IonPage,
    IonHeader,
    IonToolbar,
    IonTitle,
    IonContent,
    IonButton,
    HelloSpringWorld,
    Header
  }
});
</script>

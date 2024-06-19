import { createRouter, createWebHistory } from '@ionic/vue-router';
import { RouteRecordRaw } from 'vue-router';
import AboutPage from '@/views/AboutPage.vue';
import HomePage from '../views/HomePage.vue';
import ImpressumPage from '../views/ImpressumPage.vue'
import RoomPage from '../views/RoomPage.vue'
import RoomDetailPage from '../views/RoomDetailPage.vue'
import BookingSuccessPage from '@/views/BookingSuccessPage.vue';

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    redirect: '/home'
  },
  {
    path: '/home',
    component: HomePage
  },
  {
    path: '/about',
    component: AboutPage
  },
  {
    path: '/impressum',
    component: ImpressumPage
  },
  {
    path: '/rooms',
    name: 'Rooms',
    component: RoomPage
  },
  {
    path: '/room/:id',
    name: 'RoomDetail',
    component: RoomDetailPage,
    props: true
  },
  {
    path: '/booking-success/:firstName/:lastName/:email/:confirmEmail/:includeBreakfast/:startDate/:endDate/:extras/:roomType/:description/:imageUrl',
    name: 'BookingSuccess',
    component: BookingSuccessPage,
    props: true
  }
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})


export default router

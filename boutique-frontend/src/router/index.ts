import { createRouter, createWebHistory } from '@ionic/vue-router';
import { RouteRecordRaw } from 'vue-router';
import AboutPage from '@/views/AboutPage.vue';
import HomePage from '../views/HomePage.vue';
import ImpressumPage from '../views/ImpressumPage.vue'
import RoomPage from '../views/RoomPage.vue'

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
    component: RoomPage
  }
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})


export default router

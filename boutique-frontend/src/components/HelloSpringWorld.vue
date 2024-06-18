<template>
  <div class="hello">
    <h1>{{ hellomsg }}</h1>
    <h2>See the sources here: </h2>
    <ul>
      <li><a href="https://github.com/jonashackt/spring-boot-vuejs"
          target="_blank">github.com/jonashackt/spring-boot-vuejs</a></li>
    </ul>
    <h3>This site contains more stuff</h3>
    <ul>
      <li>HowTo call REST-Services:</li>
      <li><router-link to="/callservice">/callservice</router-link></li>
      <li>HowTo to play around with Bootstrap UI components:</li>
      <li><router-link to="/bootstrap">/bootstrap</router-link></li>
      <li>HowTo to interact with the Spring Boot database backend:</li>
      <li><router-link to="/user">/user</router-link></li>
      <li>Login to the secured part of the application</li>
      <li><router-link to="/login">/login</router-link></li>
      <li>A secured part of this application:</li>
      <li><router-link to="/protected">/protected</router-link></li>
    </ul>
  </div>
</template>

<script>
import { defineComponent } from 'vue';

export default defineComponent({
  name: 'HelloSpringWorld',
  props: {
    hellomsg: {
      type: String,
      required: true
    }
  }
})
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="css">
h1,
h2 {
  font-weight: normal;
}

a {
  color: #42b983;
}
</style>
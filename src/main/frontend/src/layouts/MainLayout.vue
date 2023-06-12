<template>
  <q-layout view="hHh LpR fFf">

    <q-header elevated class="bg-primary text-white">
      <q-toolbar>
        <q-btn dense flat round icon="menu" @click="toggleLeftDrawer" />

        <q-toolbar-title>
          Banking Management
        </q-toolbar-title>
      </q-toolbar>
    </q-header>

    <q-drawer show-if-above v-model="leftDrawerOpen" side="left" bordered>
      <q-list>
        <q-item-label header>Menü</q-item-label>

        <EssentialLink v-for="link in essentialLinks" :key="link.title" v-bind="link" />
      </q-list>
    </q-drawer>

    <q-page-container>
      <router-view />
    </q-page-container>

  </q-layout>
</template>

<script>
import { ref } from 'vue'
import EssentialLink from "components/EssentialLink.vue";

const linksList = [
  {
    title: "Docs",
    to:""
  },
  {
    title: "Github",
    to:""
  },
  {
    title: "Discord Chat Channel",
    to:""
  },
  {
    title: "Forum",
    to:""
  },
  {
    title: "Twitter",
    to:""
  },
  {
    title: "Facebook",
    to:""
  },
  {
    title: "Quasar Awesome",
    to:""
  },
];

export default {
  components: {
    EssentialLink,
  },
  setup () {
    const leftDrawerOpen = ref(false)

    return {
      essentialLinks: linksList,
      leftDrawerOpen,
      toggleLeftDrawer () {
        leftDrawerOpen.value = !leftDrawerOpen.value
      }
    }
  }
}
</script>

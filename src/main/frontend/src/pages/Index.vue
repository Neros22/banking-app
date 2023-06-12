<template>
  <q-page class="flex flex-center">
<UserCreation/>
  </q-page>
</template>

<script>
import { defineComponent } from "vue";
import UserCreation from "components/UserCreation";

export default defineComponent({
  name: "PageIndex",
  components: {UserCreation},
});
</script>

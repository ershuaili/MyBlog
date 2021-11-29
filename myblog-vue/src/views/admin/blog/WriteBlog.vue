<template>
  <div style="height: 650px;">
    <md-editor v-model="text" :toolbarsExclude="toolbarsExclude" class="meEditor"/>
  </div>
</template>

<script>
import MdEditor from "md-editor-v3";
import 'md-editor-v3/lib/style.css';

export default {
  name: "WriteBlog",
  components: {MdEditor},
  data() {
    return {
      text: '',
      toolbarsExclude: ['github'],
    };
  },
}
</script>

<style scoped>
.meEditor {
  height: 100%;
}
</style>
<template>
  <router-view/>
</template>

<script>
export default {
  name: 'App',
  components: {}
}
</script>

<style>
html, body {
  margin: 0;
  padding: 0;
  overflow-y: scroll;
  overflow-x: hidden;
}
/*滚动条*/
::-webkit-scrollbar {
  width: 5px;
}
/*滚动条里面的滑块*/
::-webkit-scrollbar-thumb {
  box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.5);
}
</style>
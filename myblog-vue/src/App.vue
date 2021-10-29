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
}

::-webkit-scrollbar {
  width: 5px;
}

/* 滚动条轨道 */
::-webkit-scrollbar-track {
  width: 6px;
  background: rgba(16, 31, 28, 0.1);
  padding-top: 10px;
}

/*滚动条里面的小方块*/
::-webkit-scrollbar-thumb {
  width: 10px;
  border-radius: 10px;
  /* 还可以给它加个阴影 */
  box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.5);
}
</style>
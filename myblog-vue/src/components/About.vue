<template>
  <h1>关于我</h1>
  <button @click="toIndex">点击转跳index页面</button>
</template>

<script>
export default {
  name: 'About',
  components: {},
  methods: {
    toIndex() {
      this.$router.push({
        name: 'AppIndex',
      })
    },
  }
}
</script>
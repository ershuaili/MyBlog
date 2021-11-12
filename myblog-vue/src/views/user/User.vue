<template>
  <!--背景-->
  <div class="background"></div>
  <!--全局头部导航栏-->
  <nav-menu/>
  <!-- 主体部分 -->
  <div class="main">
    <router-view/>
  </div>
</template>

<script>
import NavMenu from "@/components/user/UserNavMenu";

export default {
  name: "User",
  components: {NavMenu}
}
</script>

<style scoped>
.background {
  background: url("../../assets/background.jpg");
  width: 100%;
  height: 100%;
  background-size: 100% 100%;
  position: fixed;
  z-index: -1024;
}
.main {
  padding-top: 1px;
}
</style>
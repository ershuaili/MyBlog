<template>
  <div>
    <!--全局头部导航栏-->
    <nav-menu/>
    <!-- 主体部分 -->
    <div class="main">
      <div class="background"></div>
      <router-view/>
    </div>
  </div>
</template>

<script>
import NavMenu from "@/components/common/NavMenu";

export default {
  name: 'Home',
  components: {NavMenu}
}
</script>

<style>
body {
  margin-top: 50px;
}

.background {
  background: url("../assets/background.jpg");
  width: 100%;
  /*/ / 大小设置为100 % */
  height: 100%;
  /*/ / 大小设置为100 % */
  position: fixed;
  background-size: 100% 100%;
  z-index: -1024;
}
</style>

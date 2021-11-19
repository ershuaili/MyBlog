<template>
  <!-- 整体导航栏 -->
  <admin-nav-menu/>
  <!-- 主体部分 -->
  <div class="main">
    <div class="background"></div>
    <div class="card">
      <router-view/>
    </div>
  </div>
</template>

<script>
import AdminNavMenu from "@/components/admin/AdminNavMenu";
import axios from "axios";
import router from "@/router";

export default {
  name: "Admin",
  components: {AdminNavMenu},
  // 管理员登录前校验
  beforeRouteEnter: (to, from, next) => {
    let isAdmin = false;
    let params = new URLSearchParams();
    params.append("token", localStorage.getItem("token"))
    axios.post('/user/checkToken', params)
        .then(successResponse => {
          if (successResponse.data.userRights === "ADMIN") {
            isAdmin = true;
            next();
          }else {
            router.push({
              name: 'Login',
              params: {message: '没有权限请登录'}
            });
          }
        }).catch(function (error) {
      console.log(error);
      router.push({
        name: 'Login',
        params: {message: '没有权限请登录'}
      });
    });
  },
  methods: {},
}
</script>

<style scoped>
/*!* 页面主体部分 *!*/
.main {
  margin-left: 260px;
  margin-top: 50px;
}

.background {
  position: fixed;
  width: 90%;
  height: 100%;
  background-color: rgba(240, 242, 245);
}

.card {
  position: relative;
  top: 20px;
  width: 95%;
  margin: 0 auto;
  background: rgba(255, 255, 255);
}
</style>
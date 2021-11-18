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
import store from "../../store/index";

export default {
  name: "Admin",
  components: {AdminNavMenu},
  methods: {},
  created(){
    let params = new URLSearchParams();
    params.append("token", localStorage.getItem("token"))
    axios.post('/checkToken', params)
        .then(successResponse => {
          if (successResponse.data.userRights === "ADMIN") {
            store.state.isAdmin = true;
            console.log(store.state.isAdmin)
          }
          console.log(successResponse)
        }).catch(function (error) {
      console.log(error);
    });
  }
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
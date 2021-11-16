<template>
  <div id="poster">
    <form class="login-container">
      <h3 class="login_title">系统登录</h3>
      <h5>{{$route.params.message}}</h5>
      <input v-model="loginForm.username" placeholder="账号" type="text"/>
      <input v-model="loginForm.password" placeholder="密码" type="password"/>
      <!--<checkbox label="记住我"></checkbox>-->
      <button type="button" v-on:click="login">登录</button>
      <!--<router-link to="home">忘了密码</router-link>-->
      <router-link style="float: right" to="/register">注册</router-link>
    </form>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: 'login',
  data() {
    return {
      loginForm: {
        username: '',
        password: ''
      },
      responseResult: []
    }
  },
  methods: {
    login() {
      let params = new URLSearchParams();
      params.append("username", this.loginForm.username)
      params.append("password", this.loginForm.password)
      // 从后端获取数据
      axios.post('/login', params)
          .then(successResponse => {
            console.log(successResponse)
            if (successResponse.data.code === 200) {
              const path = this.$route.query.redirect;
              this.$router.replace({path: path === '/' || path === undefined ? '/index' : path})
            } else {
              alert("用户名或密码错误");
            }
          }).catch(function (error) {
        console.log(error);
      });
    }
  }
}
</script>

<style scoped>
/*整体背景*/
#poster {
  background: url("../../assets/login-background.jpg") no-repeat center;
  height: 100%;
  width: 100%;
  background-size: cover;
  position: fixed;
}

/*登录背景框*/
.login-container {
  border-radius: 15px;
  background-clip: padding-box;
  margin: 90px auto;
  width: 350px;
  padding: 35px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}

.login_title {
  margin: 0 auto 40px auto;
  text-align: center;
  color: #505458;
}
</style>
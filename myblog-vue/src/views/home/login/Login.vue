<template>
  <body id="poster">
  <el-form class="login-container" label-position="left" label-width="0px">
    <h3 class="login_title">系统登录</h3>
    <el-form-item>
      <el-input v-model="loginForm.username" auto-complete="off" placeholder="账号" type="text"></el-input>
    </el-form-item>
    <el-form-item>
      <el-input v-model="loginForm.password" auto-complete="off" placeholder="密码" type="password"></el-input>
    </el-form-item>
    <el-checkbox label="记住我"></el-checkbox>
    <el-form-item>
      <el-button type="primary" v-on:click="login">登录</el-button>
    </el-form-item>
    <router-link to="to/home">忘了密码</router-link>
    <router-link style="float: right" to="to/register">注册</router-link>
  </el-form>
  </body>
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
      params.append("name", this.loginForm.username)
      params.append("password", this.loginForm.password)
      // 从后端获取数据
      axios.post('/b', params)
          .then(successResponse => {
            if (successResponse.data === 200) {
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
  margin-top: -50px;
  background: url("../../../assets/login-background.jpg") no-repeat center;
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

.el-button {
  width: 100%;
  background: #505458;
  border: none;
}

.login_title {
  margin: 0 auto 40px auto;
  text-align: center;
  color: #505458;
}
</style>
<template>
  <div id="poster">
    <form class="login_container">
      <h3 class="login_title">系统登录</h3>
      <div class="login_msg">{{ $route.params.message }}</div>
      <div class="login_input">
        <input class="userName" v-model="loginForm.username" placeholder="账号" type="text"/>
        <input class="password" v-model="loginForm.password" placeholder="密码" type="password" autoComplete="on"/>
      </div>
      <div class="login_button">
        <button type="button" @click="login">登录</button>
        <button type="button" @click="toRegister" style="float: right">注册</button>
      </div>
    </form>
  </div>
</template>

<script>
import axios from "axios";
import router from "@/router";

export default {
  name: 'Login',
  data() {
    return {
      loginForm: {
        username: '',
        password: ''
      },
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
            if (successResponse.data.code === 200) {
              // 向本地存储中加入token
              localStorage.clear()
              localStorage.setItem('token', successResponse.data.token)
              console.log(successResponse.data.role)
              // 判断是用户还是管理员
              if (successResponse.data.role === "ADMIN") {
                this.$router.push("/admin")
              }else {
                const path = this.$route.query.redirect;
                this.$router.replace({path: path === '/' || path === undefined ? '/index' : path})
              }
            } else if (successResponse.data.code === 401) {
              alert("用户名或密码错误");
            }
          }).catch(function (error) {
        alert("用户名或密码错误");
        console.log(error);
      });
    },
    toRegister() {
      router.push({
        path: "/register"
      })
    },
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
.login_container {
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
  margin: 0 auto 30px auto;
  text-align: center;
  color: #505458;
}

/*登录错误提示信息*/
.login_msg {
  text-align: center;
  color: crimson;
}

.login_input {
  position: relative;
  margin: 0 auto;
  width: 100%;
}

.login_input input {
  margin-top: 30px;
  width: 100%;
  height: 30px;
  border: 1px solid #ccc;
  border-radius: 10px;
  padding: 7px 0 7px 5px;
  font-size: 15px;
  -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
  box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
  -webkit-transition: border-color ease-in-out .15s, -webkit-box-shadow ease-in-out .15s;
  -o-transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
  transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s
}

.login_input input:focus {
  border-color: #66afe9;
  outline: 0;
  -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px rgba(102, 175, 233, .6);
  box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px rgba(102, 175, 233, .6)
}

.login_button {
  padding: 20px;
}
.login_button button {
  width: 70px;
  height: 30px;
  border-radius: 10px;
  background-color: #66afe9;
}
</style>l
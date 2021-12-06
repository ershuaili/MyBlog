<template>
  <body id="poster">
  <form class="register_container">
    <h3 class="register_title">欢迎注册</h3>
    <div class="register_msg">{{ msg }}</div>
    <div class="register_input">
      <input v-model="registerForm.username" placeholder="账号" type="text">
      <input v-model="registerForm.email" placeholder="邮箱" type="text">
      <input v-model="registerForm.password" placeholder="密码" type="password" autoComplete="on">
    </div>
    <div class="register_button">
      <button type="button" @click="register">注册</button>
      <button type="button" @click="toLogin" style="float: right">返回登录</button>
    </div>
  </form>
  </body>
</template>

<script>
import axios from "axios";
import router from "@/router";

export default {
  name: 'Register',
  data() {
    return {
      registerForm: {
        username: '',
        email: '',
        password: '',
      },
      msg: '',
    }
  },
  methods: {
    // 用户注册表单提交
    register() {
      let params = new URLSearchParams();
      params.append("userNickname", this.registerForm.username)
      params.append("userEmail", this.registerForm.password)
      params.append("userPassword", this.registerForm.password)
      // 从后端获取数据
      axios.post('/user/insert', params)
          .then(successResponse => {
            if (successResponse.data === true) {
              this.$router.replace({path: '/message'})
            } else {
              alert("注册失败");
            }
          }).catch(function (error) {
        console.log(error);
      });
    },

    // 转跳登录页
    toLogin() {
      router.push({name: 'Login'})
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
.register_container {
  border-radius: 15px;
  background-clip: padding-box;
  margin: 90px auto;
  width: 350px;
  padding: 35px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}

.register_title {
  margin: 0 auto 30px auto;
  text-align: center;
  color: #505458;
}

/*登录错误提示信息*/
.register_msg {
  text-align: center;
  color: crimson;
}

.register_input {
  position: relative;
  margin: 0 auto;
  width: 100%;
}

.register_input input {
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

.register_input input:focus {
  border-color: #66afe9;
  outline: 0;
  -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px rgba(102, 175, 233, .6);
  box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px rgba(102, 175, 233, .6)
}

.register_button {
  padding: 20px;
}

.register_button button {
  width: 70px;
  height: 30px;
  border-radius: 10px;
  background-color: #66afe9;
}
</style>
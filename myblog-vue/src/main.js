import {createApp} from 'vue'
import App from './App.vue'
import store from './store'
import router from './router'
// 引入axios
import axios from 'axios'
// 让ajax携带cookie
// axios.defaults.withCredentials=true;

// 设置反向代理，前端请求默认发送到 http://localhost:8899
// axios.defaults.baseURL = 'http://47.96.145.7:8083'
axios.defaults.baseURL = 'http://localhost:8899'

createApp(App).use(router).use(store).mount('#app')
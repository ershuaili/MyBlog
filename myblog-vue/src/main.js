import {createApp} from 'vue'
import App from './App.vue'
import store from './store'
import router from './router'
// 引入elementUI
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
// 引入axios
import axios from 'axios'
// 设置反向代理，前端请求默认发送到 http://localhost:8899
axios.defaults.baseURL = 'http://192.168.43.251:8899'

createApp(App).use(router).use(store).use(ElementPlus).mount('#app')
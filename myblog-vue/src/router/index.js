import {createRouter, createWebHistory} from 'vue-router'
import Home from '../views/Home.vue'
// 路由数组
const routes = [
    {
        path: '/',
        name: 'Default',
        redirect: 'home',
        component: Home,
    },
    // home组件作为全局的父组件
    {
        path: '/home',
        name: 'Home',
        component: Home,
        redirect: '/index',
        children: [
            {
                path: '/index',
                name: 'AppIndex',
                component: () => import('../views/home/AppIndex.vue'),
                meta: {title: '帅の博客'},
            },
            {
                path: '/type',
                name: 'Type',
                component: () => import('../views/home/Type.vue'),
                meta: {title: '博客分类'},
            },
            {
                path: '/message',
                name: 'Message',
                component: () => import('../views/home/Message.vue'),
                meta: {title: '留言板'},
            },
            {
                path: '/picture',
                name: 'Picture',
                component: () => import('../views/home/Picture.vue'),
                meta: {title: '照片墙'},
            },
            {
                path: '/about',
                name: 'About',
                component: () => import('../views/home/About.vue'),
                meta: {title: '关于我'},
            },
            {
                path: '/blog',
                name: 'Blog',
                component: () => import('../views/home/blog/Blog.vue'),
                meta: {title: '博客详情'},
                props($route) {
                    return {title: $route.params.title}
                }
            },
        ]

    },
    {
        // 登录界面
        path: '/login',
        name: 'Login',
        component: () => import('../views/home/login/Login.vue'),
        meta: {title: '用户登录'},
    },
    {
        // 注册界面
        path: '/register',
        name: 'Register',
        component: () => import('../views/home/login/Register.vue'),
        meta: {title: '用户注册'},
    },
];

// 创建一个路由
const router = createRouter({
    history: createWebHistory(),
    routes
})
// 更新页面标题
router.beforeEach((to, from, next) => {
    to.meta.title && (document.title = to.meta.title);
    next()
});

// 暴露这个路由
export default router

import {createRouter, createWebHistory} from 'vue-router'
import User from "@/views/user/User";
// 路由数组
const routes = [
    // user组件作为前台展示组件
    {
        path: '/',
        name: 'User',
        component: User,
        redirect: '/index',
        children: [
            // 博客首页
            {
                path: '/index',
                name: 'AppIndex',
                component: () => import('../views/user/AppIndex.vue'),
                meta: {title: '帅の博客'},
            },
            {
                path: '/type',
                name: 'Type',
                component: () => import('../views/user/Type.vue'),
                meta: {title: '博客分类'},
            },
            {
                path: '/message',
                name: 'Message',
                component: () => import('../views/user/Message.vue'),
                meta: {title: '留言板'},
            },
            {
                path: '/picture',
                name: 'Picture',
                component: () => import('../views/user/Picture.vue'),
                meta: {title: '照片墙'},
            },
            {
                path: '/about',
                name: 'About',
                component: () => import('../views/user/About.vue'),
                meta: {title: '关于我'},
            },
            {
                path: '/blog',
                name: 'Blog',
                component: () => import('../views/user/blog/Blog.vue'),
                meta: {title: '博客详情'},
                props($route) {
                    return {title: $route.params.title}
                }
            },
        ]
    },
    // admin组件作为后台管理组件
    {
        path: '/admin',
        name: 'Admin',
        component: () => import('../views/admin/Admin.vue'),
        redirect: '/admin/users',
        children: [
            // 博客管理
            {
                path: '/admin/blog',
                name: 'BlogManage',
                component: () => import('../views/admin/blog/WriteBlog.vue'),
                meta: {title: '博客管理'},
            },
            // 分类管理
            {
                path: '/admin/types',
                name: 'TypesManage',
                component: () => import('../views/admin/type/Types.vue'),
                meta: {title: '分类管理'},
            },
            // 留言管理
            {
                path: '/admin/message',
                name: 'MessageManage',
                component: () => import('../views/admin/Comments.vue'),
                meta: {title: '评论管理'},
            },
            // 相册管理
            {
                path: '/admin/picture',
                name: 'PictureManage',
                component: () => import('../views/admin/Picture.vue'),
                meta: {title: '相册管理'},
            },
            // 用户管理
            {
                path: '/admin/users',
                name: 'UsersManage',
                component: () => import('../views/admin/Users.vue'),
                meta: {title: '用户管理'},
            },
        ]
    },
    // check组件作为登录注册界面
    {
        path: '/check',
        name: 'Check',
        component: () => import('../views/login/Check'),
        redirect: '/login',
        children: [
            {
                // 登录界面
                path: '/login',
                name: 'Login',
                component: () => import('../views/login/Login.vue'),
                meta: {title: '用户登录'},
            },
            {
                // 注册界面
                path: '/register',
                name: 'Register',
                component: () => import('../views/login/Register.vue'),
                meta: {title: '用户注册'},
            },
        ]
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

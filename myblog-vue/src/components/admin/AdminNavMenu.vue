<template>
  <div class="nav">
    <!-- 导航栏-头部 -->
    <div class="nav_head">
      <div class="head_left">
        <img src="../../assets/logo.png" alt="">
        <h1>帅のBlog</h1>
      </div>
      <div class="head_right">
        <div v-if="showMenu" class="head_right">
          <router-link v-for="(item,index) in blogManage" :key="index" :to="item.name" active-class="blogs_menu_active"
                       class="blogs_menu">
            <h1>{{ item.navItem }}</h1>
          </router-link>
        </div>
      </div>
    </div>
    <!-- 导航栏-左侧 -->
    <div class="nav_left">
      <router-link v-for="(item,index) in navList" :key="index" :to="item.name" active-class="nav-menu-active" class="nav_menu">
        <img :src="require('../../assets/svg/'+item.svg)" alt="">
        <h1>{{ item.navItem }}</h1>
      </router-link>
    </div>
  </div>
</template>

<script>
export default {
  name: "AdminNavMenu",
  data() {
    return {
      navList: [
        {name: '/admin/blog', navItem: '博客管理', svg: 'home.svg'},
        {name: '/admin/types', navItem: '分类管理', svg: 'type.svg'},
        {name: '/admin/message', navItem: '留言管理', svg: 'messages.svg'},
        {name: '/admin/picture', navItem: '相册管理', svg: 'photo.svg'},
        {name: '/admin/users', navItem: '用户管理', svg: 'user.svg'}
      ],
      // 博客管理
      blogManage: [
        {name: '/admin/blog/blogs', navItem: '博客管理'},
        {name: '/admin/blog/write', navItem: '写博客'},
      ],
      // 导航栏展示
      showMenu: '',
    }
  },
  watch:{
    '$route': 'showHeadMenu',
  },
  // 监听页面刷新
  mounted(){
    if(window.name === ""){
      this.showHeadMenu();
      window.name = "isRefresh";
    }else if(window.name === "isRefresh"){
      this.showHeadMenu();
    }
  },
  methods: {
    showHeadMenu() {
      this.showMenu = this.$route.path.slice(7, 11) === 'blog';
    }
  },
}
</script>

<style scoped>
/*!* 页面导航栏 *!*/
.nav {
  z-index: 1024;
}

/* 导航栏头部 */
.nav_head {
  width: 100%;
  height: 50px;
  z-index: 10;
  position: fixed;
  display: flex;
  top: 0;
}
/* 导航栏头部左侧 */
.head_left {
  width: 260px;
  background: rgba(60, 141, 188);
}
.head_left img {
  display: inline-block;
  float: left;
  padding-top: 10px;
  padding-left: 20px;
  width: 30px;
  margin: 0 auto;
}
.head_left h1 {
  display: inline-block;
  float: left;
  font-size: 20px;
  padding-left: 10px;
}

/* 导航栏头部右侧 */
.head_right {
  background: rgba(255, 255, 255);
  flex-grow: 1;
  box-shadow: 0 0 1px #000000;
  display: flex;
}

.head_right h1 {
  display: inline-block;
  float: left;
  font-size: 20px;
  padding-left: 10px;
}

.blogs_menu {
  height: 50px;
  margin-left: 10px;
  overflow: hidden;
  display: block;
  color: #ffaaff;
}

/* 导航栏左侧 */
.nav_left {
  float: left;
  position: fixed;
  width: 260px;
  height: 100%;
  top: 0;
  margin-top: 50px;
  background: rgba(84, 92, 100);
}
.nav_menu {
  height: 50px;
  margin-top: 10px;
  overflow: hidden;
  display : block;
  color: rgba(255, 255, 255, 0.6);
}
.nav-menu-active{
  height: 50px;
  margin-top: 10px;
  overflow: hidden;
  display : block;
  background-color: #326705;
}
.nav_menu img {
  display: inline-block;
  float: left;
  padding-top: 15px;
  padding-left: 10px;
  width: 20px;
}
.nav_menu h1 {
  display: inline-block;
  float: left;
  font-size: 20px;
  padding-left: 10px;
}
</style>
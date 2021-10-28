<template>
  <div>
    <div id="reading-progress-bar" style="width:0"></div>
    <div class="nav-bar">
      <router-link v-for="(item,index) in navList" :key="index" :to="item.name" active-class="nav-menu-active"
                   class="nav-menu">
        {{ item.navItem }}
      </router-link>
    </div>
  </div>
</template>
<script>
export default {
  name: 'NavMenu',
  data() {
    return {
      navList: [
        {name: '/index', navItem: '首页'},
        {name: '/type', navItem: '分类'},
        {name: '/message', navItem: '留言板'},
        {name: '/picture', navItem: '照片墙'},
        {name: '/about', navItem: '关于我'}
      ],
    }
  },
  // 组件创建完成
  created() {
    //监听鼠标滚动事件
    window.addEventListener('mousewheel', this.handleScroll, false);
  },
  methods: {
    // 鼠标滚动事件
    handleScroll() {
      // 页面滚动距顶部距离
      const scrollTop = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop;
      // 网页全文高度 - 网页可见区域高度
      let c = scrollTop / (document.body.scrollHeight - document.documentElement.clientHeight) * 100
      c += "%";
      document.getElementById("reading-progress-bar").style.width = String(c);
    }
  },
}
</script>

<style scoped>
/* 进度条 */
#reading-progress-bar {
  position: fixed;
  top: 0;
  background: #ef4e7b;
  height: 2px;
  z-index: 1024;
}

/* 导航栏 */
.nav-bar {
  position: fixed;
  top: 0;
  height: 50px;
  width: 100%;
  background: rgba(0, 0, 0, 0.8);
  text-align: center;
}

/* 导航栏按钮 */
.nav-menu {
  text-decoration: none;
  color: rgba(255, 255, 255, 0.6);
  padding: 5px 20px;
  line-height: 50px;
}

.nav-menu-active {
  text-decoration: none;
  background-color: rgba(255, 255, 255, 0.2);
  border-radius: 25px;
  color: #ffffff;
  line-height: 50px;
  padding: 5px 20px;
  margin: 20px;
}

</style>

<template>
  <template>
    <div class="navMenu">
      <div class="navArea">
        <div class="logo">
          <div class="menuIcon">
            <i class=" iconfont icon-daohang" @click="sideMenu"></i>
          </div>
          <div v-show="logopPic" class="logoImg">
            <img :src="logo" alt="">
          </div>
        </div>
        <ul v-if="listShow" class="menuList">
          <li v-for="(menu,id) in menuData" :key="id" :class="{fisrtMenu:menu.bigshowclass}" class="first"
              @click="menuShow(menu,id)">
            <i :class="menu.icon"></i>{{ menu.title }}
            <transition name="pc_fade">
              <ul v-show="menu.isSubShow" class="menuChild">
                <li v-for="(child,index) in menu.childs" :key="index" :class="{secondMenu:child.showclass}"
                    class="second" @click="pushpath(child,menu,index)">
                  <i :class="child.icon"></i>{{ child.title }}
                </li>
              </ul>
            </transition>
          </li>
        </ul>
        <transition v-else name="mobileMenu">
          <ul v-show="sideList" class="mobile">
            <li v-for="(menu,id) in menuData" :key="id" :class="{fisrtMenu:menu.bigshowclass}" class="first"
                @click="menuShow(menu,id)">
              <i :class="menu.icon"></i>{{ menu.title }}
              <transition name="mobile_fade">
                <ul v-show="menu.isSubShow" class="mobileChild">
                  <li v-for="(child,index) in menu.childs" :key="index" :class="{secondMenu:child.showclass}"
                      class="second" @click="pushpath(child,menu,index)">
                    <i :class="child.icon"></i>{{ child.title }}
                  </li>
                </ul>
              </transition>
            </li>
            <div class="weChat">
              <p>欢迎关注微信公众号：</p>
              <img :src="weiImg" alt="weixin">
            </div>
          </ul>
        </transition>
        <div :class="{inputStyle:searchInput}" class="search">
          <input v-show="searchInput" v-model="keyWord" placeholder="请输入关键字进行搜索" type="text">
          <i class="iconfont icon-search" @click="search"></i>
        </div>
      </div>
    </div>
  </template>
</template>

<script>
export default {
  name: "Test",
  mounted() {
    window.addEventListener('resize', this.Switching)
  },
  methods: {
    Switching() {
      let that = this
      let w = document.documentElement.clientWidth || document.body.clientWidth
      if (w >= 769) {
        that.listShow = true; //显示pc菜单
      }
      if (w < 769) {
        that.listShow = false;  //显示mobile菜单
      }
      if (w < 450) {
        that.searchInput = false  //隐藏input框
        that.logopPic = true  //显示logo
        that.sideList = false //隐藏侧边栏
      } else {
        that.sideList = true  //显示侧边栏
      }
      that.searchInput = w > 1000;
    },
  }
}
</script>

<style scoped>
.mobileMenu-enter-active {
  transition: all .8s ease;
}

.mobileMenu-leave-active {
  transition: all .5s cubic-bezier(1.0, 0.5, 0.8, 1.0);
}

.mobileMenu-enter, .mobileMenu-leave-to {
  transform: translateX(-20px);
  opacity: 0;
}

.mobile_fade-enter-active {
  transition: all 1s ease;
}

.mobile_fade-leave-active {
  transition: all 0s cubic-bezier(1.0, 0.5, 0.8, 1.0);
}

.mobile_fade-enter, .mobile_fade-leave-to {
  opacity: 0;
}

@media screen and (min-width: 769px) {
  .logo .menuIcon i {
    display: none;
  }
}

@media screen and (max-width: 769px) {
  .logo {
    flex: 1;
  }
}

@media screen and (max-width: 850px) {
  .menuList .first {
    padding: 0 5px;
  }
}

@media screen and (max-width: 1200px) {
  .menuList .first i {
    display: none;
  }
}
</style>
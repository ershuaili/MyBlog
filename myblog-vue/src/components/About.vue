<template>
  <div class="main">
    <!--左侧图片-->
    <div class="picture">
      <div class="img">
        <img alt="" src="../assets/background.jpg">
      </div>
    </div>
    <!--右侧简介-->
    <div class="comment">
      <div class="details">
        <!--头部标签-->
        <div class="head" style="text-align: center;">
          <h1>关于我</h1>
        </div>
        <hr/>
        <!--文字描述-->
        <div class="introduce">
          <p>一些测试文字发放大 发仨发发呆sa法法师防守打法发发发电房a</p>
          <br/>
          <p>一些测试文字发放大 发仨发发呆sa法法师防守打法发发发电房a</p>
        </div>
        <hr/>
        <!--个人标签-->
        <div class="label_personal">
          <div class="tag tag_left">标签1</div>
          <div class="tag tag_left">标签2</div>
          <div class="tag tag_left">标签3</div>
        </div>
        <hr/>
        <!--技术标签-->
        <div class="label_technology">
          <div class="tag tag_right">标签1</div>
          <div class="tag tag_right">标签2</div>
          <div class="tag tag_right">向右标签3</div>
          <div class="tag tag_right">向右标签4再来一个</div>
        </div>
        <hr/>
        <!--链接-->
        <div class="link">
          <a href="https://github.com/ershuaili" target="_blank">
            <img alt="" src="../assets/svg/github.svg">
          </a>
          <a href="http://data.shuaiblog.xyz/wechat.png" target="_blank">
            <img alt="" src="../assets/svg/wechat.svg">
          </a>
          <a href="http://data.shuaiblog.xyz/qq.png" target="_blank">
            <img alt="" src="../assets/svg/qq.svg">
          </a>
          <a href="" target="_blank">
            <img alt="" src="../assets/svg/email.svg">
          </a>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'About',
  components: {},
  methods: {},
}
</script>

<style>
.picture {
  width: 70%;
  height: 100%;
  display: inline-block;
  float: left;
}

.img {
  background-color: #FFFFFF;
  width: 960px;
  height: 550px;
  padding: 20px;
  margin: 10px 30px 30px;
  border-radius: 15px;
}

.img > img {
  height: 100%;
  width: 100%;
  background-size: 100%;
  background-position: top left;
  border-radius: 10px;
}

.comment {
  width: 30%;
  float: left;
  display: inline-block;
}

.details {
  background-color: #FFFFFF;
  margin: 10PX;
  padding: 10px;
  height: 630px;
  width: auto;
  border-radius: 15px;
  position: relative;
}

/* 空心气泡标签 */
.tag {
  width: auto;
  height: 35px;
  line-height: 35px;
  text-align: center;
  position: relative;
  border-radius: 9px;
  border: 2px solid teal;
  display: inline-block;
  padding-left: 20px;
  padding-right: 20px;
  margin: 20px auto 20px 20px;
}

/* 箭头向左 */
.tag_left::before,
.tag_left::after {
  content: '';
  position: absolute;
  width: 0;
  height: 0;
  top: 7px;
  left: -16px;
  border-top: 10px solid transparent;
  border-bottom: 10px solid transparent;
  border-right: 15px solid teal;
}

.tag_left::after {
  left: -13px;
  border-right: 15px solid #fff;
}

/* 箭头向右 */
.tag_right::before,
.tag_right::after {
  content: '';
  position: absolute;
  width: 0;
  height: 0;
  top: 8px;
  right: -16px;
  border-top: 10px solid transparent;
  border-bottom: 10px solid transparent;
  border-left: 15px solid teal;
}

.tag_right::after {
  right: -13px;
  border-left: 15px solid #fff;
}


/*****链接*****/
.link {
  position: absolute;
  height: 50px;
  bottom: 10px;
  left: 95px;
}

.link > a > img {
  width: 20px;
  padding: 10px;
  margin: 10px;
  background: rgba(10, 10, 10, 0.5);
  border-radius: 30px;
  position: relative;
}

/***** 移动端配适 *****/
@media screen and (max-width: 768px) {
  .picture {
    width: 100%;
    height: 100vh;
    background-color: #FFE4C4;
    display: inline-block;
    float: left;
  }

  .comment {
    width: 100%;
    height: 100vh;
    background-color: #ffaaff;
    display: inline-block;
    float: left;
  }
}
</style>
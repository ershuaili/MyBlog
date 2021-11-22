<template>
  <div class="UserBottom">
    <div class="BlogInformation">
      文章总数：<span class="KeyFont">{{ this.BlogCount }}</span> 篇&nbsp;&nbsp;
      访问总数：<span class="KeyFont">{{ this.ViewsCount }}</span> 次&nbsp;&nbsp;
      留言总数：<span class="KeyFont">{{ this.MessageCount }}</span> 条&nbsp;&nbsp;
    </div>
    <div class="OperationHours">
      本站已运行：<span class="KeyFont" id="siteTime">{{ this.RunTime }}</span>
    </div>
    <div class="RecordNumber">
      <a href="https://www.beian.miit.gov.cn" rel="nofollow" target="_blank">豫ICP备2021017213号</a>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "UserBottom",
  data() {
    return {
      BlogCount: '',
      ViewsCount: '',
      MessageCount: '',
      RunTime: '',
    }
  },
  created() {
    axios.get("/blog/queryCommonMessage").then(res => {
      this.BlogCount = res.data.BlogCount;
      this.ViewsCount = res.data.ViewsCount;
    });
    axios.get('/message/queryAllNumber').then(res => {
      this.MessageCount = res.data
      this.$store.state.paginate.messages = res.data
      this.$store.state.paginate.pageNum = Math.ceil((res.data) / 10)
    }).catch(function (error) {
      console.log(error);
    });
    this.timer = setInterval(this.ShowRunTime, 1000);
  },
  methods: {
    ShowRunTime() {
      const BootDate = new Date("2021/11/22 00:00:00");
      const NowDate = new Date();
      const RunDateM = parseInt(NowDate - BootDate);
      const RunYear = Math.floor(RunDateM / (365 * 24 * 3600 * 1000));
      const RunDays = Math.floor(RunDateM / (24 * 3600 * 1000) % 365);
      const RunHours = Math.floor(RunDateM % (24 * 3600 * 1000) / (3600 * 1000));
      const RunMinutes = Math.floor(RunDateM % (24 * 3600 * 1000) % (3600 * 1000) / (60 * 1000));
      const RunSeconds = Math.round(RunDateM % (24 * 3600 * 1000) % (3600 * 1000) % (60 * 1000) / 1000);
      this.RunTime = RunYear + "年 " + RunDays + "天 " + RunHours + "时 " + RunMinutes + "分 " + RunSeconds + "秒";
    },
  },
}
</script>

<style scoped>
.UserBottom {
  width: 100%;
  height: auto;
  color: rgb(127, 127, 127);
  background-color: rgba(0, 0, 0, 0.8);
  text-align: center;
  margin-top: 50px;
  padding: 10px 0;
}

.KeyFont {
  color: rgb(255, 255, 255);
}

.RecordNumber a {
  color: rgb(127, 127, 127);
  text-decoration: none;
}
</style>
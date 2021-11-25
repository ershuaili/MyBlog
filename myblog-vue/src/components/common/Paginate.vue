<template>
  <div class="paginate">
    <ul class="pagination">
      <li @click="pageReduce"><a>«</a></li>
      <li v-for="index of this.$store.state.paginate.pageNum" :key="index">
        <a @click="pageJump" v-bind:class="{'active':index===this.$store.state.paginate.pageShow}">{{ index }}</a>
      </li>
      <li @click="pageAdd"><a>»</a></li>
    </ul>
  </div>
</template>

<script>
export default {
  name: "Paginate",
  methods: {
    // 分页转跳
    pageReduce() {
      this.$store.dispatch('pageReduce', this.$store.state.paginate.pageShow)
    },
    pageAdd() {
      this.$store.dispatch('pageAdd', {
        pageShow: this.$store.state.paginate.pageShow,
        pageNum: this.$store.state.paginate.pageNum
      })
    },
    pageJump() {
      this.$store.dispatch('pageJump', Number(event.target.innerText))
    },
  },
}
</script>

<style scoped>
.paginate {
  margin-top: 30px;
  text-align: center;
}

.pagination {
  padding: 0;
  margin: 0;
  display: inline-block;
}

.pagination li {
  display: inline;
}

.pagination li a {
  color: black;
  float: left;
  padding: 8px 16px;
  text-decoration: none;
  transition: background-color .3s;
  border: 1px solid #ddd;
}

.pagination li:first-child a {
  border-top-left-radius: 5px;
  border-bottom-left-radius: 5px;
}

.pagination li:last-child a {
  border-top-right-radius: 5px;
  border-bottom-right-radius: 5px;
}

.pagination li a.active {
  background-color: #4CAF50;
  color: white;
  border: 1px solid #4CAF50;
}
</style>
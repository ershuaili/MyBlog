<template>
  <div class="paginate">
    <ul class="pagination">
      <li @click="pageReduce"><a>«</a></li>
      <li v-for="index of this.pageNum" :key="index">
        <a @click="pageJump" v-bind:class="{'active':index===this.$store.state.paginate.pageShow}">{{ index }}</a>
      </li>
      <li @click="pageAdd"><a>»</a></li>
    </ul>
  </div>
</template>

<script>
export default {
  name: "Paginate",
  data() {
    return {
      pageNum: this.$store.state.paginate.pageNum
    }
  },

  methods: {
    pageReduce() {
      if (this.$store.state.paginate.pageShow <= 1) {
        alert("前面没有了")
      } else {
        this.$store.state.paginate.pageShow--
      }
    },
    pageAdd() {
      if (this.$store.state.paginate.pageShow >= this.$store.state.paginate.pageNum) {
        alert("后面没有了")
      } else {
        this.$store.state.paginate.pageShow++
      }
    },
    pageJump() {
      this.$store.state.paginate.pageShow = Number(event.target.innerText)
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
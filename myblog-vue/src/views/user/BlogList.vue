<template>
  <BlogLabel ref="child"/>
  <Paginate/>
  <UserBottom/>
</template>

<script>
import UserBottom from "@/components/user/UserBottom";
import Paginate from "@/components/common/Paginate";
import BlogLabel from "@/components/user/BlogLabel";

export default {
  name: "BlogList",
  components: {BlogLabel, Paginate, UserBottom},
  created() {
    setTimeout(() => {
      this.$refs.child.getBlogList();
    })
  },

}
</script>
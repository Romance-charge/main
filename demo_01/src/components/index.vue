<template>
  <div>
    <el-container style="height: 100%; border: 1px solid #eee">
      <el-aside width="200px" style="background-color: rgb(238, 241, 246);height: 100%">
        <Aside></Aside>
      </el-aside>

      <el-container style="height: 100%">
        <el-header style="text-align: right; font-size: 12px;height: 100%">
          <Header></Header>
        </el-header>

        <el-main style="height: 100%">
          <Main></Main>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import Aside from "./Aside.vue";
import Header from "./Header.vue";
import Main from "./Main.vue";

export default {
  name: "index",
  components: {Main, Header, Aside},

}
</script>

<style scoped>
.el-header {
  background-color: #B3C0D1;
  color: #333;
  line-height: 60px;
}
.el-main{
  padding: 5px;
}
.el-aside {
  color: #333;
}
</style>

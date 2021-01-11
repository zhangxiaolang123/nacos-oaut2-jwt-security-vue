<template>
  <div id="ddd">
    <!-- <router-view/> -->
    <div style="text-align: right; margin-right: 10px;">
        <el-button @click="logout()" type="text" size="small">登出系统</el-button>
    </div>
    <el-container style="height: 980px; border: 1px solid #eee">
          <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
            <el-menu router>
              <el-submenu v-for="(item,index) in $router.options.routes" :index="index+''" v-if="item.show">
                <template slot="title"><i class="el-icon-setting"></i>{{item.name}}</template>  
                <el-menu-item v-for="(item2,index2) in item.children" :index="item2.path" :class="$route.path==item2.path?'is-active':''" v-if="item2.show">
                  {{item2.name}}
                </el-menu-item>
              </el-submenu>
            </el-menu>
          </el-aside>
          <el-container>
             <!-- <el-header style="text-align: right; font-size: 12px">
              <el-button @click="edit(scope.row)" type="text" size="small">登出系统</el-button>
             </el-header> -->
            <el-main>
              <router-view/>
            </el-main>
          </el-container>
      </el-container>
  </div>
</template>

<style>
  .el-header {
    background-color: #f1b7e7;
    color: #333;
    line-height: 60px;
  }
  
 
  #ddd {
    background:url("../assets/eva.jpg") no-repeat;
    background-position: center;
    height: 100%;
    width: 100%;
    background-size: cover;
    position: fixed;
  }
  body{
    margin: 0px;
    padding: 0;
  }
 
  .login-container {
    border-radius: 15px;
    background-clip: padding-box;
    margin: 90px auto;
    width: 350px;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
  }
 
  .login_title {
    margin: 0px auto 40px auto;
    text-align: center;
    color: #505458;
  }
 
 
</style>


<script>
import axios from "axios";
import { removeToken } from '@/util/auth.js';
  export default {
    methods: {

      logout(){
        const _this = this;
        axios.post('http://localhost:8001/api/out/logout').then(function(res){
                console.log(res);
                removeToken();
                _this.$store.commit('setToken', '');
                _this.$router.push("/login");
                // if(res.data == 'success'){
                //   _this.$message('成功');
                //  // _this.findAll();
                // }
            })
      }

    }

   
  };
</script>


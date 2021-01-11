<template>
  <body id="poster">
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" class="login-container" label-position="left" label-width="0px">
      <h3 class="login_title">系统登录</h3>

    <el-tabs v-model="activeName" @tab-click="handleClick">
      <el-tab-pane label="用户密码" name="first">
        <el-form-item>
        <el-input type="text" v-model="ruleForm.username" auto-complete="off" placeholder="账号"></el-input>
      </el-form-item>
      <el-form-item>
        <el-input type="password" v-model="ruleForm.password" auto-complete="off" placeholder="密码"></el-input>
      </el-form-item>
      <el-form-item style="width: 100%">
        <el-button type="primary" style="width: 100%;background: #505458;border: none" v-on:click="submit('ruleForm')">登录</el-button>
      </el-form-item>
      </el-tab-pane>
      <el-tab-pane label="手机短信" name="second">
        <el-form-item>
        <el-input type="text" v-model="ruleForm.phone" auto-complete="off" placeholder="手机号码"></el-input>
      </el-form-item>
      <el-form-item>
        <el-input type="text" v-model="ruleForm.smsCode" auto-complete="off" placeholder="验证码"></el-input>
      </el-form-item>
      <el-form-item style="width: 100%">
        <el-button type="primary" style="width: 100%;background: #505458;border: none" v-on:click="submitSms('ruleForm')">登录</el-button>
      </el-form-item>
      </el-tab-pane>
    
  </el-tabs>
      


    </el-form>
  </body>
</template>

<script>
import axios from 'axios';
import { setToken, getToken } from '@/util/auth.js';
  export default {
    data() {
      return {
        activeName: 'first',
        ruleForm: {
          username: '',
          password: '',
          phone: '',
          smsCode: ''
        },
        accessToken:"",
        // rules: {
        //   name1: [
        //     { required: true, message: '用户名', trigger: 'blur' }
            
        //   ],
        //   pass: [
        //     { required: true, message: '密码', trigger: 'blur' }
           
        //   ]
        // }
      };
    },
    methods: {
      submit(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            const _this = this;
        axios.post("http://localhost:8001/api/user_auth/login", this.ruleForm).then(response => {
            console.log(response.data)
            if (response.data.code === 200) {
              alert(response.data.data.accessToken);
              setToken(response.data.data.accessToken);
              this.$store.commit('setToken', response.data.data.accessToken);
             // _this.getUserInfo();
              _this.$router.push("/b");
            } else {
              this.$Message(response.data.message);
              
            }
          })
          .catch(() => {
            
          });
          } else {
            return false;
          }
        });
      },
      
      submitSms(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            const _this = this;
        axios.post("http://localhost:8001/api/user_auth/loginSms", this.ruleForm).then(response => {
            console.log(response.data)
            if (response.data.code === 200) {
              alert(response.data.data.accessToken);
              setToken(response.data.data.accessToken);
              this.$store.commit('setToken', response.data.data.accessToken);
             // _this.getUserInfo();
              _this.$router.push("/b");
            } else {
              this.$Message(response.data.message);
              
            }
          })
          .catch(() => {
            
          });
          } else {
            return false;
          }
        });
      },

      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
      getUserInfo(){
        this.$http.post("http://localhost:9101/api/system/user/getCurrentUserInfo")
          .then(res => {
            alert(res.data.message);
          })
      }
    }
  }
</script>


<style>
  #poster {
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


<template>
    <div>
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
          <el-form-item label="图书编号" >
            <el-input v-model="ruleForm.id" readonly></el-input>
          </el-form-item>
          <el-form-item label="图书名称" prop="name">
            <el-input v-model="ruleForm.name"></el-input>
          </el-form-item>
          <el-form-item label="图书作者" prop="author">
            <el-input v-model="ruleForm.author"></el-input>
          </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="updateForm('ruleForm')">立即修改</el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
      </el-form-item>
    </el-form>
    </div>
</template>

<script>
import axios from 'axios';
  export default {
    data() {
      return {
        ruleForm: {
          name: '',
          author: ''
          
        },
        rules: {
          name: [
            { required: true, message: '图书名称', trigger: 'blur' },
            { min: 3, max: 15, message: '长度在 3 到 15 个字符', trigger: 'blur' }
          ],
          author: [
            { required: true, message: '图书作者', trigger: 'blur' },
            { min: 3, max: 15, message: '长度在 3 到 15 个字符', trigger: 'blur' }
          ]
        }
      };
    },
    methods: {
      updateForm(formName) {
        const _this = this;
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$http.put('http://localhost:8001/api/book/update',this.ruleForm).then(function(res){
                if(res.data == 'success'){
                  _this.$message('修改成功');
                  _this.$router.push('/book');
                }
            })
            
          } else {
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    },
    created(){
    const _this = this;
     this.$http.get('http://localhost:8001/api/book/findById/'+this.$route.query.id).then(function(res){
        _this.ruleForm = res.data; 
     })
    }
  }
</script>


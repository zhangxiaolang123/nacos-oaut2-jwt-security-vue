<template>
    <div>
        <el-form
          ref="form"
          :rules="formRules"
          :inline="true"
          :model="form"
          label-width="80px">
          <!-- 固定项目 -->
          <el-form-item label="姓名" prop="name">
              <el-input v-model="form.name" palceholder="请输入姓名">
              </el-input>
          </el-form-item>
          <el-form-item label="手机号" prop="phone">
              <el-input v-model="form.phone" palceholder="请输入手机号">
              </el-input>
          </el-form-item>
          <div v-for="(item, index) in form.dynamicItem" :key="index">
            <el-form-item
                label="姓名"
                :prop="'dynamicItem.' + index + '.name'"
                :rules="{
                    required: true, message: '姓名不能为空', trigger: 'blur'
                }"
            >
                <el-input v-model="item.name"></el-input>
            </el-form-item>
            <el-form-item
                label="手机号"
                :prop="'dynamicItem.' + index + '.phone'"
                :rules="[
                    {required: true, message: '手机号不能为空', trigger: 'blur'},
                    <!-- { pattern: /^1[34578]\d{9}$/, message: '目前只支持中国大陆的手机号码' } -->
                  ]"
                >
                <el-input v-model="item.phone"></el-input>
            </el-form-item>
            <el-form-item>
                <i class="el-icon-delete" @click="deleteItem(item, index)"></i>
            </el-form-item>
        </div>
      </el-form>
      <el-button @click="addItem" type="primary">增加</el-button>
      <el-button type="primary" @click="addBatch()">批量提交</el-button>
    </div>
</template>

<style>
  .el-header {
    background-color: #B3C0D1;
    color: #333;
    line-height: 60px;
  }
  
  .el-aside {
    color: #333;
  }
</style>

<script>
 import axios from 'axios';
  export default {
  name: 'dynamicForm',
  data () {
    return {
      form: {
        name: '',
        phone: '',
        
        dynamicItem: [],
        tempItem: []
      },
      formRules: {
        name: [{required: true, message: '请输入姓名', trigger: 'blur'}],
        // phone: [
        //   {required: true, message: '请输入手机号', trigger: 'blur'},
        //   { pattern: /^1[34578]\d{9}$/, message: '目前只支持中国大陆的手机号码' }
        // ]
      }
    }
  },
  methods: {
    addBatch(){
      // this.form.tempItem = this.form.dynamicItem;
      this.form.tempItem =  JSON.parse(JSON.stringify(this.form.dynamicItem))
       this.form.tempItem.push({
        name: this.form.name,
        phone: this.form.phone,
      });
      const _this = this;
          this.$http.post('http://localhost:8001/api/book/addBatch',this.form.tempItem).then(function(res){
                if(res.data == 'success'){
                  _this.$message('成功');
                 // _this.findAll();
                }
            })
    },
    addItem () {
    
      this.form.dynamicItem.push({
        name: '',
        phone: ''
      });

     
      console.log(this.form);
    },
    deleteItem (item, index) {
      this.form.dynamicItem.splice(index, 1)
    },

    
}

}
</script>


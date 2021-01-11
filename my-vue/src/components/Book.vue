<template>
<div>
  <el-table
    :data="tableData"
    border
    style="width: 100% ; height: 600px ; overflow-y:auto" >
    <el-table-column
      fixed
      prop="id"
      label="id"
      width="350">
    </el-table-column>
    <el-table-column
      prop="name"
      label="姓名"
      width="220">
    </el-table-column>
    <el-table-column
      prop="author"
      label="作者"
      width="320">
    </el-table-column>
   
    <el-table-column
      fixed="right"
      label="操作"
      width="100">
      <template slot-scope="scope">
        <el-button @click="edit(scope.row)" type="text" size="small">编辑</el-button>
        <el-button @click="del(scope.row)" type="text" size="small">删除</el-button>
      </template>
    </el-table-column>
  </el-table>

  <el-pagination
    background
    layout="prev, pager, next"
    page-size="10"
    :total="total"
    @current-change ="page">
    
  </el-pagination>
</div> 
</template>

<script>
import axios from "axios";
  export default {
    methods: {
      edit(row) {
        this.$router.push({
            path:'/update',
            query:{
                id:row.id
            }
        });
      },
      del(r){
          const _this = this;
          this.$http.delete('http://localhost:8001/api/book/del/'+r.id,this.ruleForm).then(function(res){
                if(res.data == 'success'){
                  _this.$message('删除成功');
                  _this.findByPage(1);
                }
            })
      },
    //   findAll(){
    //     const _this = this;
    //     this.$http.get('http://localhost:9101/user/findAll').then(function(res){
    //     _this.tableData = res.data;
    //     })
    // },
    findByPage(current){
        const _this = this;
        this.$http.get('http://localhost:8001/api/book/findPage?pageNum='+current+'&pageSize=10').then(function(res){
        _this.tableData = res.data.list;
        _this.total = res.data.total;
        })
    },
     page(current){
        this.findByPage(current);
    },
    },
    created(){
     this.findByPage(1);
    },
    data() {
      return {
        total:null,
        tableData: [{
          id: '11',
          name: '王小虎1',
          author: '上海1'
        }, {
          id: '12',
          name: '王小虎2',
          author: '上海2'
        }, {
          id: '13',
          name: '王小虎3',
          author: '上海3'
        }, {
          id: '14',
          name: '王小虎4',
          author: '上海4'
        }]
      }
    }
  }
</script>
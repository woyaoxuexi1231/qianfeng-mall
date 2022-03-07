<template>
  <div>
    <template>
      <span style="font-size: 14px;font-family: 微软雅黑 ">商品名称</span>
      <el-input
        placeholder="输入商品名字以查询"
        v-model="searchName"
        style="width: 200px"
        clearable>
      </el-input>
      <span style="font-size: 14px;font-family: 微软雅黑 ">价格区间</span>
      <el-input-number placeholder="输入最低价" v-model="minPrice" :precision="0" :step="100" :min="0" :max="9999"></el-input-number>
      <el-input-number placeholder="输入最高价" v-model="maxPrice" :precision="0" :step="100" :min="0" :max="9999"></el-input-number>
      <el-button type="primary" @click="searchByLike" round icon="el-icon-search" size="small">搜索</el-button>
      <span style="font-size: 14px;font-family: 微软雅黑 ">选择品类</span>
      <el-select v-model="type" style="width: 200px" clearable @change="getAllBrandByType" placeholder="请选择商品大类">
        <el-option
          v-for="item in this.types"
          :key="item"
          :label="item"
          :value="item">
        </el-option>
      </el-select>
      <el-select v-model="brand" style="width: 200px" @change="getAllGoodByBrand" clearable :disabled="this.brandDisable" placeholder="请先选择大类">
        <el-option
          v-for="item in this.brands"
          :key="item"
          :label="item"
          :value="item">
        </el-option>
      </el-select>
    </template>
    <el-divider></el-divider>
    <!--商品列表-->
    <el-table
      ref="multipleTable"
      :data="goods"
      tooltip-effect="dark"
      style="width: 100%"
      @selection-change="handleSelectionChange">
      <!--复选框-->
      <el-table-column
        type="selection"
        width="55">
      </el-table-column>
      <!--商品编号-->
      <el-table-column
        prop="id"
        label="商品编号"
        width="100px"
        align="center">
      </el-table-column>
      <!--商品图片-->
      <el-table-column
        label="商品图片"
        width="100"
        align="center">
        <template slot-scope="scope">
          <el-popover placement="top-start" title="" trigger="hover">
            <img :src="scope.row.imgUrl" alt="" style="width: 150px;height: 150px">
            <img slot="reference" :src="scope.row.imgUrl" style="width: 30px;height: 30px">
          </el-popover>
        </template>
      </el-table-column>
      <!--商品名称-->
      <el-table-column
        prop="name"
        label="商品名称"
        width="500px"
        align="center">
      </el-table-column>
      <!--商品价格-->
      <el-table-column
        prop="price"
        label="商品价格"
        width="120"
        align="center">
      </el-table-column>
      <!--商品库存-->
      <el-table-column
        prop="stock"
        label="商品库存"
        width="120px"
        align="center">
      </el-table-column>
      <!--商品库存-->
      <el-table-column
        prop="proceeds"
        label="商品销量"
        width="120px"
        align="center">
      </el-table-column>
      <!--商品发布状态-->
      <el-table-column
        label="状态修改"
        width="300"
        align="center">
        <template slot-scope="scope">
          <el-radio-group v-model="scope.row.status" @change="statusChangeHandler(scope.row)">
            <el-radio :label="1">已上架</el-radio>
            <el-radio :label="2">已下架</el-radio>
            <el-radio :label="3">已删除</el-radio>
          </el-radio-group>
        </template>
      </el-table-column>
      <!--行操作按钮-->
      <el-table-column
        label="操作"
        align="center">
        <template slot-scope="scope">
          <el-button
            size="mini"
            @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!--分页操作-->
    <div class="block">
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="current_page"
        :page-sizes="[5, 10, 15, 20]"
        :page-size="5"
        layout="total, sizes, prev, pager, next, jumper"
        :total="count">
      </el-pagination>
    </div>
  </div>
</template>

<script>
export default {
  data() {

    return {
      goods: [],
      count: 0,
      current_page:1,
      limit: 5,
      searchName:'',
      minPrice:0,
      maxPrice:0,
      multipleSelection:[],
      types:[],
      type:"",
      brands:[],
      brand:"",
      brandDisable:true,
      }

  },
  methods:{
    getAllGood(current_page,limit){
      console.log(this.type)
      console.log(this.brand)
      if(this.minPrice == undefined){
        this.minPrice = 0;
      }
      if(this.maxPrice == undefined){
        this.maxPrice = 0;
      }
      if(this.minPrice>this.maxPrice){
        this.$message.error('请正确输入价格范围哦');
      }else {
        var params = new URLSearchParams();
        params.append('name', this.searchName);
        params.append('minPrice', this.minPrice);
        params.append('maxPrice', this.maxPrice);
        params.append('page', current_page);
        params.append('limit', limit);
        params.append('brand', this.brand);
        params.append('type', this.type);
        this.$axios({
          method: 'post',
          url: "/goods/getAllGood",
          data: params
        })
          .then(res => {
            console.log(res.data.data);
            this.goods = res.data.data;
            this.count = res.data.count;
            if(this.count==0) {
              this.$notify.error({
                title: '失败',
                message: "未能查询到商品",
              });
            }
          })
          .catch(err => {
            console.log(err);
          });
      }
    },
    /*监听复选框*/
    handleSelectionChange(val) {
      console.log(val);
      this.multipleSelection = val;
    },
    /*行操作监听*/
    handleEdit(index, row) {
      sessionStorage.setItem("good",row.id);
      this.$router.push('/pms/editProduct')
    },
    handleDelete(index, row) {
      console.log(index, row);
    },
    /*发布状态监听*/
    statusChangeHandler(value){
      //post请求只能用这种方法进行传参
      var params = new URLSearchParams();
      params.append('id', value.id);
      params.append('status', value.status);
      this.$axios({
        method : 'post',
        url:"/goods/statusChange",
        data:params})
        .then(res => {
          if(value.status==1){
            this.$message({
              message: res.data.data,
              type: 'success'
            });
          }else {
            this.$message({
              message: res.data.data,
              type: 'warning'
            });
          }
        })
        .catch(err =>{
          console.log(err);
        })
    },
    /*页码监听*/
    handleCurrentChange(val){
      this.current_page = val;
      this.getAllGood(this.current_page,this.limit);
    },
    /*limit监听*/
    handleSizeChange(val) {
      this.limit = val;
      this.getAllGood(this.current_page,this.limit);
    },
    /*模糊查询*/
    searchByLike(){
      if(this.minPrice == undefined){
        this.minPrice = 0;
      }
      if(this.maxPrice == undefined){
        this.maxPrice = 0;
      }
      if(this.minPrice>this.maxPrice){
        this.$message.error('请正确输入价格范围哦');
      }else {
        var params = new URLSearchParams();
        params.append('name', this.searchName);
        params.append('minPrice', this.minPrice);
        params.append('maxPrice', this.maxPrice);
        params.append('page', 1);
        params.append('limit', this.limit);
        this.$axios({
          method: 'post',
          url: "/goods/getAllGood",
          data: params
        })
          .then(res => {
            if (res.data.code == 500) {
              this.$notify.error({
                title: '失败',
                message: res.data.message,
              });
              this.getAllGood(this.current_page, this.limit);
            }
            if (res.data.code == 200) {
              this.goods = res.data.data;
              this.count = res.data.count;
            }
          })
          .catch(err => {
            console.log(err);
          })
      }
    },
    getAllType(){
      this.$axios.get("/type_brand/getAllType")
        .then(res => {
          this.types = res.data.data;
          this.type = '';
        })
        .catch(err => {
          console.log(err);
        });
    },
    getAllBrandByType(val){
      if(val==""){
        this.brands='';
        this.brand='';
        this.brandDisable = true;
        this.getAllGood(this.current_page,this.limit);
      }
      if(val!=""){
        this.brandDisable = false;
        this.$axios({
          method:'get',
          url:'/type_brand/getAllBrandByType?type='+val,
        })
          .then(res => {
            this.brands = res.data.data;
            this.brand = '';
            console.log(this.brands)
          })
          .catch(err => {
            console.log(err);
          });
      }
    },
    getAllGoodByBrand(val){
      this.getAllGood(1,this.limit);
    },

    handleChange(value) {
      console.log(value);
    }
  },
  mounted() {
    this.getAllGood(this.current_page,this.limit);
    this.getAllType();
  }
}
</script>

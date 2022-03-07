<template>
<div>
  <div style="width: 80%;margin: auto;">
    <el-page-header  content="我的订单"
                     @back="jumpToDisplayGoods"
                     style="height: 100px;line-height: 100px;width: 75%;float: left">
    </el-page-header>
    <div style="float: right;line-height: 100px">
              <span style="margin-right: 10px">
                {{username}}
              </span>
      <el-button type="danger"
                 size="medium"
                 style="width: 100px;text-align: center"
                 @click="logout">
        退出登录
      </el-button>
      <el-button type="success"
                 size="medium"
                 style="width: 100px;text-align: center"
                 @click="jumpToShoppingCar">
        购物车
      </el-button>
    </div>
  </div>

    <div style="width: 80%;margin: auto;">


      <el-table
        :data="orders"
        stripe
        style="width: 100%;">
        <el-table-column
          prop="name"
          label="商品名"
          align="center"
        >
        </el-table-column>
        <el-table-column
          label="商品图片"
          align="center"
        >
          <template slot-scope="scope">
            <el-image :src="scope.row.imgUrl"
                      style="width: 80px; height: 80px"
            >
            </el-image>
          </template>
        </el-table-column>
        <el-table-column
          align="center"
          label="价格"
          >
          <template slot-scope="scope">
            <span style="color: #ff6700">{{scope.row.price}}元</span>
          </template>
        </el-table-column>
        <el-table-column
          prop="count"
          align="center"
          label="数量"
        >
        </el-table-column>
        <el-table-column
          prop="create_time"
          align="center"
          label="购买时间">
        </el-table-column>
      </el-table>
    </div>
</div>
</template>

<script>
export default {
  name: "orderDisplay",
  data(){
    return{
      userId:'1',
      orders:[],
      userName:'卡哇伊',
    }
  },
  methods:{
    getAllOrder(){
      this.$axios.get("ShoppingCar/getOrder?userId="+this.userId).then(res=>{
        this.orders=res.data.data;
      })
    },
    jumpToShoppingCar(){
      this.$router.push("/shoppingCar")
    },
    jumpToDisplayGoods(){
      this.$router.push("/displayGoods")
    },
    logout(){
      this.$axios.post("logout")
        this.$router.push("/")
    },
    init(){
      this.userId=sessionStorage.getItem("userId");
      this.username=sessionStorage.getItem("username");
    }
  },
  mounted() {
    this.init();
    this.getAllOrder();
  }
}
</script>

<style scoped>

</style>

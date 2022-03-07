<template>
  <div style="background: #f5f5f5;height: 100%">
    <div style="border-bottom: 2px solid #ff6700">
      <div style="width: 80%;margin: auto">
        <el-page-header  content="我的购物车"
                         @back="jumpToDisplayGoods"
                         style="height: 100px;line-height: 100px;width: 80%;float: left">
        </el-page-header>
        <div style="float: right;line-height: 100px">
              <span style="margin-right: 10px">
                {{username}}
              </span>
          <el-button type="danger"
                     size="medium"
                     style="height: 30px;width: 80px"
                     @click="logout">
            退出登录
          </el-button>
          <el-button type="primary"
                     size="medium"
                     style="height: 30px;width: 80px"
                     @click="gotoOrder">
            查看订单
          </el-button>
        </div>
      </div>
    </div>

    <div  style="width: 80%;
                margin: auto;
                margin-top: 40px;
                " >
      <el-table
        ref="multipleTable"
        :data="tableData"
        tooltip-effect="dark"
        style="width: 100%;border: 0"
        @selection-change="handleSelectionChange">

        <el-table-column
          type="selection"
          label="全选"
          align="center"
        >
        </el-table-column>

        <el-table-column
          label="图片"
          align="center"
        >
          <template slot-scope="scope">
            <el-image :src="scope.row.img_url"
                      style="width: 80px; height: 80px"
                      >
            </el-image>
          </template>
        </el-table-column>

        <el-table-column
          prop="name"
          label="商品名称"
          align="center"
        >
          <!--<template slot-scope="scope">{{ scope.row.date }}</template>-->
        </el-table-column>

        <el-table-column
          label="单价"
          width="100px"
          align="center"
        >
          <template slot-scope="scope">
            <p>{{scope.row.price}}元</p>
          </template>
        </el-table-column>

        <el-table-column
          prop="number"
          label="数量"
          align="center"
        >
          <template slot-scope="scope">
            <el-input-number size="small"
                             :min = "1"
                             :max="10"
                             v-model="scope.row.number"
                             @change="changeNumber(scope)"
            >
            </el-input-number>
          </template>
        </el-table-column>

        <el-table-column
          prop="Subtotal"
          label="小计"
          align="center">
          <template slot-scope="scope">
            <p style="color: #ff6700">{{scope.row.number*scope.row.price}}元</p>
          </template>
        </el-table-column>

        <el-table-column label="操作"
                         align="center">
          <template slot-scope="scope">
            <el-button type="danger" icon="el-icon-delete" circle
                       @click="deleteThisGood(scope.row)"></el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>

    <div v-if="!theCarHight()" style="margin-top: 30px;
                                      background: white;
                                      margin-left: 10%;
                                      height: 50px;
                                      text-align: left;
                                      width: 80%">
      <span style="margin-left: 10%;
                   color: #757575;
                   line-height: 50px">
        共
        <i style="color: #ff6700">{{count}}</i>
        件商品,已选择
        <i style="color: #ff6700">{{selectedQuantity}}</i>
        件
      </span>

      <span style="color: #ff6700;margin-left: 45%">
        合计
        <i style="font-size: 30px">{{total}}</i>
        元
      </span>

      <!--勾选时的按钮-->
      <el-button v-if="total>0" style="float: right;
                    height: 50px;
                    width: 200px;
                    color: #fff;
                    border: 0;
                    font-size: 18px;
                    background: #ff6700"
              @click="settlement()"
      >
        去结算
      </el-button>

      <!--没有勾选时的按钮-->
      <button v-if="total==0" style="float: right;
                    height: 50px;
                    width: 200px;
                    color: #fff;
                    border: 0;
                    font-size: 18px;
                    background: #e0e0e0">
        请勾选商品
      </button>

    </div>

    <div v-if="theCarHight()" style="margin-top: -40px;height: 100px">

    </div>


    <div v-if="theCarHight()" style="width: 80%;
                list-style:none;
            position:fixed;
            bottom:0;
            left: 10%;
            background: white;
            height: 50px;
            z-index:2;
            text-align: left;
            box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)
            "
    >


      <span style="margin-left: 10%;
                   color: #757575;
                   line-height: 50px">
        共
        <i style="color: #ff6700">{{count}}</i>
        件商品,已选择
        <i style="color: #ff6700">{{selectedQuantity}}</i>
        件
      </span>

      <span style="color: #ff6700;margin-left: 45%">
        合计
        <i style="font-size: 30px">{{total}}</i>
        元
      </span>

      <!--勾选时的按钮-->
      <el-button v-if="total>0" style="float: right;
                    height: 50px;
                    width: 200px;
                    color: #fff;
                    border: 0;
                    font-size: 18px;

                    background: #ff6700"
                 @click="settlement()"
      >
        去结算
      </el-button>

      <!--没有勾选时的按钮-->
      <button v-if="total==0" style="float: right;
                    height: 50px;
                    width: 200px;
                    color: #fff;
                    border: 0;
                    font-size: 18px;
                    background: #e0e0e0">
        请勾选商品
      </button>
    </div>
  </div>
</template>

<script>
export default {
  name: "shoppingCart",
  data() {
    return {
      //image:"api/xiaomi10U.jpg",
      username:"卡哇伊",
      userId:'',
      tableData: [],
      multipleSelection: [],
      divHeight:'',
      count:'',
      selectedQuantity:'0',
      total:'0',
      resultData:[{}],
    }
  },

  methods: {
    toggleSelection(rows) {
      //console.log(rows);
        this.$refs.multipleTable.toggleRowSelection(rows);
        this.$refs.multipleTable.toggleRowSelection(rows);
    },
    handleSelectionChange(val) {
      //console.log(val);
      this.multipleSelection = val;
      var selectedQuantity=0;
      var total=0;
      for (let i = 0; i < val.length; i++) {
          selectedQuantity+=val[i].number;
          total+=val[i].number*val[i].price;
      }
      this.selectedQuantity=selectedQuantity;
      this.total=total;
    },
    theCarHight(){
      if(this.tableData.length>4)return true;
    },
    viewShoppingCart(){
      this.$axios
        .get('ShoppingCar/viewShoppingCar?userId='+this.userId)
        .then(res => {
          console.log(res.data);
          this.tableData = res.data.data
          this.setCount()
        })
        .catch(err => {
          alert("查询失败");
          console.log(err);
        })
    },
    deleteThisGood(row){
      console.log(row);
      this.$axios
        .get('ShoppingCar/deleteThisGood?id='+row.id+"&userId="+this.userId)
        .then(res => {
          console.log(res.data);
          this.tableData = res.data.data
          this.setCount();
          this.$message({
            message: '删除成功',
            type: 'success'
          });
        })
        .catch(err => {
          alert("删除失败");
          console.log(err);
        })
    },
    changeNumber(scope){
      console.log(this.tableData[scope.$index]);
      this.$axios
        .get('ShoppingCar/changeNumber?id='+scope.row.id+"&number="+scope.row.number)
        .then(res => {
          this.setCount();
          this.toggleSelection(this.tableData[scope.$index])
        })
    },
    setCount(){
      var count=0;
      for (let i = 0; i < this.tableData.length; i++) {
        //console.log(this.tableData[i].number);
        count+=this.tableData[i].number;
      }
      this.count=count;
    },
    settlement(){
      var resultData=new Array(this.multipleSelection.length+1);
      var i=0;
      this.multipleSelection.forEach(item=>{
        console.log(item);
        console.log(item.good_id);
        if(i==0){
          resultData[i]=item.user_id;
          i++;
        }
        resultData[i]=item.id;
        i++;
        resultData[i]=item.good_id;
        i++;
        resultData[i]=item.number;
        i++;
      })
      console.log(resultData);
      const params = new URLSearchParams();
      params.append('ids', resultData);
      this.$axios.post('ShoppingCar/settlement',params)
        .then(res => {
          console.log(res.data);
          this.tableData = res.data.data
          this.setCount();
          this.$message({
            message: '购买成功',
            type: 'success'
          });
        })
        .catch(err => {
          alert("购买失败");
          console.log(err);
        })
      console.log(resultData)
    },
    jumpToDisplayGoods(){
      this.$router.push("/displayGoods")
    },
    logout(){
      this.$axios.post("logout")
        this.$router.push("/")
    },
    gotoOrder(){
      this.$router.push("/orderDisplay")
    },
    init(){
      this.userId=sessionStorage.getItem("userId");
      this.username=sessionStorage.getItem("username");
      this.viewShoppingCart();
    }
    
  },
  mounted() {
    this.init();
    

  },
}

</script>

<style scoped>
* {
  margin:0;
  padding:0;
  text-align: center;
}
</style>

<template>
  <div style="height: 100%">
      <div >
        <div style="height: 100px">

            <div style="float:left;
                      color: #ff6700;
                      font-size: 40px;
                      margin-left: 14%;
                      line-height: 100px;">
              <span >
                MALL电商
              </span>
            </div>
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
              <el-button
                type="primary"
                size="medium"
                style="height: 30px;width: 80px"
                @click="gotoOrder">
                查看订单
              </el-button>
              <el-button type="success"
                         size="medium"
                         style="height: 30px;margin-right: 60px;width: 80px"
                         @click="jumpToShoppingCar">
                购物车
              </el-button>
            </div>
        </div>
      </div>

    <div>
      <el-carousel height="550px"  :interval="5000" >
        <el-carousel-item v-for="(item,index) in poster" :key="item.good_id">
          <el-image
            @click="jumpToDisplay(item.good_id)"
            style="height: 550px;width: 100%"
            :fit="fit"
            :src="item.img_url"></el-image>
        </el-carousel-item>
      </el-carousel>
    </div>

    <div style="margin: auto;width: 80%;height: 100%">
      <el-card
        style="width: 23.75%;height: 350px;float: left;margin-left: 1%;margin-top: 1%"
        v-for="(value,index) in allGood" :key="value.id" shadow="hover">
        <el-image
          style="width: 200px"
          :src="value.img_url"
          @click="jumpToDisplay(value.id)"
        >
        </el-image>
        <p style="color: #757575;font-size: 14px">
          {{value.name}}
        </p>
        <p style="color: #ff6700">
          {{value.price}}元
        </p>

        <el-button v-if="hisThisGood(value.id)"
                   type="success"
                   style="width: 60%;margin-top: 10%;height: 30px"
                   size="medium"
                    @click="jumpToShoppingCar">
          已加购 点击查看
        </el-button>
        <el-button v-else type="primary"
                   style="width: 60%;margin-top: 10%;height: 30px"
                   size="medium"
                    @click="addShoppingCar(value.id)">
          加入购物车
        </el-button>
      </el-card>
    </div>
  </div>
</template>

<script>
export default {
name: "displayGoods",
  data(){
  return {
    username:'卡哇伊',
    allGood:[],
    allShoppingCarGood:[],
    userId:'1',
    poster:[],
    fit:"cover",
  }
  },
  methods:{
      getAllGoods(){
          this.$axios.get("display/displayGoods?userId="+this.userId)
            .then(res => {
              //console.log(res.data);
              this.allGood = res.data.data;
            })
            /*.catch(err => {
              alert("查询失败");
              console.log(err);
            })*/
        this.$axios.get("display/allShoppingCarGood?userId="+this.userId)
          .then(res => {
            console.log(res.data);
            this.allShoppingCarGood = res.data.data;
          })
          .catch(err => {
            alert("查询失败");
            console.log(err);
          })
      },
      getPoster(){
        this.$axios.get("display/getAllPoster")
          .then(res => {
            console.log(111);
            this.poster = res.data.data;
          })
          .catch(err => {
            alert("查询失败");
            console.log(err);
          })
      },
      hisThisGood(item){
        for (let i = 0; i < this.allShoppingCarGood.length; i++) {
            if(this.allShoppingCarGood[i]==item){
              return true;
            }
        }
        return false;
      },
      addShoppingCar(item){
        this.$axios.get("ShoppingCar/addShoppingCar?userId="+this.userId+"&goodId="+item)
          .then(res => {
            this.allShoppingCarGood = res.data.data;
          })
          .catch(err => {
            alert("加购失败");
            console.log(err);
          })
      },
    jumpToShoppingCar(){
      this.$router.push("/shoppingCar")
    },
    jumpToDisplay(good_id){
        var isInShoppingCar =0;
      if(this.hisThisGood(good_id))isInShoppingCar=1;
      sessionStorage.setItem("isInShoppingCar",isInShoppingCar) ;
      sessionStorage.setItem("goodId",good_id);
      this.$router.push("/display")
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
    }
  },
  mounted() {
      this.init();
      this.getAllGoods();
      this.getPoster();
  }
}
</script>

<style scoped>
/*.el-carousel__item h3 {
  !*color: #475669;
  font-size: 18px;
  opacity: 0.75;
  height: 520px;
  line-height: 620px;*!
  margin: 0;
}*/

/*.el-carousel__item:nth-child(2n) {

  height: 520px;
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
  line-height: 620px;
  height: 520px;
  background-color: #d3dce6;
}*/
* {
  margin:0;
  padding:0;
  text-align: center;
}
</style>

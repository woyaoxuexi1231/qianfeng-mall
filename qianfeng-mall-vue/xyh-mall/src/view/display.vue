<template>
  <div style="background: white;height: 100%">
    <div style="border-bottom: 2px solid #ff6700">
      <div style="width: 80%;margin: auto">
        <el-page-header  content="商品信息"
                         @back="jumpToDisplayGoods"
                         style="height: 100px;line-height: 100px;">
        </el-page-header>
      </div>
    </div>
    <div style="width: 80%;margin: auto;margin-top: 50px">
      <div style="float: left">
        <el-carousel
          indicator-position="outside"
          style="width:520px"
          height="520px"
          :interval="5000"
          arrow="always">
          <el-carousel-item v-for="(item,index) in images" :key="index">
            <el-image style="width: 520px" :src="item">
            </el-image>
          </el-carousel-item>
        </el-carousel>
      </div>
      <div style="float: left;margin-left: 40px;">
        <p style="font-size: 26px;color: #121212;font-weight: 400;text-align: left">
          {{good.name}}
        </p>
        <div style="width: 650px;color: #b0b0b0;line-height: 1.5;">
          <p style="text-align: left">
            <br/>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            {{good.description}}
          </p>
        </div>
        <p style="font-size: 20px;color: #ff6700;text-align: left">
            <br/>
            {{good.price}}元
        </p>
        <div style="margin-top: 200px;" >
          <el-button v-if="isInShoppingCar==1"
                     type="success"
                     style="width: 60%;margin-top: 10%;height:30px"
                     size="medium"
                     @click="jumpToShoppingCar" >
            已加购 点击查看
          </el-button>
          <el-button v-else type="primary"
                     style="width: 60%;margin-top: 10%;height: 30px"
                     size="medium"
                     @click="addShoppingCar">
            加入购物车
          </el-button>
        </div>
      </div>
    </div>

  </div>
</template>

<script>
export default {
  name: "display",
  data(){
    return {
      good:[],
      images:[],
      userId:'1',
      fit:"cover",
      goodId:'1',
      isInShoppingCar:'',
    }
  },
  methods:{
    jumpToDisplayGoods(){
      this.$router.push("/displayGoods")
    },
    getGoodInformation(){
      this.$axios.get("ShowInformation/getGoodInformation?goodId="+this.goodId)
      .then(res=>{
        console.log(res);
        this.good=res.data.data;
      })
      this.$axios.get("ShowInformation/getAllImage?goodId="+this.goodId)
        .then(res=>{
          console.log(res);
          this.images=res.data.data;
        })
    },
    jumpToShoppingCar(){
      this.$router.push("/shoppingCar")
    },
    addShoppingCar(){
      this.$axios.get("ShoppingCar/addShoppingCar?userId="+this.userId+"&goodId="+this.goodId)
        .then(res => {
          this.isInShoppingCar=1;
        })
        .catch(err => {
          alert("加购失败");
          console.log(err);
        })
    },
    init(){
      this.userId=sessionStorage.getItem("userId");
      this.username=sessionStorage.getItem("username");
    }
    /*inShoppingCar(item){
      console.log(1111);
      return true;
    }*/
  },
  mounted() {
    this.init();
    this.goodId=sessionStorage.getItem("goodId");
    //console.log(sessionStorage.getItem("isInShoppingCar"));
    this.isInShoppingCar=sessionStorage.getItem("isInShoppingCar")
    this.getGoodInformation();

  }
}

</script>

<style scoped>
* {
  margin:0;
  padding:0;
  text-align: center;
}
.el-carousel__item h3 {
  color: #475669;
  font-size: 18px;
  opacity: 0.75;
  line-height: 300px;
  margin: 0;
  indicator:"none"
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}
</style>

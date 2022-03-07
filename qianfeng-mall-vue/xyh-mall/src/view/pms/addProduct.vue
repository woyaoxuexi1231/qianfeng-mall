<template>
  <el-form :model="goodsForm" :rules="rules" ref="goodsForm" label-width="100px" class="demo-goodsForm" style="width: 60%">
    <el-form-item label="商品名称" prop="name">
      <el-input v-model="goodsForm.name"></el-input>
    </el-form-item>
    <el-form-item label="商品品牌" prop="brand">
      <el-select v-model="goodsForm.brand" placeholder="请选择商品品牌">
        <el-option v-for="item in this.brands":key="item":label="item":value="item"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="商品类型" prop="type">
      <el-select v-model="goodsForm.type" placeholder="请选择商品类型">
        <el-option v-for="item in this.types":key="item":label="item":value="item"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="商品价格" prop="price">
      <el-input-number v-model="goodsForm.price"  :min="0" :max="99999" label="描述文字"></el-input-number>
    </el-form-item>
    <el-form-item label="商品状态" prop="status">
      <template>
        <el-radio-group v-model="goodsForm.status">
          <el-radio :label="1">已上架</el-radio>
          <el-radio :label="2">已下架</el-radio>
          <el-radio :label="3">已删除</el-radio>
        </el-radio-group>
      </template>
    </el-form-item>
    <el-form-item label="商品预览图">
      <template>
        <el-popover placement="top-start" title="" trigger="hover">
          <img :src="goodsForm.imgUrl" alt="" style="width: 150px;height: 150px">
          <img slot="reference" :src="goodsForm.imgUrl" style="width: 30px;height: 30px">
        </el-popover>
        <el-upload
          class="upload-demo"
          action="http://127.0.0.1:8080/file/upload"
          :on-preview="handlePreview"
          :on-remove="handleRemove"
          :before-remove="beforeRemove"
          multiple
          :limit="1"
          :file-list="fileList"
          :on-exceed="handleExceed"
          :on-success="handleAvatarSuccess">
          <el-button size="small" type="primary">点击上传更改预览图</el-button>
          <div slot="tip" class="el-upload__tip">只能上传jpg/png文件</div>
        </el-upload>
      </template>
    </el-form-item>
    <el-form-item label="销量" prop="proceeds">
      <el-input-number v-model="goodsForm.proceeds"  :min="0" :max="99999" label="描述文字"></el-input-number>
    </el-form-item>
    <el-form-item label="库存" prop="stock">
      <el-input-number v-model="goodsForm.stock"  :min="0" :max="99999" label="描述文字"></el-input-number>
    </el-form-item>
    <el-form-item label="商品描述">
      <el-input
        type="textarea"
        :autosize="{ minRows: 2, maxRows: 4}"
        placeholder="请输入商品描述"
        v-model="goodsForm.description">
      </el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="submitForm('goodsForm')">点击添加</el-button>
      <el-button @click="resetForm('goodsForm')">重置</el-button>
    </el-form-item>
    <el-form-item label="上传图片展示">
      <el-upload
        class="upload-demo"
        action="http://127.0.0.1:8080/file/upload"
        :on-preview="handlePreview"
        :on-remove="handleRemove"
        :on-success="handleAvatarSuccess2"
        :file-list="fileList2"
        list-type="picture">
        <el-button size="small" type="primary">点击添加图片</el-button>
        <div slot="tip" class="el-upload__tip">只能上传jpg/png文件</div>
      </el-upload>
      <el-button size="small" type="success" icon="el-icon-upload2" @click="uploadGoodImage">点击上传</el-button>
    </el-form-item>
  </el-form>

</template>
<script>
export default {
  data() {
    return {
      goodsForm:{},
      brands:[],
      types:[],
      fileList:[],
      fileList2:[],
      file_name:'',
      file_URL:'',
      file_URL_list:[],
      good_id:'',
      /*规则*/
      rules: {
        name: [
          { required: true, message: '请输入商品名称', trigger: 'blur' },
          { min: 1, max: 50, message: '长度在 1 到 50 个字符', trigger: 'blur' }
        ],
        brand: [
          { required: true, message: '请选择商品品牌', trigger: 'change' }
        ],
        type: [
          { required: true, message: '请选择商品类型', trigger: 'change' }
        ],
        price: [
          { required: true, message: '请输入商品价格', }
        ],
        status: [
          { required: true, message: '请选择商品状态', trigger: 'change' }
        ],
        proceeds: [
          { required: true, message: '请输入商品销量', }
        ],
        stock: [
          { required: true, message: '请输入商品销量', }
        ],
      }
    };
  },
  methods: {
    /*提交表单*/
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          //下面为axios传对象的方法
          if (this.file_URL!=''){
            this.goodsForm.imgUrl = this.file_URL[0];
          }else{
            this.goodsForm.imgUrl = '';
          }
          this.goodsForm.id='';
          console.log(this.goodsForm)
          // let good= JSON.stringify(this.goodsForm);
          this.$axios({
            method: 'post',
            url: "/goods/addGood",
            data: this.goodsForm,
            // headers: {
            //   "Content-Type": "application/json;charset=utf-8"  //头部信息
            // }
          })
            .then(res => {
              if (res.data.code == 200) {
                this.good_id = res.data.data;
                this.$notify({
                  title: '成功',
                  message: res.data.message,
                  type: 'success'
                });
                this.fileList = [];
              }
              if (res.data.code == 500) {
                this.$notify.error({
                  title: '错误',
                  message: res.data.data,
                });
              }
            })
            .catch(err => {
              console.log(err);
            })
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    /*查询品牌*/
    getAllBrand(){
      this.$axios.get("/goods/getAllBrand")
        .then(res => {
          this.brands = res.data.data;
        })
        .catch(err => {
          console.log(err);
        });
    },
    /*查询类型*/
    getAllType(){
      this.$axios.get("/goods/getAllType")
        .then(res => {
          this.types = res.data.data;
        })
        .catch(err => {
          console.log(err);
        });
    },
    /*预览图修改*/
    handleRemove(file, fileList) {
      console.log("移除了",file, fileList);
      this.file_URL='';
    },
    /*文件上传*/
    handleAvatarSuccess(res, file) {
      this.file_URL = res;
      this.file_name = file.name;
      console.log("文件地址："+this.file_URL);
      console.log("文件名字："+this.file_name);
    },
    handlePreview(file) {
      console.log(file);
    },
    handleExceed(files, fileList) {
      this.$message.warning(`当前限制选择 1 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
    },
    beforeRemove(file, fileList) {
      return this.$confirm(`确定移除 ${ file.name }？`);
    },
    handleAvatarSuccess2(res, file) {
      this.file_URL_list.push(res);
      console.log(this.file_URL_list);
    },
    //多文件上传
    uploadGoodImage(){
      if(this.good_id!=''){
        var params =new URLSearchParams();
        params.append("goodId",this.good_id);
        params.append("images",this.file_URL_list);
        this.$axios({
          method: 'post',
          url: "/goods/uploadGoodImage",
          data: params,
          /*headers: {
            "Content-Type": "application/json;charset=utf-8"  //头部信息
          }*/
        })
          .then(res => {
            if (res.data.code == 200) {
              this.$notify({
                title: '成功',
                message: res.data.data,
                type: 'success'
              });
              this.fileList = [];
            }
            if (res.data.code == 500) {
              this.$notify.error({
                title: '错误',
                message: res.data.data,
              });
            }
          })
          .catch(err => {
            console.log(err);
          })
      }else {
        this.$notify.error({
          title: '请先添加商品的基本信息再上传照片',
        });
      }
    }

  },
  mounted() {
    this.getAllType();
    this.getAllBrand();
  }
}
</script>

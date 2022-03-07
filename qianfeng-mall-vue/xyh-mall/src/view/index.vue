<template>
    <div class="wrap">
        <div class="menu">
            <el-menu
                :default-active="this.$route.path"
                class="el-menu-vertical-demo"
                @open="handleOpen"
                @close="handleClose"
                background-color="#304156"
                text-color="#bfcbd9"
                active-text-color="#1890ff"
                router
            >
                <el-menu-item index="/home">
                    <i class="el-icon-s-home"></i>
                    <span slot="title">首页</span>
                </el-menu-item>
                <el-submenu
                    :index="menuItem.id"
                    v-for="menuItem in menuItems"
                    :key="menuItem.id"
                >
                    <template slot="title">
                        <i :class="menuItem.icon"></i>
                        <span>{{ menuItem.name }}</span>
                    </template>
                    <el-menu-item
                        :index="subItem.id"
                        v-for="subItem in menuItem.subItems"
                        :key="subItem.id"
                    >
                        <template slot="title">
                            <i :class="subItem.icon"></i>
                            <span>{{ subItem.name }}</span>
                        </template>
                    </el-menu-item>
                </el-submenu>
            </el-menu>
        </div>
        <div style="position: relative; padding-left: 200px">
            <div class="headBar">
                <el-breadcrumb
                    class="breadcumb"
                    separator="/"
                    style="padding-left: 30px"
                >
                    <el-breadcrumb-item
                        v-for="(item, i) in breadcumb.list"
                        :key="i"
                        class="breadcumb-link"
                        :class="{ last: i == breadcumb.list.length - 1 }"
                        :to="{ path: item.path }"
                        >{{ item.name }}</el-breadcrumb-item
                    >
                </el-breadcrumb>
                <el-dropdown
                    trigger="click"
                    class="avatar"
                    style="padding-right: 30px"
                >
                    <el-button>{{username}}</el-button>
                    <el-dropdown-menu slot="dropdown" class="avatar-s">
                        <el-dropdown-item @click.native="toHome">首页</el-dropdown-item>
                        <el-dropdown-item @click.native="logout">退出</el-dropdown-item>
                    </el-dropdown-menu>
                </el-dropdown>
            </div>
            <div class="content">
                <router-view></router-view>
            </div>
        </div>
    </div>
</template>
<style scoped>
.el-menu-vertical-demo:not(.el-menu--collapse) {
    width: 200px;
    min-height: 30px;
    height: 100%;
}
.wrap {
    position: absolute;
    height: 100%;
    width: 100%;
}
.menu {
    height: inherit;
    width: 200px;
    position: fixed;
    left: 0;
    top: 0%;
    z-index: 999;
}
.headBar {
    height: 56px;
    border-bottom: 1px solid #f0f2f5;
    display: flex;
    align-items: center;
    justify-content: space-between;
}
.content {
    padding: 20px;
}
.logo {
    background-color: #2b2f3a;
    height: 56px;
    display: flex;
    align-items: center;
    justify-content: center;
    color: #fff;
    font-size: 14px;
    font-weight: bold;
}
.logo img {
    height: 32px;
    width: 32px;
}
.el-avatar >>> img {
    width: 100%;
}
</style>

<script>
import { mapState } from "vuex";
export default {
    name: "Menu",
    data() {
        return {
            username: "",
            menuItems: [
                {
                    id: "/pms",
                    name: "商品",
                    icon: "el-icon-shopping-bag-1",
                    subItems: [
                        { id: "/pms/product", name: "商品列表", icon: "el-icon-set-up" },
                        { id: "/pms/addProduct", name: "添加商品", icon: "el-icon-shopping-cart-full" },
                        { id: "/pms/productCate", name: "商品分类", icon: "el-icon-menu" },
                        { id: "/pms/productAttr", name: "商品类型", icon: "el-icon-guide" },
                        { id: "/pms/brand", name: "品牌管理", icon: "el-icon-s-platform" },
                    ],
                },
                {
                    id: "/oms",
                    name: "订单",
                    icon: "el-icon-s-order",
                    subItems: [
                        { id: "/oms/order", name: "订单列表", icon: "el-icon-tickets" },
                        { id: "/oms/orderSetting", name: "订单设置", icon: "el-icon-setting" },
                        {
                            id: "/oms/returnApply",
                            name: "退货申请处理",
                            icon: "el-icon-box",
                        },
                        {
                            id: "/oms/returnReason",
                            name: "退货原因设置",
                            icon: "iconfont icon-tuihuoyuanyin",
                        },
                    ],
                },
            ],
        };
    },
    computed: {
        ...mapState(["breadcumb"]),
    },
    methods: {
        handleOpen(key, keyPath) {
            console.log(key, keyPath);
        },
        handleClose(key, keyPath) {
            console.log(key, keyPath);
        },
        toHome(){
            this.$router.push("/home")
        },
        logout(){
            this.$axios.post("logout")
            this.$router.push("/")
        }
    },
    mounted(){
        this.username = sessionStorage.getItem("username");
    }
};
</script>

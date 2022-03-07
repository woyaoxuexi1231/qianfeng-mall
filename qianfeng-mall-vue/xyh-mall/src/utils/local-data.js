/*-------------------------router面包屑-start---------------------------------------*/
const routerBreadcrumb = {
    home:{
        list: [
            { name: "首页", path: "/home" }
        ]
    },
    product:{
        list: [
            { name: "首页", path: "/home" },
            { path: "/pms/product", name: "商品" },
            { path: "/pms/product", name: "商品列表" },
        ]
    },
    addProduct:{
        list:[
            { name: "首页", path: "/home" },
            { path: "/pms/product", name: "商品" },
           { path: "/pms/addProduct", name: "添加商品"}
        ]
    },
    editProduct:{
      list:[
        { name: "首页", path: "/home" },
        { path: "/pms/product", name: "商品" },
        { path: "/pms/editProduct", name: "编辑商品"}
      ]
    },
    productCate:{
        list: [
            { name: "首页", path: "/home" },
            { path: "/pms/product", name: "商品" },
            { path: "/pms/productCate", name: "商品分类" },
        ]
    },
    productAttr:{
        list: [
            { name: "首页", path: "/home" },
            { path: "/pms/product", name: "商品" },
            { path: "/pms/productAttr", name: "商品类型" },
        ]
    },
    brand:{
        list: [
            { name: "首页", path: "/home" },
            { path: "/pms/product", name: "商品" },
            { path: "/pms/brand", name: "品牌管理" },
        ]
    },
    order:{
        list: [
            { name: "首页", path: "/home" },
            { path: "/oms/order", name: "订单" },
            { path: "/oms/order", name: "订单列表" },
        ]
    },
    orderDetail:{
        list: [
            { name: "首页", path: "/home" },
            { path: "/oms/order", name: "订单" },
            { path: "/oms/orderDetail", name: "订单详情" },
        ]
    },
    deliverOrderList:{
        list: [
            { name: "首页", path: "/home" },
            { path: "/oms/order", name: "订单" },
            { path: "/oms/deliverOrderList", name: "发货列表" },
        ]
    },
    orderSetting:{
        list: [
            { name: "首页", path: "/home" },
            { path: "/oms/order", name: "订单" },
            { path: "/oms/orderSetting", name: "订单设置" },
        ]
    },
    returnApply:{
        list: [
            { name: "首页", path: "/home" },
            { path: "/oms/order", name: "订单" },
            { path: "/oms/returnApply", name: "退货申请处理" },
        ]
    },
    returnReason:{
        list: [
            { name: "首页", path: "/home" },
            { path: "/oms/order", name: "订单" },
            { path: "/oms/returnReason", name: "退货原因设置" },
        ]
    },
}
/*-------------------------router面包屑-end---------------------------------*/
export {
    routerBreadcrumb,
    // ...
}

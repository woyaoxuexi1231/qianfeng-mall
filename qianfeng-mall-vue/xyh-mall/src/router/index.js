import Vue from 'vue'
import Router from 'vue-router'
import { routerBreadcrumb } from '@/utils/local-data'
import index from '@/view/index'
import Login from '@/view/Login'
import home from '@/view/home/index'
import order from '@/view/oms/order'
import orderDetail from '@/view/oms/orderDetail'
import deliverOrderList from '@/view/oms/deliverOrderList'
import orderSetting from '@/view/oms/orderSetting'
import returnApply from '@/view/oms/returnApply'
import returnReason from '@/view/oms/returnReason'
import store from '@/store'
import product from "../view/pms/product";
import editProduct from "../view/pms/editProduct";
import addProduct from "../view/pms/addProduct";
import display from "../view/display";
import shoppingCar from "../view/shoppingCar";
import displayGoods from "../view/displayGoods";
import orderDisplay from "../view/orderDisplay";
Vue.use(Router)
const router = new Router({
    routes: [
        {
            path: '/',
            name: 'Login',
            component: Login
        },
        {
            path: '/me',
            name: 'index',
            component: index,
            redirect: "/home",
            children: [
                {
                    path:'/home',
                    name:'home',
                    component:home,
                    meta:{
                        list:routerBreadcrumb.home.list
                    }
                },
                {
                    path:'/oms/order',
                    name:'order',
                    component:order,
                    meta:{
                        list:routerBreadcrumb.order.list
                    }
                },
                {
                    path:'/oms/orderDetail',
                    name:'orderDetail',
                    component:orderDetail,
                    meta:{
                        list:routerBreadcrumb.orderDetail.list
                    }
                },
                {
                    path:'/oms/deliverOrderList',
                    name:'deliverOrderList',
                    component:deliverOrderList,
                    meta:{
                        list:routerBreadcrumb.deliverOrderList.list
                    }
                },
                {
                    path:'/oms/orderSetting',
                    name:'orderSetting',
                    component:orderSetting,
                    meta:{
                        list:routerBreadcrumb.orderSetting.list
                    }
                },
                {
                    path:'/oms/returnApply',
                    name:'returnApply',
                    component:returnApply,
                    meta:{
                        list:routerBreadcrumb.returnApply.list
                    }
                },
                {
                    path:'/oms/returnReason',
                    name:'returnReason',
                    component:returnReason,
                    meta:{
                        list:routerBreadcrumb.returnReason.list
                    }
                },
              {
                path:'/pms/product',
                name:'product',
                component:product,
                meta:{
                  list:routerBreadcrumb.product.list
                }
              },
              {
                path:'/pms/editProduct',
                name:'editProduct',
                component:editProduct,
                meta:{
                  list:routerBreadcrumb.editProduct.list
                }
              },
              {
                path:'/pms/addProduct',
                name:'addProduct',
                component:addProduct,
                meta:{
                  list:routerBreadcrumb.addProduct.list
                }
              },
            ]
        },
      {
        path: '/shoppingCar',
        name: 'shoppingCar',
        component: shoppingCar
      },
      {
        path: '/displayGoods',
        name: 'displayGoods',
        component: displayGoods
      },{
        path: '/display',
        name: 'display',
        component: display
      },
      {
        path: '/orderDisplay',
        name:'orderDisplay',
        component: orderDisplay
      }
    ]
})
router.beforeEach((to, from, next) => {
    if (to.meta.list) {
        let list = to.meta.list
        store.commit('changeBreadcumb', { list })
    }
    next()
})

export default router



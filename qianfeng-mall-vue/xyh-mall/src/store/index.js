import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)

const state = {
  breadcumb: {}, // 面包屑
}
const mutations = {
  // 赋值面包屑
  changeBreadcumb (state, value) {
    state.breadcumb = value
  },
}

export default new Vuex.Store({
  state,
  mutations,
})
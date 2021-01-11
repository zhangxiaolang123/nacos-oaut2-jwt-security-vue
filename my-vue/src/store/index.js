import { getToken } from '@/util/auth'
import Vue from 'vue'
import Vuex from 'vuex'


Vue.use(Vuex)
export default new Vuex.Store({
  state: {
    token: getToken()
  },
  getters: {
    token:state =>{
      return state.token;
    } 
    
  },
  mutations: {
    setToken: (state, token) => {
      state.token = token
    },
  },


  actions: {
  },


  modules: {
  }
})



// const user = {
//   state: {
//     // user: {},
//     // status: '',
//     // code: '',
//     token: getToken(),
//     // id: 0,
//     // name: '',
//     // avatar: '',
//     // introduction: '',
//     // roles: [],
//     // menus: [], // 菜单权限
//     // // 按钮级权限管控 - ①新增 button 全局变量
//     // buttons: [], // 按钮权限
//     // setting: {
//     //   articlePlatform: []
//     // }
//   },

//   mutations: {
//     // SET_USER: (state, user) => {
//     //   state.user = user
//     // },
//     // SET_CODE: (state, code) => {
//     //   state.code = code
//     // },
//     setToken: (state, token) => {
//       state.token = token
//     },
//     // SET_INTRODUCTION: (state, introduction) => {
//     //   state.introduction = introduction
//     // },
//     // SET_SETTING: (state, setting) => {
//     //   state.setting = setting
//     // },
//     // SET_STATUS: (state, status) => {
//     //   state.status = status
//     // },
//     // SET_ID: (state, id) => {
//     //   state.id = id
//     // },
//     // SET_NAME: (state, name) => {
//     //   state.name = name
//     // },
//     // SET_AVATAR: (state, avatar) => {
//     //   state.avatar = avatar
//     // },
//     // SET_ROLES: (state, roles) => {
//     //   state.roles = roles
//     // },
//     // SET_MENUS: (state, menus) => {
//     //   state.menus = menus
//     // },
//     // // 按钮级权限管控 - ②新增 mutations 操作 button
//     // SET_BUTTONS: (state, buttons) => {
//     //   state.buttons = buttons
//     // }
//   },

//   actions: {
//   }
// }

// export default user

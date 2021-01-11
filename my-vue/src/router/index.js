import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Index from '../components/Index.vue'
import Book from '../components/Book.vue'
import Book2 from '../components/Book2.vue'
import Book3 from '../components/Book3.vue'
import BookUpdate from '../components/BookUpdate.vue'
import Login from '../components/login.vue'
import VueRouter from 'vue-router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
Vue.use(ElementUI);
Vue.use(Router)

 
  export default new Router({
    mode:'history',
    routes: [
      {
        path: '/b',
        name: '导航一',
        component: Index,
        // redirect默认加载/book
        redirect:"/book",
        show : true,
        children:[
          {
            path: '/book',
            name: '查询图书',
            component: Book,
            show : true,
          },
          {
            path: '/book2',
            name: '添加图书',
            component: Book2,
            show : true,
          },
          {
            path: '/update',
            component: BookUpdate,
            show : false
          },
        ]
      },
      // {
      //   path: '/bb',
      //   component: Index,
      //   show : false,
      //   children:[
      //     {
      //       path: '/update',
      //       component: BookUpdate,
      //     },
      //   ]
      // },

      {
        path: '/login',
        name: '登录',
        show : false,
        component: Login
      },

      
      {
        path: '/nav',
        name: '导航2',
        component: Index,
        show : true,
        children:[
          {
            path: '/book3',
            name: 'book3',
            component: Book3,
            show : true,
          }
        ]
      }
    ]
  })

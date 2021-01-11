import router from './router'

import { getToken } from '@/util/auth' 

//const whiteList = ['/login', '/auth-redirect' , '/qqLogin'] // no redirect whitelist -> 不重定向白名单

router.beforeEach((to, from, next) => {
  
  if (getToken()) {
   
              if (to.path === '/login' || to.path === '/' ) {
                router.push({path: '/b'});
              } else{
                next();
              }
  } else{
    
            if (to.path !== '/login') {  
              next({  
                path: '/login'  
              }) 
            }else {  
              next()  
            }  
  }
//  next();
})



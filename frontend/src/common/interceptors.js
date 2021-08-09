export function setInterceptors(instance){
  instance.interceptors.request.use(
    function(config){
      const token = localStorage.getItem('accessToken')
      if(token)
        config.headers.Authorization = "Bearer "+localStorage.getItem('accessToken')
      return config
    },
    function(err){
      return Promise.reject(err)
    }
  )

  //response interceptor
  instance.interceptors.response.use(
    function(res){
      return res
    },
    function(err){
      return Promise.reject(err)
    }
  )
  return instance
}

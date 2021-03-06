import { createRouter, createWebHistory } from 'vue-router'
import Home from '@/views/home/home'
// import ConferencesDetail from '@/views/conferences/conference-detail'
import CreateDealform from '@/views/create-deal-form/create-deal-form'
import UpdateDealForm from '@/views/products/update-deal-form'
import MyDeal from '@/views/mypage/my-deal'
import KeepDeal from '@/views/mypage/keep-deal'
import OrderDeal from '@/views/mypage/order-deal'
import UserInfo from '@/views/userInfo/userInfo'
import WebRTC from '@/views/webRTC/webRTC'
import MeetingDetail from '@/views/webRTC/meetingRoom'
import DealDetail from '@/views/deal-detail/deal-detail'

const fullMenu = require('@/views/main/menu.json')
// 리스트 이기 때문에 .map 사용
// key : menu.json의 key값
function makeRoutesFromMenu () {
  let routes = Object.keys(fullMenu).map((key) => {
    if (key === 'home') {
      return { path: fullMenu[key].path, name: key, component: Home  }
    } else if (key === 'create-deal-form') {
      return { path: fullMenu[key].path, name: key, component: CreateDealform }
    } else if (key === 'my-deal') {
      return { path: fullMenu[key].path, name: key, component: MyDeal }
    } else if (key === 'keep-deal') {
      return { path: fullMenu[key].path, name: key, component: KeepDeal }
    } else if (key === 'order-deal') {
      return { path: fullMenu[key].path, name: key, component: OrderDeal }
    } else if (key === 'user-info'){
      return { path: fullMenu[key].path, name: key, component: UserInfo}
    } else if(key==='webRTC'){
      return { path: fullMenu[key].path, name: key, component: WebRTC}
    } else {// menu.json 에 들어있는 로그아웃 메뉴
      return null
    }
  })
  // 로그아웃 파싱한 부분 제거
  routes = routes.filter(item => item)

  // menu 자체에는 나오지 않는 페이지 라우터에 추가(방 상세보기)
  routes.push({
    path: '/products/:productId',
    name: 'deal-detail',
    component: DealDetail,
  })

  routes.push({
    path:'/product/update-deal-form/:productId',
    name: 'update-deal-form',
    component: UpdateDealForm,
    props: true,
  })

  routes.push({
    path: '/high-price',
    name: 'price-high',
    component: Home
  })

  routes.push({
    path: '/low-price',
    name: 'price-low',
    component: Home
  })

  routes.push({
    path: '/reserve-time',
    name: 'reserve-time',
    component: Home
  })

  routes.push({
    path: '/:categories/:search',
    name: 'search',
    component: Home
  })

  routes.push({
    // path: '/meeting/:meetingId/:userId/:isSeller/:basePrice/:productId',
    // name: 'meeting-detail',
    // props: route =>({
    //   isSeller: Number(route.params.isSeller),
    //   basePrice: Number(route.params.basePrice),
    //   productId: Number(route.params.productId)
    // }),
    path: '/meeting/:meetingId/:userId',
    name: 'meeting-detail',
    component: MeetingDetail
  })
  // menu 자체에는 나오지 않는 페이지 라우터에 추가(게시글 상세보기))
  return routes
}

const routes = makeRoutesFromMenu()

const router = createRouter({
  history: createWebHistory(),
  routes,
})

router.afterEach((to) => {
  // console.log(to)
})

export default router

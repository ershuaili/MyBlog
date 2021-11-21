import {createStore} from 'vuex'

// vuex进行状态管理
export default createStore({
    // 用于存储数据
    state: {
        paginate:{
            // 数据总数
            messages:'',
            // 总共页数
            pageNum:'',
            // 当前展示页数
            pageShow:1,
        }
    },
    // 用于操作数据
    mutations: {},
    // 用于相应组件中的动作
    actions: {},

    modules: {}
})

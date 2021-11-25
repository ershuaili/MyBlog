import {createStore} from 'vuex'

// vuex进行状态管理
export default createStore({
    // 用于存储数据
    state: {
        paginate:{
            // 数据总数
            messages: '',
            // 总共页数
            pageNum: '',
            // 当前展示页数
            pageShow: 1,
        },
        BlogList:{}
    },

    // 用于操作数据
    mutations: {
        SetPageNum(state, value) {
            state.paginate.pageNum = value;
        },

        // 页面转跳
        REDUCE(state) {
            state.paginate.pageShow--
        },
        ADD(state) {
            state.paginate.pageShow++
        },
        JUMP(state, value) {
            state.paginate.pageShow = value;
        }
    },

    // 用于相应组件中的动作
    actions: {
        setPageNum(context, value) {
            context.commit("SetPageNum", value)
        },
        // 页面转跳
        pageReduce(context, value) {
            if (value <= 1) {
                alert("前面没有了")
            } else {
                context.commit("REDUCE")
            }
        },
        pageAdd(context, value) {
            if (value.pageShow >= value.pageNum) {
                alert("后面没有了")
            } else {
                context.commit("ADD")
            }
        },
        pageJump(context, value) {
            context.commit("JUMP", value)
        },
    },
    modules: {}
})

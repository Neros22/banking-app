import { createStore } from 'vuex'
import employees from './modules/employees'

export default createStore({
  modules: {
    employees
  }
})

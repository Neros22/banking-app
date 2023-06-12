import axios from 'axios';

export default {
    state: {
        employees: []
    },
    getters: {
        allEmployees: state => state.employees
    },
    mutations: {
        setEmployees: (state, employees) => (state.employees = employees),
        newEmployee: (state, employee) => state.employees.unshift(employee),
        removeEmployee: (state, id) => state.employees = state.employees.filter(employee => employee.id !== id),
        updateEmployee: (state, updatedEmployee) => {
            const index = state.employees.findIndex(employee => employee.id === updatedEmployee.id)
            if (index !== -1) {
                state.employees.splice(index, 1, updatedEmployee);
            }
        }
    },
    actions: {
        async fetchEmployees({ commit }) {
            const username = 'user'
            const password = ''

            const token = Buffer.from(`${username}:${password}`, 'utf8').toString('base64')
            const response = await axios.get('api/v1/employee/list', { headers: { 'Authorization': `Basic ${token}` } });
            commit('setEmployees', response.data);
        },
        async addEmployee({ commit }, employee) {
            const response = await axios.post('api/v1/employee/add', employee);
            commit('newEmployee', response.data)
        },
        async deleteEmployee({ commit }, id) {
            await axios.delete(`api/v1/employee/delete/${id}`);
            commit('removeEmployee', id);
        },
        async updateEmployee({ commit }, updatedEmployee) {
            const response = await axios.put('api/v1/employee/update', updatedEmployee);
            commit('updateEmployee', response.data);
        }
    },
}
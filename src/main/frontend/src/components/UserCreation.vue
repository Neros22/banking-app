<template>
  <div>
    <form>
      <legend v-if="!editClicked">Add a new employee</legend>
      <legend v-else>Update current employee details</legend>
      <input type="text" placeholder="Name" id="name" v-model="name" />
      <input type="email" placeholder="Email" id="email" v-model="email" />
      <input type="date" id="dob" v-model="dob" />
      <button v-if="!editClicked" @click="onSubmit" type="submit">
        Add Employee
      </button>
      <button v-else @click="onUpdate" type="submit">Update Employee</button>
    </form>
    <div id="employee" v-for="employee in allEmployees" :key="employee.id">
      <div id="name">
        {{ employee.name }}
      </div>
      <div id="email">
        {{ employee.email }}
      </div>
      <div id="age">
        {{ employee.age }}
      </div>
      <i @click="deleteEmployee(employee.id)" class="fas fa-trash-alt" />
      <i @click="editButtonClick(employee)" class="fas fa-user-edit" />
    </div>
  </div>
</template>

<script>
export default {
  name: "UserCreation",
  setup(){

    return {
      editClicked: false,
      onSubmit() {
        if (this.name !== "" && this.email !== "" && this.dob !== "") {
          const Employee = {
            name: this.name,
            email: this.email,
            dob: this.dob,
          };
          this.addEmployee(Employee);
        }
      },
      onUpdate() {
        if (this.name !== "" && this.email !== "" && this.dob !== "") {
          const updatedEmployee = {
            id: this.id,
            name: this.name,
            email: this.email,
            dob: this.dob,
          };
          this.updateEmployee(updatedEmployee);
        }
      },
      editButtonClick(employee) {
        this.editClicked = !this.editClicked;
        if (this.editClicked) {
          (this.id = employee.id),
            (this.name = employee.name),
            (this.email = employee.email),
            (this.dob = employee.dob);
        } else {
          (this.id = ""), (this.name = ""), (this.email = ""), (this.dob = "");
        }
      },
    };
  },

}
</script>

<style scoped>

</style>

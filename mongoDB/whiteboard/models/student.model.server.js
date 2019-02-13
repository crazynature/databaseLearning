const mongoose = require('mongoose')
const studentSchema = require('./student.schema.server')
const studentModel = mongoose.model
('StudentModel', studentSchema);


findAllUsers = () =>
    studentModel.find();
findUserById = userId =>
    studentModel.find({_id: userId})

createStudent = student =>
    studentModel.create(student)

updateStudent = (sid, student) =>
    studentModel
        .update({_id: sid},
            {$set: student})
deleteStudent = studentId =>
    studentModel
        .remove({_id: studentId})
deleteAllStudent = () =>
    studentModel.remove()
module.exports = { studentModel,findAllUsers,findUserById,createStudent,updateStudent,deleteStudent,deleteAllStudent}
const mongoose = require('mongoose')
const answerSchema = require('./answer.schema.server')

const answerModel = mongoose.model
('AnswerModel', answerSchema);


findAllAnswer = () =>
    answerModel.find()
findAnswerById = answerId =>
    answerModel.find({_id: answerId})

findAnswerByQuestion = questionId =>
    answerModel.find({question: questionId})

findAnswerByStudent = studentId =>
    answerModel.find({student: studentId})

createAnswer = answer =>
    answerModel.create(answer)

updateAnswer = (sid, answer) =>
    answerModel
        .update({_id: sid},
            {$set: answer})
deleteAnswer = answerId =>
    answerModel
        .remove({_id: answerId})

deleteAllAnswer = () =>
    answerModel.remove()
module.exports = { answerModel,findAllAnswer,findAnswerById,createAnswer,updateAnswer,deleteAnswer,deleteAllAnswer,findAnswerByQuestion,findAnswerByStudent}
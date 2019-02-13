const mongoose = require('mongoose')
const questionSchema = require('./question.schema.server')

const questionModel = mongoose.model
('QuestionModel', questionSchema);


findAllQuestion = () =>
    questionModel.find();
findQuestionById = questionId =>
    questionModel.find({_id: questionId})

createQuestion = question =>
    questionModel.create(question)

updateQuestion = (sid, question) =>
    questionModel
        .update({_id: sid},
            {$set: question})
deleteQuestion = questionId =>
    questionModel
        .remove({_id: questionId})

deleteAllQuestion = () =>
    questionModel.remove()
module.exports = { questionModel,findAllQuestion,findQuestionById,createQuestion,updateQuestion,deleteQuestion,deleteAllQuestion}
const mongoose = require('mongoose')
const quizWidgetSchema = require('./quiz-widget.schema.server')
const quizWidgetModel = mongoose.model
('QuizWidgetModel', quizWidgetSchema);


findAllQuizWidget = () =>
    quizWidgetModel.find();
findQuizWidgetById = quizWidgetId =>
    quizWidgetModel.find({_id: quizWidgetId})

createQuizWidget = quizWidget =>
    quizWidgetModel.create(quizWidget)

updateQuizWidget = (sid, quizWidget) =>
    quizWidgetModel
        .update({_id: sid},
            {$set: quizWidget})
deleteQuizWidget = quizWidgetId =>
    quizWidgetModel
        .remove({_id: quizWidgetId})
module.exports = { quizWidgetModel,findAllQuizWidget,findQuizWidgetById,createQuizWidget,updateQuizWidget,deleteQuizWidget}
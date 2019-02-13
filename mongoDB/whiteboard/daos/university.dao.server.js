var studentModel = require("../models/student.model.server");
var answerModel = require("../models/answer.model.server");
var questionModel = require("../models/question.model.server")
var studentMode = require("../models/student.model.server")


module.exports = {truncateDatabase,populateDatabase,createStudent,deleteStudent,createQuestion,
    deleteQuestion,answerQuestion,deleteAnswer,findAllStudents,findAllAnswer,findAllQuestion,findQuestionById
    ,findStudentById}
async function truncateDatabase() {
    await answerModel.deleteAllAnswer();
    await questionModel.deleteAllQuestion();
    await studentMode.deleteAllStudent();
    return studentMode.findAllUsers();
}

async function populateDatabase() {
    let alice = {
        _id: 123,
        username: 'alice',
        password: 'alice',
        firstName: 'Wlice',
        lastName: 'Wonderland',
        gradYear: 2020,
        scholarship :15000
}
    studentMode.createStudent(alice);
    let bob = {
        _id: 234,
        username: 'bob',
        password: 'bob',
        firstName: 'Bob',
        lastName: 'Hope',
        gradYear: 2021,
        scholarship:12000
    }
    studentMode.createStudent(bob);
    let t1 = {
        _id:321,
        isTrue:false
    }

    let q1={
        _id:321,
        question:'Is the following schema valid?',
        points:10,
        questionType: 'TRUE_FALSE',
        trueFalse:t1
    }
    questionModel.createQuestion(q1);
    let t2 = {
        _id:432,
        isTrue:false
    }

    let q2={
        _id:432,
        question:'DAO stands for Dynamic Access Object.',
        points:10,
        questionType: 'TRUE_FALSE',
        trueFalse:t2
    }
    questionModel.createQuestion(q2);

    let c1 ={
        _id:543,
        choices: 'Java Persistence API,Java Persisted Application,JavaScript Persistence API,JSON Persistent Associations',
        correct: 1
    }
    let q3={
        _id:543,
        question: 'What does JPA stand for?',
        points:10,
        questionType:'MULTIPLE_CHOICE',
        multipleChoice:c1
    }
    questionModel.createQuestion(q3);
    let c2 ={
        _id:654,
        choices: 'Object Relational Model,Object Relative Markup,Object Reflexive Model,Object Relational Mapping',
        correct: 4
    }
    let q4={
        _id:654,
        question: 'What does JPA stand for?',
        points:10,
        questionType:'MULTIPLE_CHOICE',
        multipleChoice:c2
    }
    questionModel.createQuestion(q4);

    let a1 = {
        _id:123,
        trueFalseAnswer:true,
        student:123,
        question:321
    }
    answerModel.createAnswer(a1);

    let a2 = {
        _id:234,
        trueFalseAnswer:false,
        student:123,
        question:432
    }
    answerModel.createAnswer(a2);

    let a3 = {
        _id:345,
        multipleChoiceAnswer:1,
        student:123,
        question:543
    }
    answerModel.createAnswer(a3);
    let a4 = {
        _id:456,
        multipleChoiceAnswer:2,
        student:123,
        question:654
    }
    answerModel.createAnswer(a4);
    let a5 = {
        _id:567,
        trueFalseAnswer:false,
        student:234,
        question:321
    }
    answerModel.createAnswer(a5);

    let a6 = {
        _id:678,
        trueFalseAnswer:true,
        student:234,
        question:432
    }
    answerModel.createAnswer(a6);

    let a7 = {
        _id:789,
        multipleChoiceAnswer:3,
        student:234,
        question:543
    }
    answerModel.createAnswer(a7);
    let a8 = {
        _id:890,
        multipleChoiceAnswer:4,
        student:234,
        question:654
    }
    answerModel.createAnswer(a8);
    return studentModel.findAllUsers();
}
function createStudent(student) {
   return studentModel.createStudent(student)
        .then(function (student) {
            return student;
        });
}

function deleteStudent(id) {
   return studentModel.deleteStudent(id)
        .then(function (student) {
            return student;
        })
}

function createQuestion(question) {
   return questionModel.createQuestion(question)
        .then(function (question) {
            return question;
        });
}

function deleteQuestion(id) {
    return questionModel.deleteQuestion(id)
        .then(function (question) {
            return question;
        })
}
function answerQuestion(studentId,questionId,answer) {
    // var id = answer._id;
    answerModel.createAnswer(answer)
        .then(function (answer) {
            return answer;
        });
    // no reason to use these two Ids. the input answer should include them.
    // answerModel.updateAnswer({studentId: studentId,questionId:questionId});
}

function deleteAnswer(id) {
    answerModel.deleteAnswer(id)
        .then(function (answer) {
            return answer;
        })
}

function findAllStudents() {
    var result = studentModel.findAllUsers();
    return result;
}

function findStudentById(id) {
    var result = studentModel.findUserById(id);
    return result;
}

function findAllQuestion() {
    var result = questionModel.findAllQuestion();
    return result;
}

function findQuestionById(id) {
    var result = questionModel.findQuestionById(id);
    return result;
}

function findAllAnswer(){
    var resullt =   answerModel.findAllAnswer()
        .populate('student')
        .populate('question')
    return resullt;
}




function  findAnswerById(id) {
    var result = answerModel.findAnswerById(id)
        .populate('student')
        .populate('question');
    return result;
}

function findAnswerByStudent(studentId) {
    var result = answerModel.findAnswerByStudent(studentId)
        .populate('student')
        .populate('question');
    return result;
}

function findAnswerByQuestion(questionId) {
    var result = answerModel.findAnswerByQuestion(questionId)
        .populate('student')
        .populate('question');
    return result;
}

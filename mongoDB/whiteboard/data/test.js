require('./db')();
const assert = require('assert');
var universityDao = require
('../daos/university.dao.server');


const assertEquals = (actual, expected) => {
    assert.strictEqual(actual, expected, 'This is a helpful error message');
};

 testStudentsInitialCount = () => {
    universityDao.findAllStudents() // make sure this calls .exec() or .then() can have slightly different behavior (typically it will be okay but this is consistent)
        .then(students => {
            assertEquals(students.length, 2); // the test
        })
        .then(() => console.log('testStudentsInitialCount success')) // success
        .catch(err => console.log('testStudentsInitialCount error')); // failure - use err.message to see the helpful message you made in assert
};

 testQuestionsInitialCount = () => {
    universityDao.findAllQuestion() // make sure this calls .exec() or .then() can have slightly different behavior (typically it will be okay but this is consistent)
        .then(question  => {
            assertEquals(question.length, 4); // the test
        })
        .then(() => console.log('testQuestionsInitialCount success')) // success
        .catch(err => console.log('testQuestionsInitialCount error')); // failure - use err.message to see the helpful message you made in assert
};

 testAnswersInitialCount = () => {
    universityDao.findAllAnswer()// make sure this calls .exec() or .then() can have slightly different behavior (typically it will be okay but this is consistent)
        .then(answer  => {
            assertEquals(answer.length,8); // the test
        })
        .then(() => console.log('testAnswersInitialCount success')) // success
        .catch(err => console.log('testAnswersInitialCount error')); // failure - use err.message to see the helpful message you made in assert
};

 testDeleteAnswer = async () => {
    await universityDao.deleteAnswer(890)
    universityDao.findAllAnswer() // make sure this calls .exec() or .then() can have slightly different behavior (typically it will be okay but this is consistent)
        .then(answer  => {
            assertEquals(answer.length, 7); // the test
        })
        .then(() => console.log('testDeleteAnswer success')) // success
        .catch(err => console.log('testDeleteAnswer error')); // failure - use err.message to see the helpful message you made in assert
};

 testDeleteStudent =async () => {
    await universityDao.deleteStudent(234);
    universityDao.findAllStudents() // make sure this calls .exec() or .then() can have slightly different behavior (typically it will be okay but this is consistent)
        .then(students => {
            assertEquals(students.length, 1); // the test
        })
        .then(() => console.log('testDeleteStudent success')) // success
        .catch(err => console.log('testDeleteStudent error')); // failure - use err.message to see the helpful message you made in assert
};

 testDeleteQuestion = async () => {
    await universityDao.deleteQuestion(321);
    universityDao.findAllQuestion() // make sure this calls .exec() or .then() can have slightly different behavior (typically it will be okay but this is consistent)
        .then(question  => {
            assertEquals(question.length, 3); // the test
        })
        .then(() => console.log('testDeleteQuestion success')) // success
        .catch(err => console.log('testDeleteQuestion error')); // failure - use err.message to see the helpful message you made in assert
};

//If I run the test manually, all of them can pass.
//so you may need to comment some tests and run them one by one
// universityDao.truncateDatabase();
// universityDao.populateDatabase();
// testStudentsInitialCount();
// testQuestionsInitialCount();
// testAnswersInitialCount();
// testDeleteAnswer();
// testDeleteQuestion();
// testDeleteStudent();


 initTest = async () => {
     await universityDao.truncateDatabase();
     await universityDao.populateDatabase();
     console.log("init success");

}
findTest = async () =>{
await testStudentsInitialCount();
await testQuestionsInitialCount();
await testAnswersInitialCount();}

deleteTest = async () => {
    await testDeleteAnswer();
    await testDeleteQuestion();
    await testDeleteStudent();
 }
allTest = async () => {
    await initTest();
    await findTest();
    await deleteTest();
}

module.exports = {initTest,findTest,deleteTest}
var t = require('../data/test')
t.initTest();
//  t.findTest();
//  t.deleteTest()

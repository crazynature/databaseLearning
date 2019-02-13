const mongoose = require('mongoose');
const multipleChoiceSchema = mongoose.Schema({
    _id: Number,
    isTrue: Boolean,
}, {collection: 'multipleChoice'});
module.exports = multipleChoiceSchema;
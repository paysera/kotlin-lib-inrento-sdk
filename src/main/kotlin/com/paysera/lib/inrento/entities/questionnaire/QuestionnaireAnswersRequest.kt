package com.paysera.lib.inrento.entities.questionnaire

data class QuestionnaireAnswersRequest(
    val question1: String,
    val question2: String,
    val question3: String,
    val question4: String,
    val question5: String,
    val question6: List<String>,
    val question7: List<String>,
    val question8: String,
    val question9: String,
    val question10: String,
    val question11: String,
    val question11More: String? = null
)
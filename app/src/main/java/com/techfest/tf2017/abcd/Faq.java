package com.techfest.tf2017.abcd;

/**
 * Created by Abhishek on 18-12-2017.
 */

public class Faq {
    private String question;
    private String answer;

    public Faq() {

    }

    public Faq(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}

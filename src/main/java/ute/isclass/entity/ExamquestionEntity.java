package ute.isclass.entity;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "examquestion")
public class ExamquestionEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exaquestionID")
    private int exaQuestionID;

    @Column(name = "part")
    private int num;

    @Column(name = "audio")
    private String audio;

    @Column(name = "image")
    private String image;

    @Column(name = "paragraph")
    private String paragrah;

    @Column(name = "question")
    private String question;

    @Column(name = "option1")
    private String option1;

    @Column(name = "option2")
    private String option2;

    @Column(name = "option3")
    private String option3;

    @Column(name = "option4")
    private String option4;

    @Column(name = "correctanswer")
    private String correctAnswer;
}

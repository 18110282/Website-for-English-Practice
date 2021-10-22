package ute.isclass.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "resultexamination")
public class ResultExaminationEntity implements Serializable {
    @Column(name = "numcorrect")
    private int numCorrect;

    @Column(name = "numincorrect")
    private int numIncorrect;
}

package ute.isclass.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "historyexam")
public class HistoryExamEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "historyexamID")
    private int historyExamID;

    @Column(name = "timetest")
    private Timestamp timeTest;

}

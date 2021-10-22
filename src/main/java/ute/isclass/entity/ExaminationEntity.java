package ute.isclass.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "examination")
public class ExaminationEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "examinationID")
    private int examinationID;

    @Column(name = "examinationname")
    private String examinationName;

    @Column(name = "examinationimage")
    private String examinationImage;

    @Column(name = "createdate")
    private Timestamp createDate;
}

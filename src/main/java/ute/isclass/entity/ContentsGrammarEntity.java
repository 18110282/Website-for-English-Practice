package ute.isclass.entity;

import javax.persistence.*;
import java.io.Serializable;



@Entity
@Table(name = "contentsgrammar")
public class ContentsGrammarEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grammarID")
    private int grammarID;

    @Column(name = "sectionname")
    private String sectionName;

    @Column(name = "contents")
    private String contents;

}

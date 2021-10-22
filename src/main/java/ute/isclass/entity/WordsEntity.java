package ute.isclass.entity;

import javax.persistence.*;

@Entity
@Table(name = "words")
public class WordsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wordID")
    private int wordID;

    @Column(name = "num")
    private int num;

    @Column(name = "content")
    private String content;

    @Column(name = "translate")
    private String translate;

    @Column(name = "wordimage")
    private String wordImage;

    @Column(name = "pronounce")
    private String pronounce;

    @Column(name = "typeword")
    private int typeWord;
}

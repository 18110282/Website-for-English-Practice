package ute.isclass.entity;

import javax.persistence.*;

@Entity
@Table(name ="topicgrammar")
public class TopicGrammarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topicgrammarID")
    private int topicGrammarID;

    @Column(name = "grammarname")
    private String grammarName;

    @Column(name = "grammarimage")
    private String grammarImage;
}

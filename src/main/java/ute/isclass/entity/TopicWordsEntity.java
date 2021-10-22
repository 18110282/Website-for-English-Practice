package ute.isclass.entity;


import javax.persistence.*;

@Entity
@Table(name = "topicwords")
public class TopicWordsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topicwordID")
    private int topicWordID;

    @Column(name = "topicname")
    private String topicName;

    @Column(name = "topicwordimage")
    private String topicWordImage;
}

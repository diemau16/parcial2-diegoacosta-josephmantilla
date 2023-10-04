package co.edu.unisabana.parcialarquitectura.repository.entity;

import co.edu.unisabana.parcialarquitectura.service.model.Checkin;
import java.time.LocalDateTime;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "CHECKPOINT")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CheckpointEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column
  private String type;

  @Column
  private String facility;

  @Column
  private String driver;

  @Column
  private int dayOfMonth;

  @Column
  private LocalDateTime creationDate;

  @Column
  private boolean finalized;



}
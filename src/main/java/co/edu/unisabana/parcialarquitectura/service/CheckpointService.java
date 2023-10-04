package co.edu.unisabana.parcialarquitectura.service;

import co.edu.unisabana.parcialarquitectura.controller.dto.CheckpointDTO;
import co.edu.unisabana.parcialarquitectura.repository.entity.CheckpointEntity;
import co.edu.unisabana.parcialarquitectura.repository.jpa.CheckpointRepository;
import co.edu.unisabana.parcialarquitectura.service.model.Checkin;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class CheckpointService {
  public CheckpointService(CheckpointRepository checkpointRepository) {
    this.checkpointRepository = checkpointRepository;
  }

  CheckpointRepository checkpointRepository;


  public void checkin(CheckpointDTO checkpoint) {
    if (checkpoint.dayOfMonth > 30 || checkpoint.dayOfMonth < 1) {
      throw new IllegalArgumentException("Invalid date");
    }
    Checkin checkin = new Checkin(checkpoint.facility, checkpoint.driver, checkpoint.dayOfMonth);
    saveCheckin(checkin);

  }

  public void saveCheckin(Checkin checkin) {
    checkpointRepository.save(fromCheckin(checkin));
  }

  public static CheckpointEntity fromCheckin(Checkin checkin) {
    CheckpointEntity checkpoint = new CheckpointEntity();
    checkpoint.setCreationDate(LocalDateTime.now());
    checkpoint.setDriver(checkin.getDriver());
    checkpoint.setFacility(checkin.getFacility());
    checkpoint.setDayOfMonth(checkin.getDayOfMonth());
    checkpoint.setType("CHECKIN");
    checkpoint.setFinalized(false);
    return checkpoint;
  }
}

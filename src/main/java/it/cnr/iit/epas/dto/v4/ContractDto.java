package it.cnr.iit.epas.dto.v4;

import com.google.common.collect.Lists;
import it.cnr.iit.epas.models.VacationPeriod;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ContractDto extends BaseModelDto {

  private String perseoId;

  private String externalId;

  /**
   * Patch per gestire i contratti con dati mancanti da dcp. E' true unicamente per segnalare tempo
   * determinato senza data fine specificata.
   */
  private boolean isTemporaryMissing;

  /*
   * Quando viene valorizzata la sourceDateResidual, deve essere valorizzata
   * anche la sourceDateMealTicket
   */
  private LocalDate sourceDateResidual;
  private LocalDate sourceDateVacation;
  private LocalDate sourceDateMealTicket;
  private LocalDate sourceDateRecoveryDay;
  private boolean sourceByAdmin = true;

  private Integer sourceVacationLastYearUsed = null;
  private Integer sourceVacationCurrentYearUsed = null;

  private Integer sourcePermissionUsed = null;

  // Valore puramente indicativo per impedire che vengano inseriti i riposi compensativi in minuti
  private Integer sourceRecoveryDayUsed = null;
  private Integer sourceRemainingMinutesLastYear = null;
  private Integer sourceRemainingMinutesCurrentYear = null;
  private Integer sourceRemainingMealTicket = null;

  //data di termine contratto in casi di licenziamento, pensione, morte, ecc ecc...
  private LocalDate endContract;

  private List<VacationPeriodDto> vacationPeriods = Lists.newArrayList();


}

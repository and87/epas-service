/*
 * Copyright (C) 2022  Consiglio Nazionale delle Ricerche
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as
 *     published by the Free Software Foundation, either version 3 of the
 *     License, or (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package it.cnr.iit.epas.dto.v4.mapper;

import it.cnr.iit.epas.dto.v4.AbsencePeriodDto;
import it.cnr.iit.epas.dto.v4.AbsenceShowTerseDto;
import it.cnr.iit.epas.dto.v4.ComplationAbsenceDto;
import it.cnr.iit.epas.dto.v4.ContractShowDto;
import it.cnr.iit.epas.dto.v4.DayInPeriodDto;
import it.cnr.iit.epas.dto.v4.PeriodChainDto;
import it.cnr.iit.epas.dto.v4.PersonVacationDto;
import it.cnr.iit.epas.dto.v4.TakenAbsenceDto;
import it.cnr.iit.epas.dto.v4.VacationCodeDto;
import it.cnr.iit.epas.dto.v4.VacationPeriodDto;
import it.cnr.iit.epas.dto.v4.VacationSituationDto;
import it.cnr.iit.epas.dto.v4.VacationSummaryTerseDto;
import it.cnr.iit.epas.manager.recaps.personvacation.PersonVacationRecap;
import it.cnr.iit.epas.manager.services.absences.model.AbsencePeriod;
import it.cnr.iit.epas.manager.services.absences.model.ComplationAbsence;
import it.cnr.iit.epas.manager.services.absences.model.DayInPeriod;
import it.cnr.iit.epas.manager.services.absences.model.PeriodChain;
import it.cnr.iit.epas.manager.services.absences.model.TakenAbsence;
import it.cnr.iit.epas.manager.services.absences.model.VacationSituation;
import it.cnr.iit.epas.manager.services.absences.model.VacationSituation.VacationSummary;
import it.cnr.iit.epas.models.Contract;
import it.cnr.iit.epas.models.VacationPeriod;
import it.cnr.iit.epas.models.absences.Absence;
import it.cnr.iit.epas.models.enumerate.VacationCode;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapping delle informazioni per il riepilogo di un mese lavorativo
 * in un DTO da esportare via REST.
 *
 * @author cristian
 *
 */
@Mapper(componentModel = "spring")
public interface PersonVacationMapper {

  @Mapping(target = "justifiedType", source = "justifiedType.name")
  @Mapping(target = "externalId", source = "externalIdentifier")
  @Mapping(target = "justifiedTime", expression = "java(absence.justifiedTime())")
  @Mapping(target = "date", source = "personDay.date")
  AbsenceShowTerseDto convert(Absence absence);

  @Mapping(target = "topQualification", source = "person.topQualification")
  PersonVacationDto convert(PersonVacationRecap personVacation);

  VacationCodeDto convert(VacationCode vacationCode);

  @Mapping(target = "takableWithLimit", expression = "java(period.isTakableWithLimit())")
  @Mapping(target = "periodTakableAmount", expression = "java(period.getPeriodTakableAmount())")
  @Mapping(target = "remainingAmount", expression = "java(period.getRemainingAmount())")
  AbsencePeriodDto convert(AbsencePeriod period);

  @Mapping(target = "absence.justifiedType", source = "absence.justifiedType.name")
  TakenAbsenceDto convert(TakenAbsence takenAbsences);
  @Mapping(target = "absence.justifiedType", source = "absence.justifiedType.name")
  ComplationAbsenceDto convert(ComplationAbsence complationAbsence);

  //@Mapping(target = "absence.justifiedType", source = "absence.justifiedType.name")
  DayInPeriodDto convert(DayInPeriod daysInPeriod);

  PeriodChainDto convert(PeriodChain periodChain);

  @Mapping(target = "personId", source = "person.id")
  VacationSituationDto convert(VacationSituation vacationSituation);

  @Mapping(target = "personId", source = "person.id")
  ContractShowDto convert(Contract contract);

  @Mapping(target = "vacationCode", expression = "java(vacationPeriod.getLabel())")
  VacationPeriodDto convert(VacationPeriod vacationPeriod);

  @Mapping(target = "total", expression = "java(vacationSummary.total())")
  @Mapping(target = "accrued", expression = "java(vacationSummary.accrued())")
  @Mapping(target = "used", expression = "java(vacationSummary.used())")
  @Mapping(target = "usableTotal", expression = "java(vacationSummary.usableTotal())")
  @Mapping(target = "usable", expression = "java(vacationSummary.usable())")
  @Mapping(target = "title", expression = "java(vacationSummary.title())")
  VacationSummaryTerseDto convert(VacationSummary vacationSummary);

}
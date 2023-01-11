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
package it.cnr.iit.epas.dto.v4;

import com.google.common.collect.Maps;
import it.cnr.iit.epas.manager.services.absences.model.DayInPeriod;
import it.cnr.iit.epas.models.absences.AmountType;
import it.cnr.iit.epas.models.absences.GroupAbsenceType;
import it.cnr.iit.epas.models.absences.GroupAbsenceType.PeriodType;
import it.cnr.iit.epas.models.absences.InitializationGroup;
import java.time.LocalDate;
import java.util.SortedMap;
import lombok.Data;

@Data
public class GroupAbsenceTypeDto {
  private Long id;
  private String name;
  private String description;
  private String chainDescription;

  private boolean initializable;
  private PeriodType periodType;
  private GroupAbsenceTypeDto nextGroupToCheck;
}
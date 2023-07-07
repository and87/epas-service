/*
 * Copyright (C) 2023  Consiglio Nazionale delle Ricerche
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

import it.cnr.iit.epas.dto.v4.AbsenceShowTerseDto;
import it.cnr.iit.epas.dto.v4.PersonDayDto;
import it.cnr.iit.epas.models.PersonDay;
import it.cnr.iit.epas.models.absences.Absence;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper da PersonDay al suo DTO per la visualizzazione via REST.
 * Contiene anche il mapping delle assenze associate al PersonDay.
 */
@Mapper(componentModel = "spring")
public interface PersonDayMapper {

  @Mapping(target = "personId", source = "person.id")
  PersonDayDto convert(PersonDay personDay);
  
  @Mapping(target = "justifiedType", source = "justifiedType.name")
  @Mapping(target = "externalId", source = "externalIdentifier")
  @Mapping(target = "justifiedTime", expression = "java(absence.justifiedTime())")
  @Mapping(target = "nothingJustified", expression = "java(absence.nothingJustified())")
  AbsenceShowTerseDto convert(Absence absence);
}
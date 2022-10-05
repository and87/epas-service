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
package it.cnr.iit.epas.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PersonShowDto extends PeriodModelDto {

  private Long perseoId;
  private String name;
  private String surname;
  private String othersSurnames;
  private String fiscalCode;
  private LocalDate birthday;
  private String email;
  private Long userId;
  private String number;
  private Long oldId;
  private String eppn;
  private String telephone;
  private String fax;

  private String mobile;

  private boolean wantEmail;
  private LocalDateTime updatedAt;

  private Long officeId;

}

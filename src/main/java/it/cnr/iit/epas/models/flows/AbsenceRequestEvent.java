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

package it.cnr.iit.epas.models.flows;

import it.cnr.iit.epas.models.User;
import it.cnr.iit.epas.models.base.BaseEntity;
import it.cnr.iit.epas.models.flows.enumerate.AbsenceRequestEventType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.joda.time.LocalDateTime;

/**
 * Eventi relativi al flusso di approvazione di un'assenza.
 */
@Getter
@Builder
@ToString
@Entity
@Table(name = "absence_request_events")
public class AbsenceRequestEvent extends BaseEntity {

  private static final long serialVersionUID = 8098464195779075326L;

  @NotNull
  @Column(name = "created_at")
  public LocalDateTime createdAt;

  @NotNull
  @ManyToOne(optional = false)
  @JoinColumn(name = "absence_request_id")
  private AbsenceRequest absenceRequest;

  @NotNull
  @ManyToOne
  private User owner;
  
  private String description;
  
  @NotNull
  @Enumerated(EnumType.STRING)
  private AbsenceRequestEventType eventType;

  @PrePersist
  private void onUpdate() {
    if (createdAt == null) {
      createdAt = LocalDateTime.now();
    }
  }
}
/*
 * Copyright (c) 2024. Departamento de Ingenieria de Sistemas y Computacion
 */

package cl.ucn.disc.dsm.pictwin.model;

import com.github.f4b6a3.ulid.UlidCreator;

import io.ebean.annotation.Index;
import io.ebean.annotation.SoftDelete;
import io.ebean.annotation.WhenCreated;
import io.ebean.annotation.WhenModified;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/** Base Model. */
@ToString
@MappedSuperclass
public abstract class BaseModel {

    /** The Id. */
    @Getter @Setter @Id private Long id;

    /** The ULID. */
    @Getter
    @Index(unique = true)
    @Column(length = 26)
    private final String ulid = UlidCreator.getUlid().toLowerCase();

    /** The Version. */
    @Getter @Setter @Version private Long version;

    /** The CreatedAt. */
    @Getter @Setter @WhenCreated private Long createdAt;

    /** The ModifiedAt. */
    @Getter @Setter @WhenModified private Long modifiedAt;

    /** The Deleted. */
    @SoftDelete private Boolean deleted;
}
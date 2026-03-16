package br.com.infnet.ricknmortyapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Character entity mapped to the CHARACTERS table. */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "CHARACTERS")
public class Personagem implements Serializable {

    /** Unique identifier. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Character name. */
    @Column(name = "name", nullable = false)
    private String name;

    /** Character status. */
    @Column(name = "status")
    private String status;

    /** Character species. */
    @Column(name = "species")
    private String species;

    /** Character type. */
    @Column(name = "type")
    private String type;

    /** Character gender. */
    @Column(name = "gender")
    private String gender;

    /** Character origin. */
    @Column(name = "origin")
    private String origin;

    /** Last known location. */
    @Column(name = "location")
    private String location;

    /** Character image URL. */
    @Column(name = "image")
    private String image;

    /** Number of episodes featuring this character. */
    @Column(name = "episode_count")
    private Integer episodeCount;
}

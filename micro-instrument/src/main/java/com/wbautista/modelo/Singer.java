package com.wbautista.modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "singer")
@NamedQueries({
    @NamedQuery(name = Singer.FIND_SINGER_BY_ID,
            query = "select distinct s from Singer s " +
                    "left join fetch s.albums a " +
                    "left join fetch s.instruments i " +
                    "where s.id = :id"),
    @NamedQuery(name = Singer.FIND_ALL_WITH_ALBUM,
            query = "select distinct s from Singer s " +
                    "left join fetch s.albums a " +
                    "left join fetch s.instruments i")
})
public class Singer implements Serializable{
	public static final String FIND_SINGER_BY_ID = "Singer.findById";
    public static final String FIND_ALL_WITH_ALBUM = "Singer.findAllWithAlbum";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "FIRST_NAME", length = 60)
    private String firstName;

    @Column(name = "LAST_NAME", length = 40)
    private String lastName;

    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTH_DATE", length = 7)
    private Date birthDate;

    @Version
    private int version;

    @OneToMany(mappedBy = "singer", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Album> albums = new HashSet<>(0);

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "singer_instrument",
            joinColumns = @JoinColumn(name = "SINGER_ID"),
            inverseJoinColumns = @JoinColumn(name = "INSTRUMENT_ID"))
    private Set<Instrument> instruments = new HashSet<>();

    public boolean addAbum(Album album) {
        album.setSinger(this);
        return getAlbums().add(album);
    }

    public void removeAlbum(Album album) {
        album.setSinger(null);
        getAlbums().remove(album);
    }

    public String toString() {
        return "Singer - Id: " + id + ", First name: " + firstName
                + ", Last name: " + lastName + ", Birthday: " + birthDate;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Set<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(Set<Album> albums) {
		this.albums = albums;
	}

	public Set<Instrument> getInstruments() {
		return instruments;
	}

	public void setInstruments(Set<Instrument> instruments) {
		this.instruments = instruments;
	}

	public static String getFindSingerById() {
		return FIND_SINGER_BY_ID;
	}

	public static String getFindAllWithAlbum() {
		return FIND_ALL_WITH_ALBUM;
	}

	public void addInstrument(Instrument instrument) {
        getInstruments().add(instrument);
    }
}
